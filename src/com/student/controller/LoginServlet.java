package com.student.controller;

import com.student.service.IUserService;
import com.student.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String loginname=request.getParameter("loginname");
        String pw=request.getParameter("pw");
        String id=request.getParameter("id");
        IUserService service=new UserService();

        Cookie[] cks=request.getCookies();
        boolean loginid=false;
        for(Cookie ck:cks){
            if(ck.getName().equals("login")){
                if(ck.getValue().equals("1")){
                    loginid=true;
                    System.out.println("已经登录");
                    break;
                }
            }
        }
        if(loginid){
            response.sendRedirect("GetStudentServlet");

        }else
        {
            boolean b=service.verify(loginname,pw);
            if(b){
                if(id.equals("0")){
                    Cookie ck=new Cookie("login","1");
                    ck.setMaxAge(7*24*60*60*1000);
                    response.addCookie(ck);
                }
                response.sendRedirect("GetStudentServlet");
            }
            else{
                response.sendRedirect("login.jsp");
            }
        }
    }
}
