package com.wangwei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import redis.clients.jedis.Jedis;

/**
 * Created by wangwei on 2018/3/18.
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        Jedis jedis = context.getBean(Jedis.class);
        System.out.println(jedis.get("wangwei"));
    }
}
