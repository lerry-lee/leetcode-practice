package _每日一题._2022年._5月;

import _数据结构.ListNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/17
 */
public class _234_回文链表 {
    /**
     * 解法1：快慢指针+反转链表 时间O(N) 空间O(1)
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) return false;
            ListNode fast = head, slow = head;
            ListNode prev = new ListNode(0, head);
            while (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                prev = prev.next;
                //偶数个节点
                if (fast == null) {
                    break;
                }
                //奇数个节点
                if (fast.next == null) {
                    slow = slow.next;
                    break;
                }
            }
            prev.next = null;
            ListNode newHead = reverse(slow);
            while (newHead != null) {
                if (newHead.val != head.val) {
                    return false;
                }
                newHead = newHead.next;
                head = head.next;
            }
            return true;
        }

        private ListNode reverse(ListNode head) {
            ListNode newHead = null, cur = head;
            while (cur != null) {
                ListNode curNext = cur.next;
                cur.next = newHead;
                newHead = cur;
                cur = curNext;
            }
            return newHead;
        }
    }
}
