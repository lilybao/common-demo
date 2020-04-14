package com.baoli.thread.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @program: common-demo
 * @description: 计算数值任务
 * @author: li baojian
 * @create: 2020-04-13 15:26
 */
public class SumForkJoinTask extends RecursiveTask<Integer> {
    private int[] src;

    private int threshold;//阈值

    private static final int segmentation = 10;//切分片段

    private int start;
    private int end;

    public SumForkJoinTask(int[] src, int start, int end) {
        this.src = src;
        this.start = start;
        this.end = end;
        this.threshold = src.length / segmentation;
    }

    @Override
    protected Integer compute() {
        if (end - start < threshold) {
            int sum = 0;
            System.out.println("begin compute start "+start+" end "+end);
            for (int i = start; i < end; i++) {
                sum += src[i];
            }
            return sum;

        } else {
            int mid = (end + start) / 2;
            SumForkJoinTask leftTask = new SumForkJoinTask(src, start, mid);
            SumForkJoinTask rightTask = new SumForkJoinTask(src, mid+1, end);
            invokeAll(leftTask,rightTask);
            return leftTask.join()+rightTask.join();
        }
    }
}
