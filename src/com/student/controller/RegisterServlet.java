package com.student.controller;

import com.student.service.IUserService;
import com.student.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String loginname=request.getParameter("loginname");
        String pw=request.getParameter("pw");
        IUserService service=new UserService();
        System.out.println(pw);
        service.register(loginname,pw);
        response.sendRedirect("login.jsp");
    }
}
