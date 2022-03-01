package com.example.day04webwork;


/**
 * @Author 沈永康
 * @Date 2022/2/28 10:50
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/Servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("username", "zhangsan");
        cookie.setMaxAge(60);
        response.addCookie(cookie);
    }
}
