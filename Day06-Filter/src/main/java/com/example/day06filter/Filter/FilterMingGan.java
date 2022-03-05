package com.example.day06filter.Filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 沈永康
 * @Date 2022/3/4 16:50
 * @Version 1.0
 */


@WebFilter("/*")
public class FilterMingGan implements Filter {
    private final List<String> list = new ArrayList<>();
    private final String methodName = "getParameter";

    public void init(FilterConfig config) throws ServletException {
        try {
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/badword.txt");
            System.out.println("读取 try-----");
            InputStreamReader in = new InputStreamReader( new FileInputStream(realPath),"utf-8");
            BufferedReader br = new BufferedReader(in);

            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            System.out.println("list是"+list);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        System.out.println("销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        ServletRequest proxyReq = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodName.equals(method.getName())) {
                    String value = (String) method.invoke(request, args);
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }
                    System.out.println("value是："+value);
                    return value;
                }
                return method.invoke(request, args);
            }
        });
        response.setContentType("text/plain;charset=utf-8");
        chain.doFilter(proxyReq, response);
    }
}
