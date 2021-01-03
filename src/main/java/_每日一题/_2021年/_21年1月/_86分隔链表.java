package _每日一题._2021年._21年1月;

import _工具类.CommonMethod;
import _数据结构.ListNode;

import java.util.Arrays;

/**
 * @ClassName: _86分隔链表
 * @Author: lerry_li
 * @CreateTime: 2021/01/03
 * @Description
 */
public class _86分隔链表 {
    /**
     * 解法1：遍历链表，设置两个子链表，取出每个节点，放到对应的子链表后，然后合并子链表
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node_small = new ListNode(-1), node_big = new ListNode(-1);
        ListNode newHead1=node_small,newHead2=node_big;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = null;
            if (curr.val < x) {
                node_small.next = curr;
                node_small = node_small.next;

            } else {
                node_big.next = curr;
                node_big = node_big.next;
            }
            curr = temp;
        }
        node_small.next=newHead2.next;
        return newHead1.next;
    }

    public static void main(String[] args) {
        _86分隔链表 instance = new _86分隔链表();
        ListNode head = CommonMethod.initListNode(Arrays.asList(1, 4, 3, 2, 5, 2));
        ListNode res = instance.partition(head, 3);
        CommonMethod.display(res);
    }
}
