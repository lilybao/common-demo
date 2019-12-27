package com.baoli.leetcode.queue;/*
 * @项目名称: leetCode
 * @日期: 2019/5/24 0024 下午 4:42
 * @版权: 2019 河南中审科技有限公司 Inc. All rights reserved.
 * @开发公司或单位：河南中审科技有限公司研发中心
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MyQueue
 * @Description: TODO
 * @author: libaojian
 * @date: 2019/5/24 0024 下午 4:42
 * @version: V1.0
 */
public class MyQueue {
    private List<Integer> data;

    private Integer p_start;

    public MyQueue() {
        this.data = new ArrayList<Integer>();
        p_start=0;
    }
    public boolean enQueue(int x){
        data.add(x);
        return  true;
    }
    public boolean deQueue(){
            if(isEmpty()){
                return false;
            }
            p_start++;
            return  true;
    }
    public int front(){
        return data.get(p_start);
    }
    public boolean isEmpty(){
        return p_start>=data.size();
    }
}
