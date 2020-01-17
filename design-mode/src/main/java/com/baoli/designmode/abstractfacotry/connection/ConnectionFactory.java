package com.baoli.designmode.abstractfacotry.connection;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @description: 数据库连接工厂
 * @author: li baojian
 * @create: 2019/11/11 11:44
 */

public abstract class ConnectionFactory extends AbstractConnectionFactory {

    private String url;
    private String username;
    private String password;
    private String databaseType;
    private String databaseName;
    private String catalog;
    private String schema;
    private String port;
    private String catolog;

    private Properties connectionProperties;

    public Connection getConnection() throws SQLException {
        return this.getConnection(this.username, this.password);
    }

    public Connection getConnection(String username, String password) throws SQLException {
        return this.getConnectionFromDriver(username, password);
    }

    protected Connection getConnectionFromDriver(String username, String password) throws SQLException {
        Properties properties = new Properties();
        Properties connectionProperties = this.getConnectionProperties();
        if (connectionProperties != null) {
            properties.putAll(connectionProperties);
        }
        if (username != null) {
            connectionProperties.setProperty("user", username);
        }
        if (password != null) {
            connectionProperties.setProperty("password", password);
        }
        Connection connection = this.getConnectionFromDriver(connectionProperties);

        if (catalog != null) {
            connection.setCatalog(this.catalog);
        }
        if (schema != null) {
            connection.setSchema(this.schema);
        }
        return connection;
    }

    protected abstract Connection getConnectionFromDriver(Properties connectionProperties) throws SQLException;

    public Properties getConnectionProperties() {
        return connectionProperties;
    }

    public void setConnectionProperties(Properties connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getCatolog() {
        return catolog;
    }

    public void setCatolog(String catolog) {
        this.catolog = catolog;
    }
}
