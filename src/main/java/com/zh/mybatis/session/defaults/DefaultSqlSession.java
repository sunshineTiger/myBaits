package com.zh.mybatis.session.defaults;

import com.zh.mybatis.session.SqlSession;
import com.zh.mybatis.session.proxy.MapperProxy;
import com.zh.mybatis.utils.Configuration;
import com.zh.mybatis.utils.DataSourceUtils;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements SqlSession {

    Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        //获取sqlConnection对象
        connection = DataSourceUtils.getConnection(cfg);
    }

    public <T> T getMapper(Class<T> c) {
        return (T) Proxy.newProxyInstance(c.getClassLoader(), new Class[]{c}, new MapperProxy(cfg.getMappers(), connection));
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
