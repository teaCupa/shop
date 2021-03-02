package org.yh.shop;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.yh.shop.dao")
public class AdminApplication {

    public static void main(String[] args) {
        //启动随机生成端口，注释掉
//        new StartCommand(args);
        SpringApplication.run(AdminApplication.class, args);
    }

}
