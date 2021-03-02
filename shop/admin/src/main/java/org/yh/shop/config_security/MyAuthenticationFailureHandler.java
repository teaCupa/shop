package org.yh.shop.config_security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.common.ResponseStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: yh
 * @Date: 2020/12/23
 * @Description:
 */

@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        ResponseEntity respEntity = ResponseEntity.error(ResponseStatus.LOGINERROR);
        if (exception instanceof LockedException) {
            respEntity.setMsg("账户被锁定，请联系管理员!");
        } else if (exception instanceof BadCredentialsException) {
            respEntity.setMsg("用户名或者密码输入错误，请重新输入!");
        }
        out.write(new ObjectMapper().writeValueAsString(respEntity));
        out.flush();
        out.close();
    }
}
