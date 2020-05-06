package com.baoli.leetcode.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: common-demo
 * @description: 双指针算法
 * @author: li baojian
 * @create: 2020-04-27 15:15
 */
public class TwoIndexDemo {
    /**
     * 有序数组中的两个数加起来 和为target
     */
    @Test
    public void sumTwoSequence() {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] ints = twoSum(nums, target);
        System.out.println(ints);

    }

    /**
     * 查找根据某个点旋转后的有序数组 是否包含某个元素
     */
    @Test
    public void searchIndex() {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {3, 1};
        int target = 1;
        int search = search1(nums, target);
        System.out.println(search);

    }

    /**
     * 归并两个有序数组 合并数组到第一个数组中
     */
    @Test
    public void mergeTwoSequence() {
        int[] arr1 = {1, 3, 5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arr2 = {2, 3, 5, 8, 9, 11};
        int m = 4;
        int n = 6;
        int[] arr = mergeTwoArray(arr1, m, arr2, n);
        System.out.println(arr);
    }

    private int[] mergeTwoArray(int[] arr1, int m, int[] arr2, int n) {
        int[] tmp = new int[m];
        System.arraycopy(arr1, 0, tmp, 0, m);
        int t = 0;
        int a = 0;
        while (a < n && t < m) {
            if (tmp[t] <= arr2[a]) {
                arr1[t + a] = tmp[t];
                t++;
            } else {
                arr1[t + a] = arr2[a];
                a++;
            }
        }
        if (a < n) {
            System.arraycopy(arr2, a, arr1, a + t, n - a);
        }
        if (t < m) {
            System.arraycopy(tmp, t, arr1, a + t, m - t);
        }
        return arr1;
    }

    /**
     * 获取链表的交点
     */
    @Test
    public void IntersectionNode() {
        ListNode listNode = new ListNode(3);
        ListNode headA = new ListNode(9);
        ListNode headB = new ListNode(15);
        ListNode tmpNode=listNode;
        ListNode tmpHeadA=headA;
        ListNode tmpHeadB=headB;
        int i=3;
        while ( i++<6) {
            tmpNode.next = new ListNode(i);
            tmpNode=tmpNode.next;
        }
        while (i++<8){
            tmpHeadA.next=new ListNode(i);
            tmpHeadA=tmpHeadA.next;
        }
//        tmpHeadA.next=listNode;
        while (i++<15){
            tmpHeadB.next=new ListNode(i);
            tmpHeadB=tmpHeadB.next;
        }
//        tmpHeadB.next=listNode;
        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);

    }

    /**
     * 判断两个链表是否相交  如果相交找到交点。
     */
    @Test
    public void test(){
        ListNode headA = new ListNode(3);
        ListNode headB = new ListNode(2);
        headB.next=headA;
        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        if(node1==null||node2==null){
            return null;
        }
        while (node1 != node2) {
            if(node1.next==null&&node2.next==null){
                return null;
            }
            node1 = node1.next==null?headB:node1.next;
            node2 = node2.next==null?headA:node2.next;
        }
        return node1;

    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * 反转字符串中的元音字符
     */
    @Test
    public void reverseChar() {
//        char[] chars={'a','e','i','o','u','A','E','I','O','U'};
        String s = "ellillo";
        HashSet<Character> characters = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = new char[s.length()];
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if (!characters.contains(lc)) {
                chars[l++] = lc;
            } else if (!characters.contains(rc)) {
                chars[r--] = rc;
            } else {
                chars[l++] = rc;
                chars[r--] = lc;
            }

//            if (characters.contains(chars[l]) && characters.contains(chars[r])) {
//                char tmp = chars[l];
//                chars[l] = chars[r];
//                chars[r] = tmp;
//            } else if (characters.contains(chars[l])) {
//                r--;
//                continue;
//            } else if (characters.contains(chars[r])) {
//                l++;
//                continue;
//            }
//            r--;
//            l++;
        }
        String string = new String(chars);
        System.out.println(string);
    }

    /**
     * 至多删除一个字符串是否构成回文字符串
     */
    @Test
    public void test3() {
//        String s = "ebcbbececabbacecbbcbe";
        String s = "abc";
//        String s = "atbbga";
        boolean b = validPalindrome(s);

        System.out.println(b);
    }

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return validPalindrome(s, i + 1, j) || validPalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


    /**
     * @param nums
     * @param target 二分查找   时间复杂度  O（log n）  空间复杂度的 O（1）
     * @return
     */
    public int search1(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int mid;
        while (leftIndex <= rightIndex) {
            mid = (leftIndex + rightIndex) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    rightIndex = mid - 1;
                } else {
                    leftIndex = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    leftIndex = mid + 1;
                } else {
                    rightIndex = mid - 1;
                }
            }
        }
        return -1;

    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int index;
        while (leftIndex <= rightIndex) {
            if (nums[leftIndex] == target) {
                return leftIndex;
            } else if (nums[rightIndex] == target) {
                return rightIndex;
            } else if (nums[leftIndex] > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return -1;

    }

    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            if (numbers[leftIndex] + numbers[rightIndex] == target) {
                arr[0] = leftIndex + 1;
                arr[1] = rightIndex + 1;
                break;
            } else if (numbers[leftIndex] + numbers[rightIndex] > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return arr;
    }

    /**
     * 二分查找  数组 中是否包含某个元素
     */
    @Test
    public void test2() {
        int[] nums = {1, 23, 54, 43, 67, 86, 55};
        fastSort(nums, 0, nums.length - 1);
        int target = 33;
        int index = twoSplitSearch(nums, target);
        System.out.println(index);
        System.out.println(nums);
    }

    /**
     * 二分查找  双指针
     *
     * @param nums
     * @param target
     * @return
     */
    private int twoSplitSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private void fastSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = particition(nums, left, right);
            fastSort(nums, left, mid - 1);
            fastSort(nums, mid + 1, right);
        }
    }

    private int particition(int[] nums, int left, int right) {
        int i = left;
        int j = right + 1;
        int mid = nums[left];
        while (true) {
            while (--j > i && nums[j] > mid) ;
            while (++i < j && nums[i] < mid) ;
            if (i >= j) {
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[left] = nums[j];
        nums[j] = mid;
        return j;
    }
}
