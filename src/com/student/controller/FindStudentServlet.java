package com.student.controller;

import com.student.pojo.Student;
import com.student.service.IStudentService;
import com.student.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindStudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id=request.getParameter("id");

        IStudentService service=new StudentService();

        Student stu=service.find(Integer.valueOf(id));

        request.setAttribute("stu", stu);

        request.getRequestDispatcher("up.jsp").forward(request, response);

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
