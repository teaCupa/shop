package org.yh.shop.config_security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yh
 * @Date: 2020/12/30
 * @Description:   通过设置Authentication对象，可以避免登录，但是权限失效了
 *                 认证时路径/login被JwtLoginFilter处理了
 *                 不适用于前后端分离
 */


public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {
  private static final Logger log = LoggerFactory.getLogger(JwtLoginFilter.class);
    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(defaultFilterProcessesUrl, authenticationManager);
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("admin", 123);
        log.info("#######认证#######");
        SecurityContextHolder.getContext().setAuthentication(token);
        return null;
    }
}
