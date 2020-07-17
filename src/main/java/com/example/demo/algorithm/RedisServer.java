package com.example.demo.algorithm;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisServer {
    @Autowired
    private RedisTemplate redisTemplate;

    public  boolean set(final String key,Object value){
        boolean result = false;
       try {
            ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
           operations.set(key,value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean setEx(final String key,Object value,Long expireTime){
        boolean result = false;
        try {
            ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean exists(final String key){
        return redisTemplate.hasKey(key);
    }

    public Object get(final String key){
        Object result = null;
        ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    public boolean remove(final String key){
        if(exists(key)){
            Boolean delete = redisTemplate.delete(key);
            return delete;
        }
        return false;
    }
}