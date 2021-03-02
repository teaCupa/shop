package org.yh.shop.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: yh
 * @Date: 2020/12/24
 * @Description:
 */

//@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //允许所有域名进行跨域调用
                .allowedOrigins("*")
                //允许跨越发送cookie
                .allowCredentials(true)
                //放行全部原始头信息
                .allowedHeaders("*")
                //允许请求方法跨域调用，若放行所有，设置为 *
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                //预检请求的有效期，单位为秒。
                .maxAge(3600);
    }
}
