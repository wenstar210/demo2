package com.student.service;

import com.student.pojo.Student;

import java.util.List;

public interface IStudentService {
    public void add(Student student);

    public void update(Student student);

    public void delete(Integer id);

    public List<Student> getall();

    public Student find(Integer id);

    public Double getavge();//平均成绩

    public Double gethgl();//合格率

}
