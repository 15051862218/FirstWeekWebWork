package com.example.day02webwork;


/**
 * @Author 沈永康
 * @Date 2022/2/26 21:12
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String>  names=request.getHeaderNames();
        while (names.hasMoreElements()){
            String name=names.nextElement();
            String val=request.getHeader(name);
            System.out.println(names+":"+val);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
