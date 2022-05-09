package _每日一题._2022年._5月;

import _数据结构.ListNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/10
 */
public class _82_删除排序链表中的重复元素2 {
    /**
     * 解法1：双指针 时间O(N) 空间O(1)
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(0, head);
            //prev表示已处理的，p1和p2用来遍历
            ListNode prev = dummy, p1 = head, p2 = head.next;
            while (p2 != null) {
                //如果p1和p2相同，p2找到第一个和p1不同的
                if (p1.val == p2.val) {
                    while (p2 != null && p1.val == p2.val) {
                        p2 = p2.next;
                    }
                    if(p2==null) {
                        prev.next = null;
                        break;
                    }
                    else{
                        prev.next=p2;
                        p1=p2;
                        p2=p2.next;
                    }
                }
                ////否则p1和p2不同
                else{
                    //将p1加入已处理
                    prev=prev.next;
                    p1=p1.next;
                    p2=p2.next;
                }
            }
            return dummy.next;
        }
    }
}
