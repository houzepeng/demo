package com.example.demo.algorithm;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.netty.util.internal.StringUtil;

@RestController
public class BussController {
    @Resource
    private TokenService tokenService;
    
    @PostMapping("/get/token")
    public String getToken(){
        String token = tokenService.createToken();
        if(!StringUtil.isNullOrEmpty(token)){
            return token;
        }
        return "token is null";
    }
}