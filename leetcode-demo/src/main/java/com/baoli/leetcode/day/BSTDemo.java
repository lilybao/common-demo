package com.baoli.leetcode.day;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;
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
//        TreeNode treeNode = init();
        TreeNode treeNode = new TreeNode(0);
        boolean flag = isValidBST1(treeNode);
//        ValidBST(treeNode);
        System.out.println(flag);
    }
    @Test
    public void test(){
        System.out.println(     Double.MIN_VALUE>0);
        System.out.println(     Long.MIN_VALUE>0);
        System.out.println(     Integer.MIN_VALUE>0);
    }

    //中序遍历，先递归左子树 在递归右子树
    long pre = Long.MIN_VALUE;


    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        //访问左子树
        if (!isValidBST1(root.left)) {
            return false;
        }
        //访问当前节点
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        //访问右子树
        return isValidBST1(root.right);
    }

    public TreeNode nextTreeNode = null;
    public boolean flag = true;

    //中序遍历  中序遍历结果为一个递增序列
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<>();
        double nextVal = -Double.MAX_VALUE;
        while (!treeNodes.isEmpty() || root != null) {
            while (root != null) {
                treeNodes.add(root);
                root = root.left;
            }
            root = treeNodes.pop();
            if (root.val <= nextVal) {
                return false;
            }
            nextVal = root.val;
            root = root.right;
        }
        return true;
    }

    private void addBST(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            addBST(root.left, list);
            list.add(root.val);
            addBST(root.right, list);
        }
    }

    //递归 时间复杂度  O(n) 空间复杂度  O(n) n 为节点的个数，每次入栈都要占用一个内存空间
    private void ValidBST(TreeNode currentNode) {
        if (currentNode != null) {
            ValidBST(currentNode.left);
            if (nextTreeNode == null) {
                nextTreeNode = currentNode;
            } else {
                if (currentNode.val <= nextTreeNode.val) {
                    flag = false;
                }
                nextTreeNode = currentNode;
            }
            ValidBST(currentNode.right);
        }
    }

    private TreeNode init() {
        TreeNode treeNode = new TreeNode(12);
        treeNode.left = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(15);
        treeNode.right = treeNode1;
        treeNode1.left = new TreeNode(10);
        treeNode1.right = new TreeNode(20);
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
