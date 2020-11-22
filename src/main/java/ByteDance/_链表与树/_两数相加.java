package ByteDance._链表与树;

import DataStructure.ListNode;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/15 22:22
 * @description 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode res = node;
        int jin = 0;
        int jia = 0;
        while (l1 != null && l2 != null) {
            jia = l1.val + l2.val + jin;
            node.next = new ListNode(jia % 10);
            jin = jia / 10;
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        while (l1 != null) {
            jia = l1.val + jin;
            node.next = new ListNode(jia % 10);
            l1 = l1.next;
            node = node.next;
            jin = jia / 10;
        }
        while (l2 != null) {
            jia = l2.val + jin;
            node.next = new ListNode(jia % 10);
            l2 = l2.next;
            node = node.next;
            jin = jia / 10;
        }
        if (jin > 0) node.next = new ListNode(jin);
        return res.next;
    }
}
