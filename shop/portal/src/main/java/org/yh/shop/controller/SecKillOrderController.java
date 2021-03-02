package org.yh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.common.ResponseStatus;
import org.yh.shop.model.vo.CartVo;
import org.yh.shop.service.SecKillOrderService;
import org.yh.shop.utils.CurdUtil;

/**
 * @Author: yh
 * @Date: 2021/2/24
 * @Description:
 */

@RestController
@RequestMapping("/secKillOrder")
public class SecKillOrderController {
    @Autowired
    SecKillOrderService secKillOrderService;

    @PostMapping("/add")
    public ResponseEntity addSecKillOrder(@RequestBody CartVo cartVo){
        String res = secKillOrderService.addSecKillOrder(cartVo);
        if(res !=null){
            return ResponseEntity.ok(ResponseStatus.SUCCESS,res);
        }
        return ResponseEntity.error(ResponseStatus.FAILED);
    }


    @GetMapping("/query")
    public ResponseEntity queryOrderStatus(String orderTrancId){
        String status=secKillOrderService.queryOrderStatus(orderTrancId);
        if(status !=null){
            return ResponseEntity.ok(ResponseStatus.SUCCESS,status);
        }
        return ResponseEntity.error(ResponseStatus.FAILED);
    }

    @GetMapping("/find")
    public ResponseEntity getSecKillOrder(String orderTrancId){
        return CurdUtil.find(secKillOrderService.getSecKillOrder(orderTrancId));
    }
}
