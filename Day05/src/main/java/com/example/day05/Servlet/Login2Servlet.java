package com.example.day05.Servlet;


/**
 * @Author 沈永康
 * @Date 2022/3/3 14:16
 * @Version 1.0
 */


import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login2")
public class Login2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader br = request.getReader();
        while ((line = br.readLine()) != null){
            json.append(line);
        }
        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=utf-8");
        out.println(JSONObject.parseObject(json.toString()));
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
