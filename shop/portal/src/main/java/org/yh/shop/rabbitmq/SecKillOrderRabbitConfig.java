package org.yh.shop.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yh
 * @Date: 2021/2/25
 * @Description:
 */

@Configuration
public class SecKillOrderRabbitConfig {
    public final static String QUEUENAME ="secKillOrderQueue";
    public final static String DIRECTEXCHANGENAME ="directExchangeName";
    public final static String ROUTINGKEY ="directRouteKey";

    @Bean
    Queue secKillOrderQueue(){
        return new Queue(QUEUENAME);
    }

    //创建交换机
    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(DIRECTEXCHANGENAME,true,false);
    }

    //创建绑定
    @Bean
    Binding DirectBinding(){
        return BindingBuilder.bind(secKillOrderQueue()).to(directExchange()).with(ROUTINGKEY);
    }
}
