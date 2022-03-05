package com.example.day06filter.Filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @Author 沈永康
 * @Date 2022/3/4 16:08
 * @Version 1.0
 */


//@WebFilter(filterName = "FilterLogin" ,urlPatterns = "/*")
public class FilterLogin implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoginFilter初始化！");
    }

    public void destroy() {
        System.out.println("FilterLogin销毁！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        String[] urls= {"/login.jsp","/img/","/css/","/js","/loginServlet","/register.jsp","/registerServlet","/vertifyCodeServlet"};
        String url = request1.getRequestURL().toString();
        for (String u : urls){
            if (url.contains(u)){
                chain.doFilter(request, response);
                return;
            }
        }
        HttpSession session =request1.getSession();
        Object user =session.getAttribute("user");
        if (user != null) {
            chain.doFilter(request,response);
        }else {
            String msg="当前用户没有登录";
            request1.setAttribute("msg",msg);
            request1.getRequestDispatcher("/login.jsp").forward(request1,response);
        }

    }
}
