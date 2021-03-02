package org.yh.shop.service.impl;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yh.shop.dao.TbSeckillOrderDao;
import org.yh.shop.model.TbSeckillGoods;
import org.yh.shop.model.TbSeckillOrder;
import org.yh.shop.model.vo.CartVo;
import org.yh.shop.service.SecKillOrderService;
import org.yh.shop.utils.IdWorker;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yh
 * @Date: 2021/2/24
 * @Description:
 */

@Service
public class SecKillOrderServiceImpl implements SecKillOrderService {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    TbSeckillOrderDao seckillOrderDao;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)  //事务操作
    public String addSecKillOrder(CartVo cartVo) {
        //是否秒杀过该商品-->这里允许多次秒杀
        String spuId = cartVo.getSpuId();
        String time = cartVo.getSecKillChannel();
        //减库存，redis原子操作,保证并发请求的数据正确
        Long res = redisTemplate.opsForValue().decrement("secKillStock_" + spuId);
        System.out.println("###库存剩余："+res);
        if(res<0){
            //已售罄
            return null;
        }
        TbSeckillGoods seckillGoods = (TbSeckillGoods) redisTemplate.opsForHash().get("SecKillGoods_" + time, spuId);

        //异步下单,发送消息给消息队列处理
        TbSeckillOrder seckillOrder = new TbSeckillOrder();
        seckillOrder.setCreateTime(new Date());
        seckillOrder.setTransactionId(String.valueOf(new IdWorker().nextId()));
        assert seckillGoods != null;
        seckillOrder.setMoney(seckillGoods.getCostPrice());
        seckillOrder.setSeckillId(Long.valueOf(spuId));
        seckillOrder.setStatus("0");
        seckillOrder.setUserId(cartVo.getUserId());

//        seckillOrderDao.insertSelective(seckillOrder);
        redisTemplate.opsForValue().set("SecKillOrderStatus_"+seckillOrder.getTransactionId(),"0",300, TimeUnit.SECONDS);
        sendMQMessage(seckillOrder);
        return seckillOrder.getTransactionId();
    }

    @Override
    public String queryOrderStatus(String orderTrancId) {
        return (String) redisTemplate.opsForValue().get("SecKillOrderStatus_"+orderTrancId);
    }

    @Override
    public TbSeckillOrder getSecKillOrder(String orderTrancId) {
        return seckillOrderDao.selectOne(orderTrancId);
    }

    void sendMQMessage(TbSeckillOrder seckillOrder){
         final String DIRECTEXCHANGENAME ="directExchangeName";
        final  String ROUTINGKEY ="directRouteKey";
        //设置消息传输格式为JSON->见MQReceiver的MessageConverter配置
        rabbitTemplate.setExchange(DIRECTEXCHANGENAME);
        rabbitTemplate.convertAndSend(ROUTINGKEY, seckillOrder, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                MessageProperties messageProperties = message.getMessageProperties();
                messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);//设置消息持久化
                messageProperties.setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME,
                        TbSeckillOrder.class);    //设置消息的类型
                return message;
            }
        });
    }
}
