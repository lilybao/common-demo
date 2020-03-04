package com.baoli.designmode.builder;

/**
 * @description: StringBuilder字符串扩展类
 * @author: li baojian
 * @create: 2020/01/19 10:50
 */
public class StringBuilder extends AbstractStringBuilder {
    public StringBuilder() {
        super(16);
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }
}
