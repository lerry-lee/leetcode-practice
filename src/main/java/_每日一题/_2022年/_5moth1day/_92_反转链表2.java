package _每日一题._2022年._5moth1day;

import _数据结构.ListNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _92_反转链表2 {
    /**
     * 解法1：迭代
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(head==null) return null;
            ListNode dummy=new ListNode(0,head);
            ListNode prev=dummy,cur=dummy.next;
            for (int i = 1; i < left; i++) {
                prev=prev.next;
                cur=cur.next;
            }
            ListNode a=cur;
            for (int i = left; i < right; i++) {
                cur=cur.next;
            }
            ListNode b=cur;
            ListNode bNext=b.next;
            prev.next=reverse(a,bNext);
            a.next=bNext;
            return dummy.next;
        }

        private ListNode reverse(ListNode a, ListNode bNext) {
            ListNode newHead=null,cur=a;
            while(cur!=bNext){
                ListNode curNext=cur.next;
                cur.next=newHead;
                newHead=cur;
                cur=curNext;
            }
            return newHead;
        }

    }
}
