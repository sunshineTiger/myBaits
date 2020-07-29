package com.zh.mybatis.session;

public interface SqlSession {
     <T> T getMapper(Class<T> c);
     void close();
}
