package org.yh.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.dao.BasketDao;
import org.yh.shop.model.Basket;
import org.yh.shop.model.vo.CartVo;
import org.yh.shop.service.BasketService;
import org.yh.shop.utils.CurdUtil;

import java.util.Date;

/**
 * @Author: yh
 * @Date: 2020/11/30
 * @Description: 购物车
 */

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    BasketDao basketDao;
    @Override
    public ResponseEntity addBasket(CartVo cartVo) {
        Basket basket = new Basket();
        basket.setNum(1);
        basket.setSkuId(Integer.valueOf(cartVo.getSkuId()));
        basket.setUserId(Integer.valueOf(cartVo.getUserId()));
        basket.setStatus((byte) 1);
        basket.setUpdateDate(new Date());
        return CurdUtil.update(basketDao.insertSelective(basket));
    }

    @Override
    public ResponseEntity findBasketById(Integer userId) {
        return CurdUtil.find(basketDao.findBasketById(userId));
    }

    @Override
    public ResponseEntity updateBasket(Integer basketId, Integer num) {
        return CurdUtil.update(basketDao.update(basketId,num));
    }

    @Override
    public ResponseEntity deleteBasket(Integer basketId) {
        return CurdUtil.update(basketDao.deleteByPrimaryKey(basketId));
    }

    @Override
    public ResponseEntity deleteMoreBasket(Integer[] basketIds) {
        return CurdUtil.update(basketDao.deleteByIds(basketIds));
    }
}
