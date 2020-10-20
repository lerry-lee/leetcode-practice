package _每日一题._20年10月;

import _数据结构.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lerry_li on 2020/10/20
 */
public class _143重排链表 {
    /**
     * 解法1：线性表 时间O(N) 空间O(N)
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        //这里连接链表节点很关键
        while (i < j) {
            //头连尾，头->next
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            //尾连头，尾->pre
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;

    }

    /**
     * 解法2：寻找链表重点+链表逆序+合并链表 时间O(N) 空间O(1)
     */

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;//当前节点和下一个节点反转：head的下一个节点指向head
        head.next = null;
        return newHead;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

}
