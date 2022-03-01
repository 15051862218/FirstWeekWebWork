package com.example.day04webwork;


/**
 * @Author 沈永康
 * @Date 2022/2/28 10:52
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


@WebServlet(urlPatterns = "/Servlet2")
@Slf4j
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies=request.getCookies();
        for (Cookie cookie :cookies){
            String name=cookie.getName();
            if ("username".equals(name)){
          String val=cookie.getValue();
                log.info("name:"+val);
             break;

            }
        }
    }
}
