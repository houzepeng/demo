package com.example.demo.algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import java.util.Collections;


/**
 *  spring boot 1.5.X
 * 使用redis 的 lua脚本  基于单点实现分布式锁
 *
 * lua脚本作为原子性操作，保证加锁和设置超时时间 为原子性操作
 * @author sxd
 * @date 2019/5/27 10:52
 */
@Component
public class RedisLock {

    @Autowired
    RedisTemplate redisTemplate;

    private static final Long SUCCESS = 1L;

    /**
     * 获取锁
     *
     * @param lockKey       redis的key
     * @param value         redis的value要求是随机串，防止释放其他请求的锁
     * @param expireTime    redis的key 的过期时间  防止死锁，导致其他请求无法正常执行业务
     * @return
     */
    public  boolean lock(String lockKey, String value, int expireTime) {

        String script = "if redis.call('setNx',KEYS[1],ARGV[1])  then " +
                "   if redis.call('get',KEYS[1])==ARGV[1] then " +
                "      return redis.call('expire',KEYS[1],ARGV[2]) " +
                "   else " +
                "      return 0 " +
                "   end " +
                "end";

        RedisScript<String> redisScript = new DefaultRedisScript<>(script, String.class);

        //对非string类型的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value, String.valueOf(expireTime));

        return SUCCESS.equals(result);

    }

    /**
     * 释放锁
     *
     * @param lockKey   redis的key
     * @param value     redis的value  只有value比对一致，才能确定是本请求 加的锁 才能正常释放
     * @return
     */
    public  boolean unlock(String lockKey, String value) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

        RedisScript<String> redisScript = new DefaultRedisScript<>(script, String.class);

        try {
            Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value);
            if (SUCCESS.equals(result)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}