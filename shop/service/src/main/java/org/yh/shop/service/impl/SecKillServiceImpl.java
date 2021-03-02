package org.yh.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.yh.shop.dao.TbSeckillGoodsDao;
import org.yh.shop.model.TbSeckillGoods;
import org.yh.shop.service.SecKillService;
import org.yh.shop.utils.DateUtil;

import java.util.List;

/**
 * @Author: yh
 * @Date: 2021/2/22
 * @Description:
 */

@Service
public class SecKillServiceImpl  implements SecKillService {
    @Autowired
    TbSeckillGoodsDao seckillGoodsDao;
    @Autowired
    RedisTemplate redisTemplate;
    /**
     *根据时间点查询秒杀商品
     * @return
     */
    @Override
    public List<TbSeckillGoods> findSecKillGoods(String time) {
        List<TbSeckillGoods> seckillGoods = redisTemplate.boundHashOps("SecKillGoods_" + time).values();
        if(seckillGoods!=null && seckillGoods.size()>0){
            return seckillGoods;
        }
        return seckillGoodsDao.findAll(DateUtil.str2Date(time,"yyyyMMddHH"));
    }
}
