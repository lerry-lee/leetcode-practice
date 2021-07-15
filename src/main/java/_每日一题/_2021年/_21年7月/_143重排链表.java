package _每日一题._2021年._21年7月;

import _数据结构.ListNode;

/**
 * @ClassName: _143重排链表
 * @Author: lerry_li
 * @CreateDate: 2021/07/15
 * @Description
 */
public class _143重排链表 {
    /**
     * 前半个链表正序，后半个逆序，然后合并两只链表 时间O(N) 空间O(1)
     */
    public void reorderList(ListNode head) {
        //特判
        if (head == null || head.next == null) return;
        //找链表中点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //前半个链表
        ListNode l1 = head;
        //后半个链表逆序
        ListNode l2 = slow.next;
        slow.next = null;
        l2 = reverse(l2);
        //合并两个节点
        merge(l1, l2);
    }

    private void merge(ListNode l1, ListNode l2) {
        //交叉合并
        while (l1 != null && l2 != null) {
            ListNode temp1 = l1.next;
            l1.next = l2;
            l1 = temp1;
            ListNode temp2 = l2.next;
            l2.next = l1;
            l2 = temp2;
        }
    }

    private ListNode reverse_iterate(ListNode head) {
        //特判
        if (head == null || head.next == null) return head;
        //新头结点
        ListNode newHead = null;
        //遍历指针
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        //反转head->next
        ListNode newHead = reverse(head.next);
        //使head->next指向head
        ListNode next = head.next;
        next.next = head;
        //head->null,head称为尾节点
        head.next = null;
        return newHead;
    }
}
