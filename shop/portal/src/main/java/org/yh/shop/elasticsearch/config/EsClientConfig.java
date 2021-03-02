package org.yh.shop.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yh
 * @Date: 2021/3/1
 * @Description:
 */

@Configuration
public class EsClientConfig {
    @Bean
    RestHighLevelClient restHighLevelClient(){
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.109.11", 9200, "http")
                )
        );
    }
}
