package com.student.controller;

import com.student.pojo.Book;
import com.student.service.IBookService;
import com.student.service.impl.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        this.doPost(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        IBookService service=new BookService();
        List<Book> bookList=service.getlist("");
        request.setAttribute("book",bookList);
        request.getRequestDispatcher("booklist.jsp").forward(request,response);

    }
}
