package com.example.day06filter.Filter;


import jakarta.servlet.*;

import java.io.IOException;

/**
 * @Author 沈永康
 * @Date 2022/3/4 8:48
 * @Version 1.0
 */


//@WebFilter(urlPatterns = "/*")
public class Filterdemo1 implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化！");
    }
    @Override
    public void destroy() {
        System.out.println("销毁！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤被执行");
        chain.doFilter(request, response);
        System.out.println("返魂");
    }
}
