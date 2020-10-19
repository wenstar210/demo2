package com.student.controller;

import com.student.pojo.Student;
import com.student.service.IStudentService;
import com.student.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpStudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        String clazz=request.getParameter("clazz");
        String score=request.getParameter("score");

        Student student=new Student();
        student.setAge(Integer.valueOf(age));
        student.setClazz(clazz);
        student.setId(Integer.valueOf(id));
        student.setName(name);
        student.setScore(Integer.valueOf(score));

        IStudentService service=new StudentService();
        service.update(student);

        response.sendRedirect("GetStudentServlet");

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);

    }

}
