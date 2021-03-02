package org.yh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.model.vo.CartVo;
import org.yh.shop.service.BasketService;

/**
 * @Author: yh
 * @Date: 2020/12/7
 * @Description:
 */

@RestController
public class BasketController {
    @Autowired
    BasketService basketService;

    @GetMapping("/basket")
    public ResponseEntity getBasketById(Integer userId){
        return basketService.findBasketById(userId);
    }

    @PostMapping("/basket")
    public ResponseEntity addBasket(@RequestBody CartVo cartVo){
        return basketService.addBasket(cartVo);
    }

    @PutMapping("/basket")
    public ResponseEntity updateBasket(@RequestParam("basketId")Integer basketId,
                                       @RequestParam("num") Integer num){
        return basketService.updateBasket(basketId,num);
    }

    @DeleteMapping("/basket")
    public ResponseEntity deleteBasket(Integer basketId){
        return basketService.deleteBasket(basketId);
    }
    @DeleteMapping("/basket/more")
    public ResponseEntity deleteBasket(@RequestBody Integer[] basketIds){
        return basketService.deleteMoreBasket(basketIds);
    }
}
