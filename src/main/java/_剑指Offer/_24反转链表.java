package _剑指Offer;

import _数据结构.ListNode;

/**
 * @author lerrylee
 * @version 1.0.0
 * @className _24反转链表
 * @date 上午10:31 20-9-11
 * @description 反转链表
 **/
public class _24反转链表 {
    /**
     * 解法1：迭代：双指针法
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null, cur=head;
        while (cur != null) {
            ListNode next=cur.next;
            cur.next=newHead;
            newHead=cur;
            cur=next;
        }
        return newHead;
    }

    /**
     * 解法2：递归
     * 使用递归函数，一直递归到链表的最后一个结点，该结点就是反转后的头结点，记作 newHead .
     * 此后，每次函数在返回的过程中，让当前结点的下一个结点的 next指针指向当前节点。
     * 同时让当前结点的 next指针指向 NULL，从而实现从链表尾部开始的局部反转
     * 当递归函数全部出栈后，链表反转完成。
     */
    public ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) return head;
        //head的next递归实现反转
        //反转前，head.next是后面链表的头结点
        ListNode newHead = reverseList_recursive(head.next);
        //反转后,head.next是后面链表的尾结点了
        ListNode headNext=head.next;
        //将反转后的链表的尾结点.next指向head即可
        headNext.next = head;//当前节点和下一个节点反转：head的下一个节点指向head
        head.next = null;
        return newHead;
    }
}
