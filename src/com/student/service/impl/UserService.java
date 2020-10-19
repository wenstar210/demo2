package com.student.service.impl;

import com.student.dao.IUserDao;
import com.student.dao.impl.UserDao;
import com.student.pojo.User;
import com.student.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserDao dao=new UserDao();
    @Override
    public void register(String loginname,String pw){
        User user =new User();
        user.setLoginname(loginname);
        user.setPw(pw);
        System.out.println(pw);
        dao.add(user);
    }
    @Override
    public boolean upPw(String loginname,String oldpw,String newpw){
        List<User> list=dao.getlist("loginname='"+loginname+"'");
        if(null ==list||list.isEmpty()){
            return false;
        }else {
            User user=list.get(0);
            if(oldpw.equals(user.getPw())){
                user.setPw(newpw);
                this.dao.up(user);
                return true;
            }else {
                return false;
            }
        }
    }
    @Override
    public boolean verify(String loginname,String pw){
        List<User> list=this.dao.getlist("loginname='"+loginname+"'");
        if(null==list||list.isEmpty()) {
            return false;
        }else {
            User user=list.get(0);
            //sql注入风险
            //return true;
            if(pw.equals(user.getPw())) {
                return true;
            }else {
                return false;
            }

        }
    }
}
