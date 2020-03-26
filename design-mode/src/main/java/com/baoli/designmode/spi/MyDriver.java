package com.baoli.designmode.spi;

import com.mysql.cj.jdbc.NonRegisteringDriver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-03-26 12:27
 */
public class MyDriver extends NonRegisteringDriver implements java.sql.Driver {
    static {
        try {
            java.sql.DriverManager.registerDriver(new MyDriver());
        } catch (SQLException E) {
            throw new RuntimeException("Can't register driver!");
        }
    }
    public Connection connect(String url, Properties info) throws SQLException {
        System.out.println("准备创建数据库连接");
        System.out.println("数据库连接信息"+info);
        info.setProperty("user","root");
        Connection connection =super.connect(url,info);
        System.out.println("数据库连接完成"+connection.toString()+connection.getClientInfo().getProperty("user"));
        return connection;
    }

    /**
     * Construct a new driver and register it with DriverManager
     *
     * @throws SQLException if a database error occurs.
     */
    public MyDriver() throws SQLException {
    }
}
