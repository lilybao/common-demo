package com.baoli.leetcode.day;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @program: common-demo
 * @description: 蓄水池算法，给定一个数据流，数据流长度N很大，且N直到处理完所有数据之前都不可知，
 * 请问如何在只遍历一遍数据（O（N））的情况下可以随机选取出m个不重复的数据  https://www.jianshu.com/p/7a9ea6ece2af
 * @author: li baojian
 * @create: 2020-04-14 17:54
 */
public class ReservoirDemo {

    static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {

        ReservoirSimple rs = new ReservoirSimple(3);
        int MAX = Integer.MAX_VALUE;
        Object[] data = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] radio = new int[data.length];
        IntStream.range(0, 2000).forEach(i -> {
            rs.getSingle(data);
            String[] index = rs.show().split(" ");
            for (int j = 0; j < index.length; j++) {
                Integer integer = Integer.valueOf(index[j]);
                radio[integer - 1]++;
            }
        });

        for (int i = 0; i < radio.length; i++) {
            System.out.println("result" + data[i] + " ratio" + new Double(1.0 * radio[i] / MAX));
        }

    }

    //分布式测试
    @Test
    public void testMulti() {
        //样本长度
        int len = 1000;
        //抽样长度
        int dataLength = 10000;
        //蓄水池长度
        int reservoirLength = 10;
        //每个数字被抽取到的次数
        int[] frequency = new int[len];
        int[] data = new int[len];
        for (int i = 0; i < len; i++) {
            data[i] = i;
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < dataLength; i++) {
            int[] single = getMulti(data, reservoirLength);
            for (int j = 0; j < single.length; j++) {
                int i1 = single[j];
                frequency[i1] += 1;
            }
        }
        printReservoirResultFrequency(frequency);

    }

    //单机版测试
    @Test
    public void test() {
        //样本长度
        int len = 1000;
        //抽样长度
        int dataLength = 100000;
        //蓄水池长度
        int reservoirLength = 10;
        //每个数字被抽取到的次数
        int[] frequency = new int[len];
        int[] data = new int[len];
        for (int i = 0; i < len; i++) {
            data[i] = i;
        }
        ReservoirSimple reservoirSimple = new ReservoirSimple(reservoirLength);
        long start = System.currentTimeMillis();
        for (int i = 0; i < dataLength; i++) {
            int[] single = reservoirSimple.getSingle(data);
            for (int j = 0; j < single.length; j++) {
                int i1 = single[j];
                frequency[i1] += 1;
            }
        }
        printReservoirResultFrequency(frequency);

    }

    private void printReservoirResultFrequency(int[] frequency) {
        //期望 方差 标准差
        double avg = 0;
        double var = 0;
        double sigma = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (i % 10 == 9) System.out.println();
            System.out.print(frequency[i] + ", ");
            avg += ((double) (frequency[i]) / frequency.length);
            var += ((double) (frequency[i] * frequency[i]) / frequency.length);
        }
        System.out.println("===========");
        var = var - avg * avg;
        sigma = Math.sqrt(var);
        System.out.println("average:  " + avg);
        System.out.println("variance:  " + var);
        System.out.println("standard deviation:  " + sigma);

    }

    // k 蓄水池长度    data  数据流
    public int[] getMulti(int[] data, int k) {
        int[] result;
        if (k < data.length) {
            result = new int[k];
        } else {
            result = new int[data.length];
        }
        Random random = new Random();
        List<Integer> list1 = getList(data.length, random);
        Integer l1 = list1.get(0);
        Integer l2 = list1.get(0);
        Integer l3 = list1.get(0);
        Future<int[]> future1 = executorService.submit(new ReservoirTask(Arrays.copyOfRange(data, 0, l1), k));
        Future<int[]> future2 = executorService.submit(new ReservoirTask(Arrays.copyOfRange(data, l1, l2), k));
        Future<int[]> future3 = executorService.submit(new ReservoirTask(Arrays.copyOfRange(data, l2, l3), k));
        Future<int[]> future4 = executorService.submit(new ReservoirTask(Arrays.copyOfRange(data, l3, data.length), k));
        List<Integer> f1 = getList(future1);
        List<Integer> f2 = getList(future2);
        List<Integer> f3 = getList(future3);
        List<Integer> f4 = getList(future4);
        for (int i = 0; i < k; i++) {
            int s = random.nextInt(data.length);
            if (s < l1) {
                result[i] = f1.remove(random.nextInt(f1.size()));
            } else if (s > l1 && s < l2) {
                result[i] = f2.remove(random.nextInt(f2.size()));
            } else if (s > l2 && s < l3) {
                result[i] = f3.remove(random.nextInt(f3.size()));
            } else if (s > l3 && s < data.length) {
                result[i] = f4.remove(random.nextInt(f4.size()));
            }
        }
        return result;
    }

    private List<Integer> getList(Future<int[]> future1) {
        int[] ints = new int[0];
        try {
            ints = future1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            list.add(ints[i]);
        }
        return list;
    }

    private List<Integer> getList(int length, Random random) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (treeSet.size() < 3) {
            treeSet.add(random.nextInt(length));
        }
        for (int i = 0; i < treeSet.size(); i++) {
            list.add(treeSet.pollFirst());
        }
        return list;
    }


    static class ReservoirTask implements Callable {
        //数据源
        private int[] resultData;
        //蓄水池长度
        private int m;

        public ReservoirTask(int[] resultData, int m) {
            this.resultData = resultData;
            this.m = m;
        }

        @Override
        public int[] call() throws Exception {
            ReservoirSimple reservoirSimple = new ReservoirSimple(m);
            return reservoirSimple.getSingle(resultData);
        }
    }

    static class ReservoirSimple {

        private Random random;
        private Object[] result;
        private int[] result1;
        private int k;

        public ReservoirSimple() {
            this.k = 1;
            random = new Random();
            result = new Object[k];
            result1 = new int[k];
        }

        public ReservoirSimple(int k) {
            this.k = k;
            random = new Random();
            result = new Object[k];
            result1 = new int[k];
        }


        public int[] getSingle(int[] data) {
            if (data.length < k) {
                result1 = data;
            } else {
                for (int i = 0; i < k; i++) {
                    result1[i] = data[i];
                }
                for (int i = k; i < data.length; i++) {
                    int g = random.nextInt(i + 1);
                    if (g < k) {
                        result1[g] = data[i];
                    }
                }
            }
            return result1;
        }

        public Object[] getSingle(Object[] data) {
            if (data.length < k) {
                result = data;
            } else {
                for (int i = 0; i < k; i++) {
                    result[i] = data[i];
                }
                for (int i = k; i < data.length; i++) {
                    int g = random.nextInt(i + 1);
                    if (g < k) {
                        result[g] = data[i];
                    }
                }
            }
            return result;
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
