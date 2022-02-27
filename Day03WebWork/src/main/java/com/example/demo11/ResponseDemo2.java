package com.example.demo11;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns ="/ResponseDemo2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResposeDemo2 被访问...");
        response.setStatus(302);
        System.out.println("ResposeDemo2 被访问...");
        request.getServletContext().setAttribute("msg", "{\"mn\": \"dajshd\"}");
        response.setHeader("location","/ResponseDemo1");
//        Object msg=request.getAttribute("name");
//        System.out.println(msg);

    }
}
