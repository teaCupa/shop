package org.yh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.service.CategoryService;
import org.yh.shop.utils.CurdUtil;

/**
 * @Author: yh
 * @Date: 2020/12/27
 * @Description:
 */

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/unit")
    public ResponseEntity find(){
        return CurdUtil.find(categoryService.findNav());
    }
}
