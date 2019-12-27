package com.baoli.designmode.abstractfacotry.connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @description: 抽象数据库连接工厂类
 * @author: li baojian
 * @create: 2019/11/11 11:39
 */
public abstract class AbstractConnectionFactory implements DataSource {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AbstractConnectionFactory() {
    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    public void setLoginTimeout(int timeout) throws SQLException {

        throw new UnsupportedOperationException("setLoginTimeout");
    }

    public PrintWriter getLogWriter() {
        throw new UnsupportedOperationException("getLogWriter");
    }

    public void setLogWriter(PrintWriter pw) throws SQLException {
        throw new UnsupportedOperationException("setLogWriter");
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        if (iface.isInstance(this)) {
            return (T) this;
        } else {
            throw new SQLException("DataSource of type [" + this.getClass().getName() + "] cannot be unwrapped as [" + iface.getName() + "]");
        }
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return iface.isInstance(this);
    }

    public java.util.logging.Logger getParentLogger() {
        return java.util.logging.Logger.getLogger("global");
    }

    public static AbstractConnectionFactory getInstance() {
        return ConDemoBuilder.createACF();
    }

    private static class ConDemoBuilder {
        static final AbstractConnectionFactory INSTANCE = createACF();

        static AbstractConnectionFactory createACF() {
            DriverManageConnection driverManageConnection = new DriverManageConnection();
            return driverManageConnection;
        }

        private ConDemoBuilder() {
        }
    }
}
