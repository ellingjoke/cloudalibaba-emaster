package com.elling.emaster.sys.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class JsonRedisTemplate extends RedisTemplate<String,Object> {
    public JsonRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        super.setConnectionFactory(redisConnectionFactory);
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
//        serializer.configure(mapper -> {
//            mapper.registerModele(new JavaTimeModule());
//        });

        super.setKeySerializer(StringRedisSerializer.UTF_8);
        super.setValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));
        super.setHashKeySerializer(StringRedisSerializer.UTF_8);
        super.setHashValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));
    }


}
