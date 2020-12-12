package _每日一题._20年11月;

import _数据结构.ListNode;

import java.util.Arrays;

/**
 * @ClassName: _328奇偶链表
 * @Signature: Created by lerry_li on 2020/11/13
 * @Description: 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 */
public class _328奇偶链表 {
    /**
     * 解法1：双指针 时间O(N) 空间O(1)
     * 定义：
     * 指针p1：指向左边奇数下标的末尾节点
     * 指针p2：指向右边偶数下标的末尾节点
     * 处理：p2遍历到末尾停止
     * p2.next的下标是奇数下标，p1.next的下标是偶数下标
     * 用temp保存p2，p2=p2.next
     * 然后将p2插入到p1后面
     * p2=temp.next
     * p1=p1.next
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head, p2 = head.next;
        while (p2 != null && p2.next != null) {
            ListNode temp = p2;
            p2 = p2.next;
            temp.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p2 = temp.next;
            p1 = p1.next;
        }
        return head;
    }


}
