package com.student.service;

public interface IUserService {
    public void register(String loginname,String pw);
    public boolean upPw(String loginname,String oldpw,String newpw);
    public boolean verify(String loginname,String pw);//校验
}
