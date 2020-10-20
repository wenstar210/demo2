package com.student.service;

import com.student.pojo.Book;

import java.util.List;

public interface IBookService {
    public void add(Book book);

    public void update(Book book);

    public int delete(Integer id);

    public List<Book> getlist(String where);

    public Book find(Integer id);

}
