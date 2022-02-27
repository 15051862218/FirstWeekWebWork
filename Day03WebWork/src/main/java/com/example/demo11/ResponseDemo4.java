package com.example.demo11;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@WebServlet(urlPatterns = "/ResponseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//     String info="sdadasda";
//     resp.setContentType("text/html;charset=utf-8");
//        ServletOutputStream s=resp.getOutputStream();
//        s.write(info.getBytes(StandardCharsets.UTF_8));
//        s.close();


//        resp.setContentType("application/json");
//String info= "{\"name\": \"zhang\",\"age\": 23" + "}\n";
//
//        ServletOutputStream s=resp.getOutputStream();
//        s.write(info.getBytes(StandardCharsets.UTF_8));
//        s.close();
        int width=110;
        int height=100;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g=image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
        g.setColor(Color.red);
        g.drawRect(0,0,width+2,height+2);
        String str="dasjdkaljdlajslkjaslkjlksajdlkdjlasllljkjldjsaslkdj23123";

        Random random = new Random();

        for (int i=1;i<=4;i++){

            int index=random.nextInt(str.length());
            char c = str.charAt(index);
            g.drawString(String.valueOf(c),width/5*i,height/2);
        }
        g.setColor(Color.BLUE);
        for (int i=0;i<10;i++){
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.drawLine(x1,x2,y1,y2);
        }



        ImageIO.write(image,"jpg",resp.getOutputStream());


    }
}
