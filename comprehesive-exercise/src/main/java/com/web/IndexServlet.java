package com.web;


/**
 * @Author 沈永康
 * @Date 2022/3/1 13:24
 * @Version 1.0
 */


import com.entity.Brand;
import com.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/index")

public class IndexServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用BrandService完成查询

        List<Brand> brands = brandService.selectAll();
        //2. 存入request域中
        request.setAttribute("brands", brands);
        //3. 转发到brand.jsp
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
