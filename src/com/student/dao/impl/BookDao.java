package com.student.dao.impl;

import com.dbservice.DBservice;
import com.student.dao.IBookDao;
import com.student.pojo.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookDao implements IBookDao {
    private DBservice dBservice = DBservice.getinstance();

    @Override
    public int add(Book book){
        String sql = "insert into books(name,stype,publisher,author,price) values(";
        sql = sql + "'" + book.getName() + "',";
        sql = sql + "'" + book.getStype() + "',";
        sql = sql + "'" + book.getPublisher() + "',";
        sql = sql + "'" + book.getAuthor() + "',";
        sql = sql + book.getPrice() + ")";

        return this.dBservice.updateSql(sql);
    }

    @Override
    public int update(Book book) {
        String sql = "update books set ";
        sql = sql + "name='" + book.getName() + "',";
        sql = sql + "stype='" + book.getStype() + "',";
        sql = sql + "publisher='" + book.getPublisher() + "',";
        sql = sql + "author='" + book.getAuthor() + "',";
        sql = sql + "price=" + book.getPrice() + ",";
        sql = sql + " where ID=" + book.getId();

        return this.dBservice.updateSql(sql);
    }

    @Override
    public int delete(Book book) {
        String sql = "delete from books where ID="+book.getId();
        return this.dBservice.updateSql(sql);
    }

    @Override
    public List<Book> getlist(String where) {
        List<Book> result = new ArrayList<Book>();
        String sql = "select * from book";
        if(!"".equals(where)){
            sql = sql + " where "+ where;
        }

        List<Map<String,Object>> mapList = dBservice.selectSql(sql);
        for(Map map:mapList){
            Book book = new Book();
            book.setId(Integer.valueOf(map.get("ID").toString()));
            book.setPublisher(map.get("publisher").toString());
            book.setPrice(Double.parseDouble(map.get("price").toString()));
            book.setName(map.get("name").toString());
            book.setStype(map.get("stype").toString());
            book.setAuthor(map.get("author").toString());
            result.add(book);

        }
        return result;
    }
}
