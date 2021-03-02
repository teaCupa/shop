package org.yh.shop.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.yh.shop.dao.TbSeckillOrderDao;
import org.yh.shop.model.TbSeckillOrder;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yh
 * @Date: 2021/2/25
 * @Description:
 */

@Component
public class MQReceiver {
    private static final Logger log = LoggerFactory.getLogger(MQReceiver.class);
    @Autowired
    TbSeckillOrderDao seckillOrderDao;
    @Autowired
    RedisTemplate redisTemplate;
    /**
     * {@link org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration}
     *  会自动识别
     * @param objectMapper json序列化实现类
     * @return mq 消息序列化工具
     */
    @Bean
    public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @RabbitListener(queues = SecKillOrderRabbitConfig.QUEUENAME)
    public void handleSecKillOrderMessage(TbSeckillOrder seckillOrder){
        log.info("收到消息："+seckillOrder);
        seckillOrder.setStatus("1");  //成功下单
        //更改订单查询状态
        redisTemplate.opsForValue().set("SecKillOrderStatus_"+seckillOrder.getTransactionId(),"1",300, TimeUnit.SECONDS);
        seckillOrderDao.insertSelective(seckillOrder);
    }

}
