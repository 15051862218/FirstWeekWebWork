package com.example.demo11;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(302);
        System.out.println("ResponseDemo1........"  );
        //1.设置状态吗

        //2.设置响应头
//        response.setHeader("location","https://www.baidu.com");
//        response.setHeader("location","/demo11_war_exploded/ResponseDemo2");
//        response.sendRedirect("https://www.baidu.com");
//        response.setHeader("msg","hellow");
//        request.setAttribute("msg","hellow1");
        Object msg=request.getServletContext().getAttribute("msg");
        System.out.println(request.getServletContext());
//        request.getRequestDispatcher("/ResponseDemo2").forward(request,response);
        System.out.println(msg);

    }
}
