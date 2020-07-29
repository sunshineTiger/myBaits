package com.zh.mybatis.utils;

public class Mapper {
    private String queryString;//执行的sql语句
    private String resultType;//结果类型的全限定类名


    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
