package org.yh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.model.vo.LoginVo;
import org.yh.shop.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yh
 * @Date: 2020/11/26
 * @Description:
 */

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(LoginVo loginVo, HttpServletRequest request) throws Exception {
        return userService.checkLogin(loginVo,request);
    }
}
