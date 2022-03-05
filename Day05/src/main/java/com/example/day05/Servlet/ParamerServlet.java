package com.example.day05.Servlet;


/**
 * @Author 沈永康
 * @Date 2022/3/3 13:27
 * @Version 1.0
 */

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/param")
public class ParamerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String str = request.getQueryString();
        String[] params = str.split("&");
        Map<String,String> map = new HashMap<>(4);
        for (String s : params){
            String[] split = s.split("=");
            if (split[1].contains("%")){
                split[1]= java.net.URLDecoder.decode(split[1], StandardCharsets.UTF_8);
            }
            map.put(split[0],split[1] );
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(map));
        response.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
