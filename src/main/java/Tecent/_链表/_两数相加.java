package Tecent._链表;

import DataStructure.ListNode;

/**
 * Created by lerry_li on 2020/09/28
 */

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class _两数相加 {
    /**
     * 解法1：模拟加法竖式
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = new ListNode();
        ListNode head = res;
        int sum = 0, jin = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + jin;
            jin = sum / 10;
            sum = sum % 10;
            res.next = new ListNode(sum);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + jin;
            jin = sum / 10;
            sum = sum % 10;
            res.next = new ListNode(sum);
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + jin;
            jin = sum / 10;
            sum = sum % 10;
            res.next = new ListNode(sum);
            res = res.next;
            l2 = l2.next;
        }
        if (jin > 0) res.next = new ListNode(jin);
        return head.next;
    }
}
