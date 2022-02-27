package com.example.day01webwork;


import jakarta.servlet.*;

import java.io.IOException;

/**
 * @Author 沈永康
 * @Date 2022/2/26 18:23
 * @Version 1.0
 */


public class ServletDemo1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("oooooooo");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("你好，我叫沈少！");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
