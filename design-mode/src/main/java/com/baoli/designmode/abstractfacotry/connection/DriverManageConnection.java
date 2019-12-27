package com.baoli.designmode.abstractfacotry.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @description: 获取数据库连接实体
 * @author: li baojian
 * @create: 2019/11/11 14:52
 */
public class DriverManageConnection extends ConnectionFactory {
    @Override
    protected Connection getConnectionFromDriver(Properties connectionProperties) throws SQLException {
        String url = this.getUrl();
        Connection connection = DriverManager.getConnection(url, connectionProperties);
        return connection;
    }
}
