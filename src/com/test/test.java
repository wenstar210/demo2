package com.test;

import com.dbservice.DBservice;
import com.student.dao.impl.StudentDao;
import com.student.pojo.Student;

public class test {
    public static void main(String[] args){

        DBservice ds = DBservice.getinstance();
        ds.getconn();

        StudentDao sd=new StudentDao();

        Student s=new Student();
        //s.setId(3);
        try {
            s.setId(1);
            s.setName("李四");
            s.setAge(22);
            s.setClazz("一班");
            s.setScore(78);


            sd.add(s);
            System.out.println("数据导入成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据导入失败");
        }finally{
            System.out.println("操作完成");
        }


    }
}
