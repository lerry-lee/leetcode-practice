package _每日一题._2021年._21年3月;

import _数据结构.ListNode;

/**
 * @ClassName: _92反转链表2
 * @Author: lerry_li
 * @CreateTime: 2021/03/18
 * @Description 给你单链表的头指针 head 和两个整数left 和 right ，
 * 其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class _92反转链表2 {
    /**
     * 解法1：一次遍历 时间O(N) 空间O(1)
     * @param head 链表头结点
     * @param left 翻转开始位置，从1开始计数
     * @param right 翻转结束位置
     * @return 翻转后的链表
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        //设置一个虚拟头结点dummy，这样不用考虑left=1即从第1个节点就要开始的边界情况
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //思路是：
        //在遍历过程中，翻转[left,right]区间内的节点的next指针
        //最后，left左边的节点的next还是指向left，而right的next指向的节点会丢失
        //因此要记录left的前驱节点、right的后继节点
        ListNode prevLeft = null, curRight = null, nextRight = null;
        //计数，从0开始，从虚拟头结点dummy开始
        int cnt = 0;
        //找到left的前驱节点
        while (cnt < left) {
            prevLeft = dummy;
            dummy = dummy.next;
            cnt++;
        }
        //翻转[left,right]
        ListNode prev = null, cur = prevLeft.next;
        while (cnt <= right) {
            //翻转过程中遇到right要记录下right和right的后继结点
            if (cnt == right) {
                curRight = cur;
                nextRight = cur.next;
            }
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
            cnt++;
        }
        //连接，使得left的前驱节点-next指向right，left-next指向right的后继结点
        ListNode curLeft = prevLeft.next;
        prevLeft.next = curRight;
        curLeft.next = nextRight;
        //若left为1，表明从head开始反转，因此最终返回right位置的节点
        if (left == 1) {
            return curRight;
        }
        //否则返回头结点head即可
        return head;
    }
}
