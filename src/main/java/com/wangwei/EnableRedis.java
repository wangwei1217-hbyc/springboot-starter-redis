package com.wangwei;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by wangwei on 2018/3/18.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RedisAutoConfiguration.class)
public @interface EnableRedis {
}
