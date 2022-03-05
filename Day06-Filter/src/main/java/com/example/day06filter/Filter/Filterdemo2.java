package com.example.day06filter.Filter;


import jakarta.servlet.*;

import java.io.IOException;

/**
 * @Author 沈永康
 * @Date 2022/3/4 9:01
 * @Version 1.0
 */


//@WebFilter(urlPatterns = "/*")
public class Filterdemo2 implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化2");
    }
     @Override
    public void destroy() {
        System.out.println("销毁2");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("执行2");
        chain.doFilter(request, response);

    }
}
