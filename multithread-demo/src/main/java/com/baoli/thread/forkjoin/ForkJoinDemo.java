package com.baoli.thread.forkjoin;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @program: common-demo
 * @description: fork/join框架
 * @author: li baojian
 * @create: 2020-04-13 14:50
 */
public class ForkJoinDemo {
    public static void main(String[] args) {
        int [] src=new int[1000];
        for (int i = 0; i <1000 ; i++) {
            src[i]=i;
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SumForkJoinTask sumForkJoinTask = new SumForkJoinTask(src, 0, src.length - 1);
//        forkJoinPool.submit(sumForkJoinTask);
        long start = System.currentTimeMillis();
        forkJoinPool.invoke(sumForkJoinTask);
        System.out.println("sum="+sumForkJoinTask.join()+"take time is "+(System.currentTimeMillis()-start)+"ms");
    }
}
