package org.yh.shop.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.common.ResponseStatus;
import org.yh.shop.config_security.JwtLoginFilter;
import org.yh.shop.config_security.JwtUserDetailsService;
import org.yh.shop.config_security.MyAuthenticationFailureHandler;
import org.yh.shop.config_security.MyAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: yh
 * @Date: 2020/12/21
 * @Description:  从FilterChainProxy类中存在一系列过滤器，层层调用。
 * UsernamePasswordAuthenticationFilter继承自AbstractAuthenProcessProvider
 *  UsernamePassAuthFilter #doFilter->#attemptAuthentication
 *       ->AuthenticaionManager #authenticate
 *              ->ProviderManager #authenticate
 *       ->AbstractUserDetailsAuthenticationProvider #authenticate # retrieveUser
 *       ->DaoAuthenticationProvider #authenticate -># retrieveUser
 *      认证成功或失败作相应地处理
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)	// 开启权限注解，如：@PreAuthorize注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    private MyAuthenticationSuccessHandler mySuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler myFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁用 csrf(跨站请求伪造), 否则前端host:8080/doLogin 请求头会报302
        http
                .csrf().disable()
                .authorizeRequests()
                //允许用户不用登录就能访问商城首页资源
                .antMatchers("/","/swagger-ui.html").permitAll()
                //其他请求需要认证
                .anyRequest().authenticated()
                .and()
                //自定义的JwtLoginFilter继承AbstractAuthenProcessFilter,处理login接口
                 .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()),
                                          UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                //对应前端的登录页面发送到后端的接口，登录请求方法为POST
                .loginProcessingUrl("/doLogin")
                .successHandler(mySuccessHandler)
                .failureHandler(myFailureHandler);
        // 退出登录处理器
        http.logout().logoutSuccessHandler(new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                ResponseEntity respEntity = ResponseEntity.ok(ResponseStatus.LOGOUT);
                out.write(new ObjectMapper().writeValueAsString(respEntity));
                out.flush();
                out.close();
            }
        });

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(jwtUserDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
