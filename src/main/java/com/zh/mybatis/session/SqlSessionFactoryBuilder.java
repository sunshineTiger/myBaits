package com.zh.mybatis.session;

import com.zh.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.zh.mybatis.utils.Configuration;
import com.zh.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build( InputStream resourceAsStream){
        //解析xml数据获取全局配置Configuration对象
        Configuration configuration = XMLConfigBuilder.loadConfiguration(resourceAsStream);
        return new DefaultSqlSessionFactory(configuration);
    }
}
