package org.yh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.service.PropNameService;
import org.yh.shop.utils.CurdUtil;

/**
 * @Author: yh
 * @Date: 2020/12/26
 * @Description:
 */

@RestController
@RequestMapping("prop")
public class PropController {
    @Autowired
    private PropNameService propNameService;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return CurdUtil.find(propNameService.findAll());
    }
}
