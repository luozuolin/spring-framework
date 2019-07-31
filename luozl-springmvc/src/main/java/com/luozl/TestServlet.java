package com.luozl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String message;
    @Override
    public void init() throws ServletException{
        message="hello Servlet";
        System.out.println("TestServlet init.");
    }
    @Override
    public  void destroy()
    {
        System.out.println("===TestServlet destroy.");
    }
    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        ServletContext servletContext=getServletContext();
        String name=  servletContext.getAttribute("name").toString();
        String age=  servletContext.getAttribute("age").toString();
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<h1>"+name+","+age+"<h1>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
       resp.setContentType("text/html");
       PrintWriter out=resp.getWriter();
       out.println("<h1>"+message+"</h1>");
    }
}
