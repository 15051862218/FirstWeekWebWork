package com.example.day02webwork;


/**
 * @Author 沈永康
 * @Date 2022/2/26 22:37
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = "/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        this.doPost(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post 获取请求参数
        //根据参数名称获取参数值
        System.out.println("根据参数名称获取参数值");
        String username = request.getParameter("username");
        System.out.println(username);
        //根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        //获取所有请求的参数名称
        System.out.println("***********************");
        System.out.println("获取所有请求的参数名称");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("----------------");
        }

        // 获取所有参数的map集合
        System.out.println("***********************");
        System.out.println("获取所有参数的map集合");
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            //获取键获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("-----------------");


        }
    }
}
