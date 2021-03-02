package org.yh.shop;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class AdminApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }

    @Test
    public void testLogConfig(){
        PropertyConfigurator.configure( "D:/idea_workspace/shop/admin/src/main/resources/log4j.properties");
        Logger logger  =  Logger.getLogger(this.getClass());
        logger.debug( " debug xx" );
        logger.error( " error xx" );
    }
}
