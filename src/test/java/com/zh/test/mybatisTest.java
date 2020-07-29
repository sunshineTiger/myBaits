package com.zh.test;

import com.zh.dao.IStudent;
import com.zh.data.Student;
import com.zh.mybatis.io.Resources;
import com.zh.mybatis.session.SqlSession;
import com.zh.mybatis.session.SqlSessionFactory;
import com.zh.mybatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 * 1.在SqlSessionFactoryBuilder对象的build方法中，读取mybatis的全局xml配置信息，获取driver,url,root,password数据封装，并且读取<mappers>标签中的mapper封装，存入全局configuration中
 * 2 SqlSession工厂构建者对象，通过build方法构建出SqlSession工厂对象，调用工厂的openSession方法，获取SqlSession对象
 * 3 SqlSession的getMapper方法中实现了动态代理，通过调用mapper.findAll()方法，会执行到动态代理逻辑，并进行数据库的查询，并返回数据操作结果
 * 4 获得数据操作结果，关闭sqlSession和输入流
 *
 */
public class mybatisTest {
    public static void main(String[] args) {
        try {
            //读取xml数据
            InputStream resourceAsStream = Resources.getResourceAsStream("SqlConfigure.xml");
            //SqlSession工厂构建者
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //通过工厂构建这构建工厂
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
            //获取SqlSession
            SqlSession sqlSession = build.openSession();
            //获取mapper
            IStudent mapper = sqlSession.getMapper(IStudent.class);
            List<Student> all = mapper.findAll();
            for (Student s : all) {
                System.out.println(s);
            }
            sqlSession.close();
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
