package com.baoli.designmode.spi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-03-26 12:12
 */
public class DriverManagerDemo {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=Asia/Shanghai&useSSL=false&nullCatalogMeansCurrent=true", "root", "root");
            System.out.println(connection.getClientInfo().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
