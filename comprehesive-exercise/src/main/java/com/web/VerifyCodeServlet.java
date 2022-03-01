package com.web;


/**
 * @Author 沈永康
 * @Date 2022/3/1 13:26
 * @Version 1.0
 */


import com.util.VerifyCodeUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/verifyCode")
public class VerifyCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream os = response.getOutputStream();
        String verifyCode = VerifyCodeUtil.outputVerifyImage(100, 50, os, 4);
        // 2. 存入Session
        HttpSession session = request.getSession();
        session.setAttribute("verifyCode", verifyCode);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
