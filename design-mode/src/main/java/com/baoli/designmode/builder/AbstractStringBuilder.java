package com.baoli.designmode.builder;

import java.util.Arrays;

/**
 * @description: StringBuilder基类
 * @author: li baojian
 * @create: 2020/01/19 10:32
 */
public class AbstractStringBuilder {
    protected char[] value;
    protected int count;

    public AbstractStringBuilder(int capacity) {
        count = 0;
        value = new char[capacity];
    }

    public AbstractStringBuilder append(char c) {
        increateInternalSize(count + 1);
        value[count++] = c;
        return this;
    }

    private void increateInternalSize(int minSize) {
        if (minSize - value.length > 0) {
            expendSize(minSize);
        }
    }

    private void expendSize(int minSize) {
        int newCapacity = value.length * 2 + 2;
        if (newCapacity < 0) {
            if (minSize < 0) {
                throw new OutOfMemoryError();
            }
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value, newCapacity);
    }
}
