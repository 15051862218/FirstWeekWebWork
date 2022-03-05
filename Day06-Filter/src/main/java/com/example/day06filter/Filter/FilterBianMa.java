package com.example.day06filter.Filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author 沈永康
 * @Date 2022/3/4 16:44
 * @Version 1.0
 */


@WebFilter( "/*")
public class FilterBianMa implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("CharacterFilter初始化");
    }

    public void destroy() {
        System.out.println("CharacterFilter销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }
}
