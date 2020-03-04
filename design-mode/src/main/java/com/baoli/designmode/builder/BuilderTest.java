package com.baoli.designmode.builder;

/**
 * @description: Builder测试类
 * @author: li baojian
 * @create: 2020/01/19 10:52
 */
public class BuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int count=26;
        for (int i=0;i<26;i++){
            sb.append((char) ('a'+i));
        }
        System.out.println(sb.toString());
    }
}
