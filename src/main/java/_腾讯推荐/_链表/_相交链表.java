package _腾讯推荐._链表;

import _数据结构.ListNode;

/**
 * Created by lerry_li on 2020/10/09
 */

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class _相交链表 {
    /**
     * 解法1：哈希表
     * 解法2：双指针（一个走到尾后去指向另一个链表的头）
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode tempA=headA,tempB=headB;
        while(true){
            if(tempA==tempB) return tempA;
            if(tempA==null) tempA=headB;
            else tempA=tempA.next;
            if(tempB==null) tempB=headA;
            else tempB=tempB.next;
        }

    }
}
