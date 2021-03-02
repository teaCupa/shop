package org.yh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.model.Product;
import org.yh.shop.service.ProductService;
import org.yh.shop.utils.CurdUtil;
import org.yh.shop.utils.DateUtil;

import java.util.Date;

/**
 * @Author: yh
 * @Date: 2020/12/25
 * @Description:
 */

@RestController
@RequestMapping("/product")
public class ProductAdminController {
    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return CurdUtil.find(productService.getProduct());
    }

    @GetMapping("/page")
    public ResponseEntity getByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "") String name) {
        return CurdUtil.find(productService.getProductByPage(page, size, name));
    }

    @GetMapping("/advanceSearch")
    public ResponseEntity advanceSearch(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size
            , @RequestParam(defaultValue = "") String name, String categoryName, String putawayDate) {
        Date startDate=null,endDate=null;
        if (putawayDate != null && !"".equals(putawayDate)) {
            String[] split = putawayDate.split(",");
            startDate = DateUtil.str2Date(split[0],"yyyy-MM-dd");
            endDate = DateUtil.str2Date(split[1],"yyyy-MM-dd");
        }
        //种类名categoryName可能为空，需要分类讨论;或者换一种思路，让前端多给些信息
//        productService.getProductByAdSearch(page,size,name,categoryName,startDate,endDate);
        return ResponseEntity.error("categoryName数据库实现不方便！");
    }


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        return CurdUtil.update(productService.save(product));
    }
}
