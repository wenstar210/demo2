package com.student.dao;

import com.student.pojo.User;

import java.util.List;

public interface IUserDao {
    //注册
    public void add(User user);
    //查询用户
    public List<User> getlist(String where);
    //修改密码
    public void up(User user);


}
