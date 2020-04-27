package com.baoli.leetcode.linkedlist;

import com.sun.deploy.util.ArrayUtil;
import org.junit.Test;

import javax.swing.*;
import java.util.Arrays;

/**
 * @program: common-demo
 * @description: 链表 单端和双端
 * @author: li baojian
 * @create: 2020-04-23 15:34
 */
public class LinkedDemo {

    /**
     * 合并两个有序队列    1,3,5,7,9   2,4,6,8,10
     */
    @Test
    public void mergeTwoSequenceListNode() {
        ListNode listNode1 = init1();
        ListNode listNode2 = init2();
        ListNode listNode = merge(listNode1, listNode2);
        System.out.println(listNode);

    }

    /**
     * 合并两个有序数组。
     */
    @Test
    public void mergeTwoSequenceArray() {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10,12,14};
        int[] arr = mergeArray(arr1, arr2);
        System.out.println(arr);
    }

    private int[] mergeArray(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int arr1Index = 0;
        int arr2Index = 0;
        int i = 0;
        while (arr1Index < arr1.length || arr2Index < arr2.length) {
            if (arr1Index < arr1.length && arr2Index < arr2.length) {
                if (arr1[arr1Index] > arr2[arr2Index]) {
                    arr[i++] = arr2[arr2Index++];
                } else {
                    arr[i++] = arr1[arr1Index++];
                }
            } else if (arr1Index < arr1.length) {
                arr[i++] = arr1[arr1Index++];
            } else {
                arr[i++] = arr2[arr2Index++];
            }
        }
        return arr;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode tailNode = new ListNode(-1);
        ListNode prev = tailNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                prev.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return tailNode.next;
    }

    private ListNode init1() {
        ListNode listNode = new ListNode(-1);
        ListNode tmpNode = listNode;
        int i = 1;
        while (i <= 9) {
            tmpNode.next = new ListNode(i);
            i = i + 2;
            tmpNode = tmpNode.next;
        }
        return listNode.next;
    }

    private ListNode init2() {
        ListNode listNode1 = new ListNode(-1);
        ListNode tmpNode = listNode1;
        int i = 2;
        while (i <= 10) {
            tmpNode.next = new ListNode(i);
            i = i + 2;
            tmpNode = tmpNode.next;
        }
        return listNode1.next;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode merge1(ListNode listNode1, ListNode listNode2) {
        ListNode tailNode = new ListNode(-1);
        ListNode tmpNode = tailNode;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val > listNode2.val) {
                tmpNode.next = new ListNode(listNode2.val);
                listNode2 = listNode2.next;
            } else {
                tmpNode.next = new ListNode(listNode1.val);
                listNode1 = listNode1.next;
            }
            tmpNode = tmpNode.next;
        }
        tmpNode.next = listNode1 == null ? listNode2 : listNode1;
        return tailNode.next;

    }

}
