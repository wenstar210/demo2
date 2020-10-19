package com.student.controller;

import com.student.service.IStudentService;
import com.student.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelStudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id=request.getParameter("id");
        IStudentService service=new StudentService();

        service.delete(Integer.valueOf(id));

        response.sendRedirect("GetStudentServlet");

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
