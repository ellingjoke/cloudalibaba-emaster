package com.elling.emaster.sys.test;

import com.elling.emaster.sys.config.JsonRedisTemplate;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {
    static final Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    JsonRedisTemplate jsonRedisTemplate;

    @SuppressWarnings("unchecked")
    @Test
    public void test(){

//        this.redisTemplate.opsForValue().set("Ryan","a natty boy2");
        Object ray = this.stringRedisTemplate.opsForValue().get("mastername");
        System.out.println(ray);
    }

    @Test
    public void test2(){

//        Object value = this.jsonRedisTemplate.opsForValue().get("cyy");
//        this.jsonRedisTemplate.opsForValue().set("Ryan2","{'occypy:'programmer''}");
        Object ray = this.jsonRedisTemplate.opsForValue().get("Ryan2");
        System.out.println(ray);
    }




}
