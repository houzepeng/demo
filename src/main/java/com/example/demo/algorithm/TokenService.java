package com.example.demo.algorithm;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    public String createToken();
    public boolean CheckToken(HttpServletRequest request) throws Exception;
}