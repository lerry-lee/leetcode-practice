package _每日一题._2021年._21年3月;

import _数据结构.ListNode;

/**
 * @ClassName: _61旋转链表
 * @Author: lerry_li
 * @CreateTime: 2021/03/27
 * @Description
 */
public class _61旋转链表 {
    /**
     * 解法1：两次遍历 时间O(N) 空间O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        cur = head;
        ListNode prev = cur;
        for (int i = 0; i < len - k; i++) {
            if (i > 0) {
                prev = prev.next;
            }
            cur = cur.next;
        }

        prev.next = null;

        ListNode newHead = cur;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }
}
