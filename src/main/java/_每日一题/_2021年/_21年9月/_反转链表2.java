package _每日一题._2021年._21年9月;

import _数据结构.ListNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/10
 */
public class _反转链表2 {
    /**
     * 解法1：虚拟头结点+反转链表+拼接
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode aPrev = dummy;
        ListNode a = dummy.next;
        for (int i = 1; i < left; i++) {
            aPrev = aPrev.next;
            a = a.next;
        }
        ListNode b = a;
        for (int i = left; i < right; i++) {
            b = b.next;
        }
        ListNode bNext = b.next;
        aPrev.next = reverse(a, b);
        a.next = bNext;
        return dummy.next;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        if (a == b) return a;
        ListNode newHead = reverse(a.next, b);
        ListNode aNext = a.next;
        aNext.next = a;
        a.next = null;
        return newHead;
    }

    //部分反转链表之迭代法：适应于b不为null的情况
    private ListNode reverse2(ListNode a, ListNode b) {
        ListNode newHead = null;
        ListNode cur = a;
        while (cur != b) {
            ListNode curNext = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = curNext;
        }
        b.next=newHead;
        return b;
    }
}
