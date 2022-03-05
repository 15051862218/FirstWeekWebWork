package com.example.day06filter.Filter;


/**
 * @Author 沈永康
 * @Date 2022/3/4 9:54
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(filterName = "Filterdemo3",urlPatterns = "/page/*")
public class Filterdemo3 implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化3！");
    }

    public void destroy() {
        System.out.println("销毁3");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpSession session =((HttpServletRequest) request).getSession();
        Object user=session.getAttribute("user");
        String msg="";

        if (user != null) {
            chain.doFilter(request, response);
        }else {
            msg="没有登录";
            request1.setAttribute("msg",msg);
            request1.getRequestDispatcher("/login.jsp").forward(request1,response);
        }

    }
}
