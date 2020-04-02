package com.baoli.leetcode.tree;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-04-01 11:32
 */
public class TreeBFSDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode.rootTree = root;
        root.insert(1);
        root.insert(5);
        root.insert(6);
        root.insert(7);
        root.insert(2);
        root.insert(3);
        root.insert(4);
        TreeNode treeNode = root.getTreeNode(2);
        System.out.println(treeNode.key);
        root.insert(8);
        TreeNode treeNode1 = root.getTreeNode(8);
        System.out.println(treeNode1);
        root.delete(2);
        System.out.println(root.get(2));
        System.out.println(root.toString());

    }


}
