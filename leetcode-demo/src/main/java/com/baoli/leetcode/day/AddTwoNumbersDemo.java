package com.baoli.leetcode.day;

import sun.misc.Queue;

import javax.xml.soap.Node;
import java.util.Stack;
import java.util.Vector;

/**
 * @program: common-demo
 * @description: 两数相加
 * @author: li baojian
 * @create: 2020-04-14 21:33
 */
public class AddTwoNumbersDemo {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(7);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(4);
//        listNode.next.next.next = new ListNode(3);
        ListNode listNode1 = new ListNode(5);
//        listNode1.next = new ListNode(6);
//        listNode1.next.next = new ListNode(4);
        ListNode listNode2 = addTwoNumbers(listNode, listNode1);
        System.out.println(listNode2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode returnNode = null;
        node = l1;
        while (node != null) {
            s1.add(node.val);
            node = node.next;
        }
        node = l2;
        while (node != null) {
            s2.add(node.val);
            node = node.next;
        }
        boolean flag = false;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (s1.empty() && s2.empty()) {
                break;
            }
            Integer p1;
            Integer p2;
            if (s1.empty()) {
                p1 = 0;
            } else {
                p1 = s1.pop();
            }
            if (s2.empty()) {
                p2 = 0;
            } else {
                p2 = s2.pop();
            }
            int i1 = flag ? (p1 + p2 + 1) / 10 : (p1 + p2) / 10;
            int t = flag ? (p1 + p2 + 1) % 10 : (p1 + p2) % 10;
            if (i1 > 0) {
                flag = true;
            } else {
                flag = false;
            }
            ListNode listNode = new ListNode(t);
            if (returnNode != null) {
                listNode.next = returnNode;
            }
            returnNode = listNode;
        }
        if (flag) {
            ListNode listNode = new ListNode(1);
            listNode.next = returnNode;
            returnNode = listNode;
        }
        return returnNode;
    }

    private static int getValue(ListNode l1, ListNode l2) {
        int a = 0;
        int b = 0;
        if (l1 != null) {
            a = l1.val;
        }
        if (l2 != null) {
            b = l2.val;
        }
        if (l1.next != null || l2.next != null) {
            return getValue(l1.next, l2.next);
        }
        return a + b;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
