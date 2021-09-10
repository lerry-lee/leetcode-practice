package _每日一题._2021年._21年9月;

import _数据结构.ListNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/10
 */
public class _24两两交换链表中的节点 {
    /**
     * 解法1：递归
     */
    public ListNode swapPairs(ListNode head) {
        //特判
        if (head == null || head.next == null) return head;
        //下一组节点
        ListNode nextNode = head.next.next;
        //两个一组交换
        ListNode newHead = head.next;
        newHead.next = head;
        //接上后面
        head.next = swapPairs(nextNode);
        return newHead;
    }
}
