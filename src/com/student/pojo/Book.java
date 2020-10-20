package com.student.pojo;

public class Book {
    private Integer id;
    private String name;
    private String stype;
    private String publisher;
    private String author;
    private double price;

    public void setId(Integer id){
        this.id=id;
    }
    public Integer getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setStype(String stype){
        this.stype=stype;
    }
    public String getStype(){
        return stype;
    }

    public void setPublisher(String publisher){
        this.publisher=publisher;
    }
    public String getPublisher(){
        return publisher;
    }

    public void setAuthor(String author){
        this.author=author;
    }
    public String getAuthor(){
        return author;
    }

    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice() {
        return price;
    }
}
