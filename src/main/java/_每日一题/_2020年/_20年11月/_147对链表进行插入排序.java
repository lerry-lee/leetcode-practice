package _每日一题._2020年._20年11月;

import _数据结构.ListNode;

/**
 * @ClassName: _147对链表进行插入排序
 * @Signature: Created by lerry_li on 2020/11/20
 * @Description:
 */
public class _147对链表进行插入排序 {
    /**
     * 解法1：暴力解法 时间O(N^2) 空间O(1)
     */
    public ListNode insertionSortList(ListNode head) {
        //特判
        if (head == null || head.next == null) {
            return head;
        }
        //设置新头结点，链接到head上，方便对head进行操作
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        //设置排好序的尾节点指针，开始时指向head第一个节点
        ListNode tail = newHead.next;
        //方便节点的插入删除操作，设置pre节点和cur节点，pre.next=cur，cur遍历未排序的链表部分
        ListNode pre = newHead.next;
        ListNode cur = pre.next;
        //cur遍历到链表尾时停止
        while (cur != null) {
            //若排好序的链表的尾节点tail的值已经比cur的值小了，那么更新tail=tail.next即可，不用摘出来再插入排序了
            if (tail.val < cur.val) {
                tail = tail.next;
            } else {

                //从链表中删除cur节点
                pre.next = cur.next;
                cur.next = null;

                //插入排序部分
                //设置tempPre和temp用来遍历排好序的链表部分，tempPre.next=temp，temp遍历排好序的链表部分
                ListNode tempPre = newHead;
                ListNode temp = newHead.next;
                //最远temp遍历到链表末尾
                while (temp != null) {
                    //若当前摘出来的节点cur的值小于排好序的链表部分的temp节点的值
                    //将cur插入到temp前面，退出while循环，此时tail节点不用更新，因为cur只是插入到排好序的链表部分的中间了
                    if (cur.val <= temp.val) {
                        cur.next = temp;
                        tempPre.next = cur;
                        break;
                    } else {
                        //若当前摘出来的节点cur的值大于排好序的链表部分的temp节点的值
                        //tempPre和temp继续往后遍历排好序的链表部分
                        tempPre = tempPre.next;
                        temp = temp.next;
                    }
                    //若tempPre遍历到排好序的链表部分的尾节点tail，即temp和cur摘出来之前一样的位置了
                    //那么直接将cur插入到排好序的链表部分的尾部即可
                    if (tempPre == tail) {
                        cur.next = temp;
                        tempPre.next = cur;
                        //这时排好序的链表部分的tail节点往后移动一位
                        tail = tail.next;
                        break;
                    }
                }
            }
            //每次插入排序后，cur指向排好序的链表部分的尾节点的next节点，pre指向尾节点tail
            pre = tail;
            cur = tail.next;
        }
        return newHead.next;
    }

    /**
     * 解法2：官方题解代码优化版
     */
    public ListNode insertionSortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;

    }


}
