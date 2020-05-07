package com.baoli.leetcode.day;

import org.junit.Test;

/**
 * @program: common-demo
 * @description: 判断一颗二叉树是另一颗二叉树的子树
 * @author: li baojian
 * @create: 2020-05-07 08:49
 */
public class IsSubTree {

    @Test
    public void test() {
        TreeNode s = init1();
        TreeNode t = init2();
        boolean subtree = isSubtree1(t, s);
        System.out.println(subtree);
    }
    //中序遍历  时间复杂度  O（n） 空间复杂度 O(n)
    private boolean isSubtree1(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        //中间节点
        if(s.val==t.val&&compare(s,t)){
            return true;
        }
        //左子树
        if(isSubtree1(s.left,t)){
           return true;
        }
        //右子树
        return isSubtree1(s.right,t);
    }


    private TreeNode init2() {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(5);
        treeNode1.left = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        return treeNode;

    }

    private TreeNode init1() {
        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.left = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        return treeNode1;
    }

    //中序遍历
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        //中间值
        if (s.val == t.val && compare(s, t)) {
            return true;
        }
        //遍历左子树
        if (isSubtree(s.left, t)) {
            return true;
        }
        //右子树
        return isSubtree(s.right, t);
    }

    //DFS
    private boolean compare(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }else if(s==null||t==null){
            return false;
        }
        //左子树
        if (!compare(s.left, t.left)) {
            return false;
        }
        //中间节点
        if(s.val!=t.val){
            return false;
        }
        //右子树
        return compare(s.right, t.right);
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
