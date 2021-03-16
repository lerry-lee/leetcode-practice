package _每日一题._2021年._21年3月;

import _数据结构.ListNode;

/**
 * @ClassName: _25K个一组翻转链表
 * @Author: lerry_li
 * @CreateTime: 2021/03/16
 * @Description
 */
public class _25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //区间[a,b)包含k个待翻转的元素
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            //不足k个不需要翻转,base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        //翻转[a,b)的k个元素
        ListNode newHead = reverse(a, b);
        //翻转后a成了尾结点，将递归的结果链表拼接，即a的next指向递归后的链表头结点
        a.next = reverseKGroup(b, k);
        return newHead;

    }

    //翻转[a,b)区间内的元素，如果b==null就是翻转链表的代码
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode newHead = null, cur = a;
        while (cur != b) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }
}
