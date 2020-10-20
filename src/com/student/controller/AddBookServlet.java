package com.student.controller;

import com.student.pojo.Book;
import com.student.service.IBookService;
import com.student.service.impl.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        this.doPost(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name=request.getParameter("name");
        String stype=request.getParameter("stype");
        String publisher=request.getParameter("publisher");
        String author=request.getParameter("author");
        String price=request.getParameter("price");
        Book book=new Book();
        book.setName(name);
        book.setStype(stype);
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setPrice(Double.parseDouble(price));

        IBookService service=new BookService();
        if(service.add(book)>0){
            response.sendRedirect("GetBookServlet");
        }else {
            response.sendRedirect("addbook.jsp");
        }
    }
}
