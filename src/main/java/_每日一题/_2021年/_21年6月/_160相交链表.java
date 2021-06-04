package _每日一题._2021年._21年6月;

import _数据结构.ListNode;

/**
 * @ClassName: _160相交链表
 * @Author: lerry_li
 * @CreateDate: 2021/06/04
 * @Description
 * 解法1：哈希表
 * 解法2：双指针
 */
public class _160相交链表 {
    /**
     * 解法2：双指针 时间O(M+N) 空间O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //特判
        if (headA == null || headB == null) return null;
        //双指针
        ListNode p1 = headA, p2 = headB;
        while (p1!=p2) {
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }
}
