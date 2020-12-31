package com.common.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : RedisConfiguration
 * @Description : redis配置
 * @Author : pangxh
 * @Date: 2020-09-08 10:15
 */
@Configuration
public class RedisConfiguration {

    @Bean(initMethod = "initialPool")
    @ConfigurationProperties(prefix = "spring.mredis")
    public RedisUtil redis(){
        return new RedisUtil();
    }
}
