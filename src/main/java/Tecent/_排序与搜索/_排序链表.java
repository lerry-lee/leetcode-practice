package Tecent._排序与搜索;

import DataStructure.ListNode;

/**
 * Created by lerry_li on 2020/10/18
 */

/**
 * 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class _排序链表 {
    /**
     * 解法1：递归分治：时间O(nlogn) 空间O(1)（不算递归产生的额外空间的话）
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        else {
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode right = slow.next;
            slow.next = null;
            return mergeSort(sortList(head), sortList(right));
        }
    }

    public ListNode mergeSort(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeSort(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeSort(l1, l2.next);
            return l2;
        }
    }
}
