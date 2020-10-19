package com.student.service.impl;

import com.student.dao.IStudentDao;
import com.student.dao.impl.StudentDao;
import com.student.pojo.Student;
import com.student.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentDao studentDao=new StudentDao();

    @Override
    public void add(Student student) {
        this.studentDao.add(student);
    }

    @Override
    public void update(Student student) {
        this.studentDao.update(student);

    }

    @Override
    public void delete(Integer id) {
        this.studentDao.delete(this.find(id));
    }

    @Override
    public List<Student> getall() {
        return this.studentDao.getlist();
    }

    @Override
    public Student find(Integer id) {
        List<Student> list=this.getall();
        for(Student stu:list){
            if(id.intValue()==stu.getId().intValue()){
                return stu;
            }
        }
        return null;
    }

    @Override
    public Double getavge() {
        List<Student> list=this.getall();
        int sum=0;
        for(Student stu:list){
            sum=sum+stu.getScore().intValue();
        }
        return sum*1.0/list.size();
    }

    @Override
    public Double gethgl() {
        List<Student> list=this.getall();
        int sum=0;
        for(Student stu:list){
            if(stu.getScore().intValue()>60)
                sum=sum+1;
        }
        return sum*1.0/list.size();
    }

}
