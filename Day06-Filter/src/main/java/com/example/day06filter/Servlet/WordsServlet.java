package com.example.day06filter.Servlet;


/**
 * @Author 沈永康
 * @Date 2022/3/4 17:13
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/wordsServlet")
public class WordsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String words =request.getParameter("words");
        System.out.println("发布类容："+words);
        PrintWriter out = response.getWriter();
        out.write(words);
        out.close();
    }
}
