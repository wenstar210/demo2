package com.student.controller;

import com.student.pojo.Student;
import com.student.service.IStudentService;
import com.student.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetStudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IStudentService service=new StudentService();

        List<Student> list=service.getall();

        Double avge=service.getavge();
        Double jgl=service.gethgl();

        request.setAttribute("stus", list);
        request.setAttribute("avge", avge);
        request.setAttribute("jgl", jgl);

        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

}
