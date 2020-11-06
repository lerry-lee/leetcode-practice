package Tecent._链表;

import DataStructure.ListNode;

/**
 * Created by lerry_li on 2020/10/01
 */
public class _旋转链表 {
    /**
     * 解法1：链表成环
     * 解法2：统计个数
     * 首先遍历链表，同时统计节点总数n
     * k%n，若为0，直接返回head
     * 否则，找倒数第n-k个节点，该节点为newHead
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null ||head.next==null|| k == 0) return head;
        int n=1;
        ListNode tail=head;
        while(tail.next!=null) {
            tail=tail.next;
            n++;
        }
        int t=k%n;
        if(t==0) return head;
        ListNode newTail=head;
        for (int i = 1; i < n-t; i++) {
            newTail=newTail.next;
        }
        ListNode newHead=newTail.next;
        newTail.next=null;
        tail.next=head;
        return newHead;
    }

}
