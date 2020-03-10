package com.baoli.leetcode.day;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 零钱兑换
 * 动态规划的关键有一个最优的子结构性质，然后 自上而下 或者自下而上
 */
public class CoinChangeDemo {
    public static void main(String[] args) {
//        int[] coins = {1, 2, 5, 7, 23, 3};

        int[] coins = {1861, 4191, 83, 408};
        int amount = 6249;
        int i = getMinCounts(coins, amount);
        System.out.println(i);
    }

    private static int getMinCounts(int[] coins, int amount) {
        int max=amount+1;
        int[] dp=new int[max];
        Arrays.fill(dp,max);
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }

        }
        return dp[amount]>amount?-1:dp[amount];
    }

    private static int getMinCount(int[] coins, int amount) {
        //硬币从大到小放入队列中 冒泡排序 时间复杂度 O((m+1)m/2)  从小到大
        ArrayQueue<Integer> cos = new ArrayQueue<Integer>(coins.length);
        for (int i = 0; i < coins.length; i++) {
            for (int j = i + 1; j < coins.length; j++) {
                if (coins[i] > coins[j]) {
                    int m = 0;
                    m = coins[i];
                    coins[i] = coins[j];
                    coins[j] = m;
                }
            }
        }

        int s = 1;
        int l = 0;
        int sum1 = 0;
        while (s <= coins.length) {
            int am = amount;
            int sum = 0;
            int m = 0;
            int n = 0;
            for (int i = coins.length - s; i >= 0; i--) {
                m = am / coins[i];//商
                n = am % coins[i];//余数
                am = n;
                sum = sum + m;
                if (n == 0) {
                    break;
                }
            }
            s++;
            l = n;
            sum1 = sum;
        }

        if (l != 0) {
            return -1;
        }
        return sum1;
    }
}
