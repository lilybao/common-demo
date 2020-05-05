package com.baoli.leetcode.day;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: common-demo
 * @description: 判断是否是二叉搜索树
 * @author: li baojian
 * @create: 2020-05-05 23:26
 */
public class BSTDemo {

    //广度优先搜索算法
    @Test
    public void testBFS() {
        TreeNode treeNode = init();
        boolean flag = isValidBST(treeNode);
        System.out.println(flag);
    }

    public boolean isValidBST(TreeNode root) {
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
        if(root==null){
            return true;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.add(treeNode.left);
                if (treeNode.left.val >=treeNode.val)
                    return false;
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
                if (treeNode.right.val <=treeNode.val) {
                    return false;
                }
            }
        }
        return true;
    }

    private TreeNode init() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(4);
        treeNode.right = treeNode1;
        treeNode1.left = new TreeNode(3);
        treeNode1.right = new TreeNode(6);
        return treeNode;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
