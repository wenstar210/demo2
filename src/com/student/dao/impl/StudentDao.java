package com.student.dao.impl;

import com.dbservice.DBservice;
import com.student.dao.IStudentDao;
import com.student.pojo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDao implements IStudentDao {
    private DBservice dbservice = DBservice.getinstance();

    @Override
    public int add(Student student) {
        String sql = "insert into student(id,name,age,clazz,score) values(";
        sql = sql + student.getId()+",";
        sql = sql + "'" + student.getName() + "',";
        sql = sql + student.getAge() + ",";
        sql = sql + "'" + student.getClazz() + "',";
        sql = sql + student.getScore() + ")";

        return this.dbservice.updateSql(sql);
    }

    @Override
    public int update(Student student) {
        String sql = "update student set ";
        sql = sql + "name='" + student.getName() + "',";
        sql = sql + "age=" + student.getAge() + ",";
        sql = sql + "clazz='" + student.getClazz() + "',";
        sql = sql + "score=" + student.getScore();
        sql = sql + " where ID=" + student.getId();

        return this.dbservice.updateSql(sql);
    }

    @Override
    public int delete(Student student) {
        String sql = "delete from student where ID=" + student.getId();
        return this.dbservice.updateSql(sql);
    }

    @Override
    public List<Student> getlist() {

        List<Student> list = new ArrayList<Student>();
        List<Map<String, Object>> list_temp = this.dbservice.selectSql("select * from student");
        for (Map <String, Object>map : list_temp) {
            Student stu = new Student();
            stu.setId(Integer.valueOf(map.get("ID").toString()));
            stu.setName(map.get("name").toString());
            stu.setAge(Integer.valueOf(map.get("age").toString()));
            stu.setClazz(map.get("clazz").toString());
            stu.setScore(Integer.valueOf(map.get("score").toString()));

            list.add(stu);

        }

        return list;
    }

}
