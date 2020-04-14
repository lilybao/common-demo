package com.baoli.leetcode.day;

import java.io.InputStream;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @program: common-demo
 * @description: 蓄水池算法，给定一个数据流，数据流长度N很大，且N直到处理完所有数据之前都不可知，
 * 请问如何在只遍历一遍数据（O（N））的情况下可以随机选取出m个不重复的数据  https://www.jianshu.com/p/7a9ea6ece2af
 * @author: li baojian
 * @create: 2020-04-14 17:54
 */
public class ReservoirDemo {
    public static void main(String[] args) {
        ReservoirSimple rs = new ReservoirSimple(3);
        int MAX=Integer.MAX_VALUE;
        Object[] data=new Object[]{1,2,3,4,5,6,7,8,9,10};
        int[] radio=new int[data.length];
        IntStream.range(0,2000).forEach(i->{
            rs.pick(data);
            String[] index = rs.show().split(" ");
            for (int j = 0; j < index.length; j++) {
                Integer integer = Integer.valueOf(index[j]);
                radio[integer-1]++;
            }
        });

        for (int i = 0; i < radio.length; i++) {
            System.out.println("result"+data[i]+" ratio"+new Double(1.0*radio[i]/MAX));
        }

    }

    static class ReservoirSimple {
        private int k;
        private Object[] result;
        Random random;

        public ReservoirSimple() {
            this.k = 1;
            result = new Object[k];
            random = new Random();
        }

        public ReservoirSimple(int k) {
            this.k = k;
            result = new Object[k];
            random = new Random();
        }

        public void pick(Object[] data) {
            if (k >= data.length) {
                result = data;
            }
            if (k < data.length) {
                for (int i = 0; i < k; i++) {
                    result[i] = data[i];
                }
                for (int i = k; i < data.length; i++) {
                    int t = random.nextInt(i + 1);
                    if (t < k) {
                        int j = random.nextInt(k);
                        result[j] = data[i];
                    }
                }
            }
        }

        public String show() {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                stringBuffer.append(result[i] + " ");
            }
            return stringBuffer.toString();

        }

    }
}
