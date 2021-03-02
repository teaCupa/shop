package org.yh.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.dao.UserDao;
import org.yh.shop.model.User;
import org.yh.shop.model.vo.LoginVo;
import org.yh.shop.service.UserService;
import org.yh.shop.utils.CurdUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yh
 * @Date: 2020/11/26
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public ResponseEntity checkLogin(LoginVo loginVo, HttpServletRequest request) throws Exception {
        return CurdUtil.find(findUserByName(loginVo,request));
    }


    private User findUserByName(LoginVo loginVo,HttpServletRequest request) throws Exception {
        String username=loginVo.getUsername();
        String password=loginVo.getPassword();
        if(username==null ||"".equals(username)){
            throw new Exception("用户名不能为空！");
        }
        User user=userDao.findUserByName(username);
        if(user==null){
            throw new Exception("账户不存在！");
        }
        if(!user.getPassword().equals(password)){
            throw new Exception("密码不正确！");
        }
        return user;
    }
}
