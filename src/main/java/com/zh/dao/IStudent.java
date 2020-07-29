package com.zh.dao;

import com.zh.data.Student;

import java.util.List;

public interface IStudent {
    @Select("select * from student;")
    List<Student> findAll();

}
