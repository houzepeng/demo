package com.example.demo.algorithm;

import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import io.netty.util.internal.StringUtil;





public class TokenServiceImpl implements TokenService {

    public final String TOKEN_PREFIX = "test";
    public final String TOKEN_NAME = "token_name";

    @Autowired
    private RedisServer redisServer;
    @Override
    public String createToken() {
        String str = UUID.randomUUID().toString();
        StringBuilder token = new StringBuilder();
        token.append(TOKEN_PREFIX).append(str);
        redisServer.setEx(token.toString(), token.toString(), 10000L);
        boolean noEmpty = StringUtil.isNullOrEmpty(token.toString());
        if(noEmpty){
            return token.toString();    
        }
        return null;
    }

    @Override
    public boolean CheckToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader(TOKEN_NAME);
        if(StringUtils.isEmpty(token)){
            throw new Exception("token is null");
        }
        if(!redisServer.exists(token)){
            throw new Exception("token isnot exists");
        }
        boolean remove  = redisServer.remove(token);
        if(!remove){
            throw new Exception("shan chu shibai");
        }
        return true;
    }
    
}