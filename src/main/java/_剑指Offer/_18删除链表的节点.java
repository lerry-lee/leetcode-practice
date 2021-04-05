package _剑指Offer;

import _数据结构.ListNode;

/**
 * @ClassName: _18删除链表的节点
 * @Author: lerry_li
 * @CreateDate: 2021/04/05
 * @Description
 */
public class _18删除链表的节点 {
    /**
     * 解法1：perv+cur 一次遍历 时间O(N) 空间O(1)
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur.next = null;
            }
            cur = cur.next;
            prev = prev.next;
        }
        return dummy.next;
    }
}
