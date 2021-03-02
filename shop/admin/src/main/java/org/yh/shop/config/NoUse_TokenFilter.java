package org.yh.shop.config;

import org.yh.shop.utils.JwtTokenUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yh
 * @Date: 2020/12/30
 * @Description: 检测token有效期
 */

//@Component
public class NoUse_TokenFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String token = JwtTokenUtil.getToken(req);
        Boolean valid = JwtTokenUtil.validateToken(token);

        /**
         * Bug: getWriter() has already been called for this response
         * 意思是filter方法以及使用过response不能再次使用
         *  使用return,不再进入之后的filterchain，这会导致没有响应response
         *  进行下一个过滤，不能传输信息。。。
         *  总结：不适合进行response操作。
         */
        if (!valid) {
//            res.setContentType("application/json;charset=utf-8");
//            PrintWriter out = res.getWriter();
//            ResponseEntity responseEntity = new ResponseEntity();
//            responseEntity.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            responseEntity.setMsg("token非法或已过期！");
//            out.write(new ObjectMapper().writeValueAsString(responseEntity));
//            out.flush();
        }
        filterChain.doFilter(req,res);
    }
}
