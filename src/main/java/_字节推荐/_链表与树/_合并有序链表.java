package _字节推荐._链表与树;

import _数据结构.ListNode;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class _合并有序链表 {

    public ListNode mergeTwoLists() {
        ListNode l1, l2;
        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = new ListNode();
        ListNode root = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {

                res.next = new ListNode(l1.val);
                res = res.next;
                l1 = l1.next;
            } else {

                res.next = new ListNode(l2.val);
                res = res.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            res.next = l2;
        } else {
            res.next = l1;
        }

        return root.next;
    }


    //递归法 真的是秒，不需要额外空间，直接在原链表操作
    public void m2() {
        ListNode l1, l2;
        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode root = m2_recursive(l1, l2);

    }

    public ListNode m2_recursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = m2_recursive(l1.next, l2);
            return l1;
        } else {
            l2.next = m2_recursive(l1, l2.next);
            return l2;
        }
    }

}

/**
 * 思路
 * 标签：链表、递归
 * 这道题可以使用递归实现，新链表也不需要构造新节点，我们下面列举递归三个要素
 * 终止条件：两条链表分别名为 l1 和 l2，当 l1 为空或 l2 为空时结束
 * 返回值：每一层调用都返回排序好的链表头
 * 本级递归内容：如果 l1 的 val 值更小，则将 l1.next 与排序好的链表头相接，l2 同理
 * O(m+n)O(m+n)，mm 为 l1的长度，nn 为 l2 的长度
 * <p>
 * <p>
 * class Solution {
 * public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
 * if(l1 == null) {
 * return l2;
 * }
 * if(l2 == null) {
 * return l1;
 * }
 * <p>
 * if(l1.val < l2.val) {
 * l1.next = mergeTwoLists(l1.next, l2);
 * return l1;
 * } else {
 * l2.next = mergeTwoLists(l1, l2.next);
 * return l2;
 * }
 * }
 * }
 */