package com.example.day02webwork;


/**
 * @Author 沈永康
 * @Date 2022/2/26 21:40
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String referer=request.getHeader("user-agent");
           System.out.println(referer);
        if (referer != null) {
            if (referer.contains("/com.example.day02webwork")){
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放音乐。。");

        }else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("去QQ音乐。。。。。");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
