package org.yh.shop.service;

import org.yh.shop.common.ResponseEntity;
import org.yh.shop.model.vo.CartVo;

/**
 * @Author: yh
 * @Date: 2020/11/30
 * @Description:
 */


public interface BasketService {
    ResponseEntity addBasket(CartVo cartVo);

    ResponseEntity findBasketById(Integer userId);

    ResponseEntity updateBasket(Integer basketId, Integer num);

    ResponseEntity deleteBasket(Integer basketId);

    ResponseEntity deleteMoreBasket(Integer[] basketIds);
}
