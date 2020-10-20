package com.student.service.impl;

import com.student.dao.IBookDao;
import com.student.dao.impl.BookDao;
import com.student.pojo.Book;
import com.student.service.IBookService;

import java.util.List;

public class BookService implements IBookService {
    IBookDao bookDao=new BookDao();
    @Override
    public void add(Book book) {
        this.bookDao.add(book);
    }

    @Override
    public void update(Book book) {
        this.bookDao.update(book);
    }

    @Override
    public int delete(Integer id) {
        if(null==this.find(id)){
            return 0;
        }
        else {
         return this.bookDao.delete(this.find(id));
        }
    }

    @Override
    public List<Book> getlist(String where) {
        return this.bookDao.getlist(where);
    }

    @Override
    public Book find(Integer id) {
        List<Book> bookList=this.bookDao.getlist("ID="+id);
        if(null==bookList||bookList.isEmpty()){
            return null;
        }else {
            return bookList.get(0);
        }
    }


}
