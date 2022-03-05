package com.example.day05.Servlet;


/**
 * @Author 沈永康
 * @Date 2022/3/3 14:31
 * @Version 1.0
 */


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(urlPatterns = "/upload2")
@MultipartConfig
public class Upload2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//获取提交数据中的account

        String account = request.getParameter("account");
        System.out.println(account);
        Part part = request.getPart("file");
// 原⽂件名
        System.out.println(part.getSubmittedFileName());
        String fileName = "";
        if (part.getContentType() != null) {
// 给⽂件改名
            fileName = UUID.randomUUID() +
                    part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));

// 获取项⽬部署的绝对路径
            ServletContext context = this.getServletContext();
// ⽂件上传最终的⽬录/⽂件名
            String realPath = context.getRealPath("upload/" + fileName);
// 上传
            part.write(realPath);
        }
// 把上传图⽚的相对路径返回给客户端
        PrintWriter out = response.getWriter();
        out.write("./upload/" + fileName);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
