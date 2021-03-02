package org.yh.shop.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.yh.shop.model.TbSeckillGoods;
import org.yh.shop.service.SecKillService;
import org.yh.shop.utils.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: yh
 * @Date: 2021/2/23
 * @Description:
 */

@Component
public class LoadSecKillGoodsTask {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    SecKillService secKillService;

    /**
     * 定时将秒杀商品加载到redis
     */
    @Scheduled(cron = "* * 0/1 * * ? ")
    void loadSecKillGoodsToRedis(){
        List<Date> dateMenus = DateUtil.getDateMenus();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        for (Date date : dateMenus) {
            List<TbSeckillGoods> secKillGoods = secKillService.findSecKillGoods(sdf.format(date));
            String format ="SecKillGoods_"+ sdf.format(date);
            for (TbSeckillGoods secKillGood : secKillGoods) {
                redisTemplate.opsForHash().put(format,secKillGood.getSpuId().toString(),secKillGood);
                //装载秒杀商品库存到redis
                redisTemplate.opsForValue().set("secKillStock_"+secKillGood.getSpuId(),secKillGood.getStockCount());
            }
        }
    }



}
