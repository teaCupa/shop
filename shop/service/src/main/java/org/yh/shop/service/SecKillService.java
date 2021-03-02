package org.yh.shop.service;

import org.yh.shop.model.TbSeckillGoods;

import java.util.List;

/**
 * @Author: yh
 * @Date: 2021/2/22
 * @Description:
 */


public interface SecKillService {
    List<TbSeckillGoods> findSecKillGoods(String time);
}
