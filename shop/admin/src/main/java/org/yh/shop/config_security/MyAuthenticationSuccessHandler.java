package org.yh.shop.config_security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.common.ResponseStatus;
import org.yh.shop.utils.JwtTokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: yh
 * @Date: 2020/12/22
 * @Description:  认证成功的处理
 */

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        ResponseEntity respEntity = ResponseEntity.ok(ResponseStatus.SUCCESS);
        //生成token
        System.out.println("认证成功");
        String token = JwtTokenUtil.generateToken(authentication);
        respEntity.setData(token);
        out.write(new ObjectMapper().writeValueAsString(respEntity));
        out.flush();
        out.close();
    }

}
