package com.web;


/**
 * @Author 沈永康
 * @Date 2022/3/1 17:14
 * @Version 1.0
 */


import com.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
@Slf4j
public class DeleteServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   this.doPost(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("id");
            log.info(id);
            //2. 调用service查询

            brandService.delete(Integer.parseInt(id));
            //3. 存储到request中

            String contextPath= request.getContextPath();

            //4. 转发到update.jsp
//
            response.sendRedirect(contextPath+"/index");
        }

    }

