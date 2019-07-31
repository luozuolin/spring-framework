package com.luozl.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
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
        req.setCharacterEncoding("utf-8");
        String name= req.getParameter("name");
        String age=  req.getParameter("age");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
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
