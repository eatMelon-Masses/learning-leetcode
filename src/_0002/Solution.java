package _0002;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode result = new ListNode(0);
        final ListNode head = result;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (l1 != null && l2 != null) {
            if (jinwei > 0) {
                result.val += jinwei;
                jinwei = 0;
            }
            final int temp = l1.val + l2.val + result.val;
            if (temp > 9) {
                jinwei = temp / 10;
            }
            result.val = temp % 10;
            p1 = l1;
            l1 = l1.next;
            p2 = l2;
            l2 = l2.next;
            if (l1 == null && l2 != null && jinwei != 0) {
                p1.next = new ListNode(jinwei);
                l1 = p1.next;
                jinwei = 0;
            } else if (l2 == null && l1 != null && jinwei != 0) {
                p2.next = new ListNode(jinwei);
                l2 = p2.next;
                jinwei = 0;
            }
            if (l1 != null && l2 != null) {
                result.next = new ListNode(0);
                result = result.next;
            }
        }
        if (jinwei != 0) {
            result.next = new ListNode(jinwei);
        }
        if (l1 != null) {
            result.next = l1;
        }
        if (l2 != null) {
            result.next = l2;
        }
        return head;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(final int x) {
        val = x;
    }
}
// @lc code=end

