package com.baoli.leetcode.day;

import javax.swing.*;
import java.util.Arrays;

/**
 * @program: common-demo
 * @description: 单词的压缩编码
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 * @author: li baojian
 * @create: 2020-03-29 11:15
 */
public class MinimumLengthEncodingDemo {
    public static void main(String[] args) {
//        String[] words = {"time", "me", "bell"};
        String[] words = {"me", "time"};
        int length = getLength(words);
        System.out.println(length);
    }

    private static int getLength(String[] words) {
        Tree tree = new Tree();
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            count += tree.insert(words[i]);
        }

        return count;
    }


    static class Tree {
        TreeNode root;

        public Tree() {
            this.root = new TreeNode(' ');
        }
        public int insert(String word) {
            TreeNode current = root;
            boolean newWords = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (current.treeNode[c - 'a'] == null) {
                    current.treeNode[c - 'a'] = new TreeNode(c);
                    newWords = true;
                }
                current = current.treeNode[c - 'a'];
            }
            return newWords ? word.length() + 1 : 0;
        }
    }

    static class TreeNode {
        private char value;
        private TreeNode[] treeNode = new TreeNode[26];
        public TreeNode(char value) {
            this.value = value;
        }
    }
}
