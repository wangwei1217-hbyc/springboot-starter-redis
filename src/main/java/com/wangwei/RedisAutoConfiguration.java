package com.wangwei;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * Created by wangwei on 2018/3/18.
 */
@Configuration
@ConditionalOnClass(Jedis.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public Jedis createJedis(RedisProperties redisProperties){
        Jedis jedis = new Jedis(redisProperties.getHost(), redisProperties.getPort());
        jedis.auth(redisProperties.getAuth());
        return jedis;

    }
}
