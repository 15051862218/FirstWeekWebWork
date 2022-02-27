package Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/Servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         ServletContext s1=request.getServletContext();
         ServletContext s2=this.getServletContext();
        System.out.println(s1 == s2);



        ServletContext s3=this.getServletContext();
        String sss="hellow.js";
        String mimeType = s3.getMimeType(sss);
        System.out.println(mimeType);


        ServletContext s4=this.getServletContext();
        s4.setAttribute("name", "{\"name\": \"zhang \",\"age\": 12}");
        response.sendRedirect("/ResponseDemo2");
    }
}


