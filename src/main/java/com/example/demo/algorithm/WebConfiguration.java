package com.example.demo.algorithm;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    private AutoIdempotentInterceptor AutoIdempotentInterceptor;
    
}