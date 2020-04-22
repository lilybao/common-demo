package com.baoli.leetcode.day;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @program: common-demo
 * @description: 二叉树右视图
 * @author: li baojian
 * @create: 2020-04-22 11:23
 */
public class RightSideView {


    // DFS
    @Test
    public void testDFS() {
        TreeNode treeNode = initTreeNode();
        List<Integer> list = rightSideView(treeNode);
        list.stream().forEach(integer -> {
            System.out.println(integer);
        });
    }


    @Test
    public void test4(){
        TreeNode treeNode = initTreeNode();
        HashMap<Integer, Integer> map = new HashMap<>();
       rightSideView2(treeNode,0,map);
        System.out.println(map);
    }

    public void rightSideView2(TreeNode root,int depth,Map<Integer,Integer> map) {
        TreeNode node =root;
        int dept=depth;
        if(node!=null){
            if(!map.containsKey(dept)){
                map.put(dept,node.val);
            }
            if(node.right!=null){
                rightSideView2(node.right,dept++,map);
            }
            if(node.left!=null){
                rightSideView2(node.left,dept--,map);
            }

        }

    }


    @Test
    public void test(){
        System.out.println((0.1*3==0.3)+" "+0.1*3+" "+0.3*1);
        System.out.println((0.1*4==0.4)+"  "+0.1*4+" "+0.4*1);
    }



    // DFS
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> mostDepthValue = new HashMap<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Integer depth = depthStack.pop();
            if (node != null) {
                if (!mostDepthValue.containsKey(depth)) {
                    mostDepthValue.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer key : mostDepthValue.keySet()) {
            list.add(mostDepthValue.get(key));
        }
        return list;

    }


    // BFS  使用队列
    @Test
    public void testBFS() {
        TreeNode treeNode = initTreeNode();
        List<Integer> list = rightSideView1(treeNode);
        list.stream().forEach(integer -> {
            System.out.println(integer);
        });
    }

    //BFS
    public List<Integer> rightSideView1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = null;
            while (!queue.isEmpty()) {
                node = queue.poll();
                if (node.left != null) {
                    queue2.add(node.left);
                }
                if (node.right != null) {
                    queue2.add(node.right);
                }
            }
            list.add(node.val);
            queue.addAll(queue2);
            queue2.clear();
        }
        return list;
    }

    private void getdepth(TreeNode node, int depth, Map<Integer, Integer> map) {
        if (!map.containsKey(depth)) {
            map.put(depth, node.val);
        }
    }

    private void getRightSide(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        while (root.left != null && root.right != null) {
            getRightSide(root.left, list);
            getRightSide(root.right, list);
        }

    }

    private TreeNode initTreeNode() {
        //[1,2,3,null,5,null,4]
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);

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
