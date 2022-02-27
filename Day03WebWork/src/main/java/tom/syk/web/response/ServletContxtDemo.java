package tom.syk.web.response;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/path")
public class ServletContxtDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ServletContext context=this.getServletContext();
            String bPath = context.getRealPath("/b.txt");
        System.out.println(bPath);
        String cPath =context.getRealPath("/WEB-INF/c.txt");
        System.out.println(cPath);
        String aPath =context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(aPath);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
