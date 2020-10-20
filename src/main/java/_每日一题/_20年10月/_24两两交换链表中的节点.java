package _每日一题._20年10月;

import _数据结构.ListNode;

/**
 * Created by lerry_li on 2020/10/13
 */
public class _24两两交换链表中的节点 {
    /**
     * 解法1：迭代：遍历的过程中两两交换
     */
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode node=head;
        ListNode newHead=head.next;
        ListNode pre=null;
        while(node!=null&&node.next!=null){
            ListNode temp=node.next;
            node.next=temp.next;
            temp.next=node;
            if(pre!=null){
                pre.next=temp;
            }
            pre=node;
            node=node.next;
        }
        return newHead;
    }
    /**
     * 解法2：递归
     */
    public ListNode swapPairs_(ListNode head) {
        //链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
        if (head == null || head.next == null) {
            return head;
        }
        //两两交换，新的头结点
        ListNode newHead = head.next;
        //递归
        head.next = swapPairs_(newHead.next);
        //完成两两交换
        newHead.next = head;
        return newHead;
    }

}
