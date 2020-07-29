package com.zh.mybatis.session.defaults;

import com.zh.mybatis.session.SqlSession;
import com.zh.mybatis.session.SqlSessionFactory;
import com.zh.mybatis.utils.Configuration;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }


    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
