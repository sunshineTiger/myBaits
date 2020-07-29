package com.zh.mybatis.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtils {

    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
