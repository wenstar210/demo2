package com.student.dao;

import com.student.pojo.Book;

import java.util.List;

public interface IBookDao {
    public int add(Book book);
    public int update(Book book);
    public int delete(Book book);
    public List<Book> getlist(String where);
}
