package com.common.anantation;

import com.common.redis.RedisConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(RedisConfiguration.class)
public @interface EnableRedis {
}
