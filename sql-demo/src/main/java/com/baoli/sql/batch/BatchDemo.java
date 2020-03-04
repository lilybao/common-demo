package com.baoli.sql.batch;

import org.springframework.jdbc.core.JdbcTemplate;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: mysql批处理
 * @author: li baojian
 * @create: 2020/01/19 11:18
 */
public class BatchDemo {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Hongkong&allowPublicKeyRetrieval=true&autoReconnect=true", "root", "root");
            String insertSql = "insert  into batch_test values (null,?)";
            String updateSql = "update   batch_test  set name=? where id=?";
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(updateSql);
            for (int i = 0; i < 10000; i++) {
                ps.setInt(1, i + 1);
                ps.setString(2, "nameupdate" + i);
                ps.addBatch();
            }
            long start = System.currentTimeMillis();
            ps.executeBatch();
            connection.commit();
            long end = System.currentTimeMillis();
            System.out.println("花费时间" + (end - start) + "毫秒");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String updateSql = "update batch_test set name=? where id=?";
        List<Object[]> params = new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            params.add(new Object[]{i, "name-update" + i});
        }
        long start = System.currentTimeMillis();
        jdbcTemplate.batchUpdate(updateSql, params);
        long end = System.currentTimeMillis();
        System.out.println("一共耗时" + (end - start) + "毫秒");
    }
}
