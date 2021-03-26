package _每日一题._2021年._21年3月;

import _工具类.CommonMethod;
import _数据结构.ListNode;

import java.util.Arrays;

/**
 * @ClassName: _83删除排序链表中的重复元素
 * @Author: lerry_li
 * @CreateDate: 2021/03/26
 * @Description
 */
public class _83删除排序链表中的重复元素 {
    /**
     * 解法1：使用指针一次遍历 时间O(N) 空间O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //prev节点和cur节点
        ListNode prev = dummy, cur = head;
        //cur节点遍历链表
        while (cur != null) {
            //cur节点和下一个节点不同时，可将cur节点加入新链表
            if (cur.next==null||cur.val != cur.next.val) {
                prev.next = cur;
                prev = prev.next;
            }
            //cur指向cur.next
            cur = cur.next;
        }
        //返回新链表头结点
        return dummy.next;
    }

    public static void main(String[] args) {
        _83删除排序链表中的重复元素 instance = new _83删除排序链表中的重复元素();
        ListNode head1 = CommonMethod.initListNode(Arrays.asList(1, 1, 2));
        ListNode head2 = CommonMethod.initListNode(Arrays.asList(1, 1, 2, 3, 3));
        CommonMethod.display(instance.deleteDuplicates(head1));
        CommonMethod.display(instance.deleteDuplicates(head2));
    }
}
