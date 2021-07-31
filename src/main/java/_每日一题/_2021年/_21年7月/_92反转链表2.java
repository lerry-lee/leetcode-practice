package _每日一题._2021年._21年7月;

import _数据结构.ListNode;

/**
 * @ClassName: _92反转链表2
 * @Author: lerry_li
 * @CreateDate: 2021/07/31
 * @Description
 */
public class _92反转链表2 {
    /**
     * 解法1：反转子链表+前后拼接 时间O(N) 空间O(1)
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //特判
        if (head == null || head.next == null) return head;
        //虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //遍历指针
        ListNode a = dummy.next, b = dummy.next;
        ListNode aPrev = dummy;
        //遍历链表
        int idx = 1;//head头结点下标从1开始
        while (idx < right) {
            if (idx < left) {
                a = a.next;
                aPrev = aPrev.next;
            }
            b = b.next;
            idx++;
        }
        ListNode bNext = b.next;
        //翻转[a,b]
        b.next = null;
        reverse(a);
        aPrev.next = b;
        a.next = bNext;
        return dummy.next;
    }

    private void reverse(ListNode a) {
        ListNode newHead = null, cur = a;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = curNext;
        }
    }
}
