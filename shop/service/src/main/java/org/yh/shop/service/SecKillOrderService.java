package org.yh.shop.service;

import org.yh.shop.model.TbSeckillOrder;
import org.yh.shop.model.vo.CartVo;

/**
 * @Author: yh
 * @Date: 2021/2/24
 * @Description:
 */


public interface SecKillOrderService {

     String addSecKillOrder(CartVo cartVo);

     String queryOrderStatus(String orderTrancId);

     TbSeckillOrder getSecKillOrder(String orderTrancId);
}
