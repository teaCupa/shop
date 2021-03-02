package org.yh.shop.service;

import org.yh.shop.common.ResponseEntity;
import org.yh.shop.model.vo.LoginVo;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author: yh
 * @Date: 2020/11/26
 * @Description:
 */


public interface UserService {

    ResponseEntity checkLogin(LoginVo loginVo, HttpServletRequest request) throws Exception;

}
