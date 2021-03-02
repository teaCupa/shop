package org.yh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.service.BasketService;
import org.yh.shop.service.ProductService;
import org.yh.shop.utils.CurdUtil;

/**
 * @Author: yh
 * @Date: 2020/11/22
 * @Description:  产品
 */

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    BasketService basketService;

    @GetMapping("/find")
    public ResponseEntity getProduct(){
         return CurdUtil.find(productService.getProduct());
    }

    @GetMapping("/detail")
    public ResponseEntity getProductVoById(Integer id){
        return CurdUtil.find(productService.getProductVoById(id));
    }


}
