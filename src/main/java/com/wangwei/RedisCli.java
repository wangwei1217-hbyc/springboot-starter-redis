package com.wangwei;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by wangwei on 2018/3/18.
 */
public class RedisCli {
    public static void main(String[] args) {
        JedisPoolConfig config=new JedisPoolConfig(); // 连接池的配置对象
        config.setMaxTotal(100); // 设置最大连接数
        config.setMaxIdle(10); // 设置最大空闲连接数

        JedisPool jedisPool=new JedisPool(config,"192.168.171.130",6379);

        Jedis jedis=null;
        try{
            jedis=jedisPool.getResource(); // 获取连接
            jedis.auth("root"); // 设置密码
            //jedis.set("name", "java知识分享网"); // 设置值
            String value=jedis.get("wangwei"); // 获取值
            System.out.println(value);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(jedis!=null){
                jedis.close();
            }
            if(jedisPool!=null){
                jedisPool.close();
            }
        }

    }
}
