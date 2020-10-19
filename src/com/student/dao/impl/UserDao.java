package com.student.dao.impl;

import com.dbservice.DBservice;
import com.student.dao.IUserDao;
import com.student.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao implements IUserDao {
    private DBservice db=DBservice.getinstance();
    @Override
    public void add(User user){
        String sql="insert into users(loginname,pw) values(";
        sql = sql + "'" + user.getLoginname() + "',";
        sql = sql + "'" + user.getPw() + "')";

        this.db.updateSql(sql);
    }
    @Override
    public List<User>getlist(String where){
        List<User> result=new ArrayList<User>();
        String sql="Select * from users";
        if(!"".equals(where)){
            sql = sql + "where" +where;
        }

        List<Map<String, Object>>list=this.db.selectSql(sql);
        for(Map<String, Object> map:list){


            User user=new User();
            user.setLoginname(map.get("loginname").toString());
            user.setPw(map.get("pw").toString());
            result.add(user);
        }
        return result;
    }
    @Override
    public void up(User user){
        String sql="update users set";
        sql = sql + "pw='" + user.getPw()+ "'";
        sql = sql + "where loginname= '" + user.getLoginname() + "'";
        this.db.updateSql(sql);
    }
}
