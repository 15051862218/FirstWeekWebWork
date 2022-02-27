package com.example.day02webwork;


/**
 * @Author 沈永康
 * @Date 2022/2/26 21:25
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String head=request.getHeader("user-agent");
          if (head.contains("Edg")){
              System.out.println("edg默认浏览器");
              System.out.println(head);
          }else if(head.contains("Chrome")) {
              System.out.println(head);
              System.out.println("谷歌浏览器");

          }else if (head.contains("Firefox")){
              System.out.println(head);
              System.out.println("火狐浏览器...");
          }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
