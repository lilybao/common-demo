package com.baoli.designmode.abstractfacotry.connection;

import java.sql.SQLException;

/**
 * @description: 连接实现
 * @author: li baojian
 * @create: 2019/11/11 11:47
 */
public class ConnectionDemo {

    public static void main(String[] args) {
//        DriverManageConnection driverManageConnection = new DriverManageConnection();
//        driverManageConnection.setUrl("127.0.0.1:");
//        Properties properties = new Properties();
//        properties.setProperty()
//        Connection connectionFromDriver = driverManageConnection.getConnectionFromDriver(properties);
        AbstractConnectionFactory instance = AbstractConnectionFactory.getInstance();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    instance.setLoginTimeout(5);
                    System.out.println(instance.getLoginTimeout());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    instance.setLoginTimeout(6);
                    System.out.println(instance.getLoginTimeout());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
