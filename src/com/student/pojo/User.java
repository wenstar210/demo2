package com.student.pojo;

public class User {
    private String loginname;
    private String pw;
    //get属性
    public String getPw(){
        return pw;
    }

    public void setPw(String pw){
        this.pw=pw;
    }
    public String getLoginname(){
        return loginname;
    }
    public void setLoginname(String loginname){
        this.loginname=loginname;
    }
}
