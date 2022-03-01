package com.web;


/**
 * @Author 沈永康
 * @Date 2022/3/1 13:25
 * @Version 1.0
 */


import com.entity.Brand;
import com.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(urlPatterns = "/selectById")
@Slf4j
public class SelectByIdServlet extends HttpServlet {
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
        Brand brand = brandService.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("brand", brand);
        //4. 转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}
