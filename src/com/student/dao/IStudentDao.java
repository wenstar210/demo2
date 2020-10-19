package com.student.dao;

import com.student.pojo.Student;

import java.util.List;

public interface IStudentDao {
    public int add(Student student);
    public int update(Student student);
    public int delete(Student student);
    public List<Student> getlist();

}

