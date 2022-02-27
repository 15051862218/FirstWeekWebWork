package com.example.day02webwork;


/**
 * @Author 沈永康
 * @Date 2022/2/26 20:36
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns =  "/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String method=request.getMethod();
//        System.out.println(method);
//        String contextPath=request.getContextPath();
//        System.out.println(contextPath);
//        String servletpath=request.getServletPath();
//        System.out.println(servletpath);
//         String can=request.getQueryString();
//        System.out.println(can);
//        String uri1=request.getRequestURI();
//        StringBuffer uri2=request.getRequestURL();
//        System.out.println(uri1);
//        System.out.println(uri2);
         String proto=request.getProtocol();
        System.out.println(proto);
        String ip=request.getRemoteAddr();
        System.out.println(ip);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
