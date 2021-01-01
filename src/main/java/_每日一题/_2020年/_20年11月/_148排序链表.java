package _每日一题._2020年._20年11月;

import _数据结构.ListNode;

/**
 * @ClassName: _148排序链表
 * @Signature: Created by lerry_li on 2020/11/21
 * @Description:
 */
public class _148排序链表 {
    /**
     * 解法1：递归分治+归并排序(超时了...)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head, tail = head.next;
        while (tail != null && tail.next != null) {
            temp = head.next;
            tail = tail.next.next;
        }
        ListNode l2 = temp.next;
        temp.next = null;
        return mergeSort(sortList(head), sortList(l2));
    }

    public ListNode mergeSort(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeSort(l1.next, l2);
            return l1;
        }
        l2.next = mergeSort(l1, l2.next);
        return l2;
    }

    /**
     * 解法2：借助数组排序：时间O(N*logN) 空间O(N)
     * 解法3：自底向上的归并排序，不能使用递归，因为要求O(1)空间复杂度
     */
    public ListNode sortList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //计算链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        //设置一个虚拟的头结点，next指向head
        ListNode dummyHead = new ListNode(0, head);
        //从有序链表只有1个节点开始归并排序，直到有序链表的长度subLength大于等于原链表的长度length
        for (int subLength = 1; subLength < length; subLength *= 2) {
            //prev表示前驱节点，curr表示当前节点
            ListNode prev = dummyHead, curr = dummyHead.next;
            //遍历链表，找到若干个subLength长度的子链表
            while (curr != null) {
                //每次找两个，然后merge排序
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                //断开之前保存下一个节点
                ListNode head2 = curr.next;
                //两个子链表之间断开
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                //断开之前保存下一个节点
                ListNode curNext = null;
                if (curr != null) {
                    curNext = curr.next;
                    curr.next = null;
                }
                //前驱结点指向排好序的链表头，串起来若干个有序链表
                prev.next = mergeTwoSortedLists(head1, head2);
                //前驱结点移到已经有序链表的末尾
                while (prev.next != null) {
                    prev = prev.next;
                }
                //当前节点后移一位，继续找俩子链表
                curr = curNext;
            }
        }
        return dummyHead.next;

    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }


}
