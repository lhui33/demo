package com.kunke.logic.hall.config;

import com.kunke.sanguo.config.MyGenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * redis对象序列化配置类
 */
@Configuration
public class RedisConfig {
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Serializable> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new MyGenericFastJsonRedisSerializer(Object.class));
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }
}
