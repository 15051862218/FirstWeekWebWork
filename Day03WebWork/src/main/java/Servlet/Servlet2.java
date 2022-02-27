package Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/down")
public class Servlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/images/"+filename);
        InputStream is=new FileInputStream(realPath);
        response.setHeader("content-disposition","attachment;filename="+filename);
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len;
        while ((len = is.read(buff)) !=-1){
            sos.write(buff,0,len);
        }
        sos.close();
        is.close();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }


}
