package com.example.day05.Servlet;


/**
 * @Author 沈永康
 * @Date 2022/3/3 12:09
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(urlPatterns = "/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
         Part part  = request.getPart("file");
        InputStream inputStream=part.getInputStream();
        //文件改名
        String fileName= UUID.randomUUID()+part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
        ServletContext servletContext = this.getServletContext();
        String realpath = servletContext.getRealPath("upload/"+fileName);
        part.write(realpath);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("文件上传成功！");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
