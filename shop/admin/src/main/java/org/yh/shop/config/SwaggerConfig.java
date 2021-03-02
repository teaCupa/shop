package org.yh.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: yh
 *      localhost:${port}/${prefix}/swagger-ui.html访问Swagger文档
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.yh.shop.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                .description("项目接口测试文档")
                .contact(new Contact("yh","https://github.com",
                        "viewpery@sina.com"))
                        .version("v1.0")
                        .title("api测试文档")
                        .license("apache2.0")
                        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build());
    }
}
