package com.example.day02webwork;


/**
 * @Author 沈永康
 * @Date 2022/2/26 22:09
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/RequestDemo5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String line;
        if ((line=reader.readLine())!=null){
            System.out.println(line);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(line);
        }

    }
}
