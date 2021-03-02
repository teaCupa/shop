package org.yh.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.yh.shop.model.TbSeckillGoods;

@SpringBootTest
class ShopApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
//        System.out.println(UUID.randomUUID().toString());
         TbSeckillGoods seckillGoods = (TbSeckillGoods) redisTemplate.opsForHash().get("SecKillGoods_2021022514","100022101");
        System.out.println(seckillGoods);
//        TbSeckillGoods seckillGoods2 = (TbSeckillGoods) redisTemplate.boundHashOps("SecKillGoods_2021022422").get(100022101);
//        System.out.println(seckillGoods2);

        Integer stockCount =  (Integer) redisTemplate.opsForValue().get("secKillStock_100022101");
        System.out.println(stockCount);
//        Long res = redisTemplate.opsForValue().decrement("secKillStock_111");
//        System.out.println("res: "+res);   //-1
//        redisTemplate.opsForValue().set("secKillStock_111",1);
//        res = redisTemplate.opsForValue().decrement("secKillStock_111");
//        System.out.println(res);       //0
//        res = redisTemplate.opsForValue().decrement("secKillStock_111");
//        System.out.println(res);       //-1


    }

}
