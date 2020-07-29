package com.zh.mybatis.session.proxy;

import com.zh.mybatis.utils.Executor;
import com.zh.mybatis.utils.Mapper;

import javax.print.DocFlavor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;


public class MapperProxy  implements InvocationHandler {
    private Map<String, Mapper> mapperMap;
    private Connection connection;

    public MapperProxy(Map<String, Mapper> mapperMap, Connection connection) {
        this.mapperMap = mapperMap;
        this.connection = connection;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key=className+"."+methodName;
        Mapper mapper = mapperMap.get(key);
        if(mapper==null){
            throw new IllegalArgumentException("传入的参数有误");
        }

        return new Executor().selectList(mapper,connection);
    }
}
