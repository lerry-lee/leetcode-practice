package ByteDance._链表与树;

import DataStructure.ListNode;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/16 08:16
 * @description 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class _排序链表 {
    /**
     * 二路归并排序，还不能用递归
     * @param head
     * @return
     */
    //递归版
    public ListNode sortList_(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode right=slow.next;
        slow.next=null;
        ListNode L=sortList_(head);
        ListNode R=sortList_(right);
        return merge_(L,R);
    }
    public ListNode merge_(ListNode n1,ListNode n2){
        if(n1==null) return n2;
        if(n2==null) return n1;
        if(n1.val<n2.val) {
            n1.next = merge_(n1.next, n2);
            return n1;
        }
        else {
            n2.next = merge_(n1, n2.next);
            return n2;
        }
    }
    //迭代版
    public ListNode sortList(ListNode head) {
        // 确定链表长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 每次结合的元素翻倍实现由零到整的过程
        for (int m = 1; m < len; m *= 2) {
            ListNode pre = dummy;
            cur = pre.next;
            // 每次取出两部分归并排序后合并成一个部分
            while (cur != null) {
                // 定义 first 指针指向第一部分
                ListNode first = cur;
                for (int i = 0; i < m - 1 && cur != null; i++) {
                    cur = cur.next;
                }
                if (cur == null) {
                    break;
                }
                // 定义 second 指针指向第二部分
                ListNode second = cur.next;
                // 将第一部分和第二部分断开
                cur.next = null;
                cur = second;
                for (int i = 0; i < m - 1 && cur != null; i++) {
                    cur = cur.next;
                }
                ListNode remain = null;
                // 将第二部分与第三部分断开
                if (cur != null) {
                    remain = cur.next;
                    cur.next = null;
                }
                cur = remain;
                // 准备开始归并排序,并用 tmp 指向归并后的头结点
                ListNode tmp = merge(first, second);
                pre.next = tmp;
                // pre 结点遍历到归并链表的末尾
                while (pre.next != null) {
                    pre = pre.next;
                }
                // 接上剩下未排序的元素
                pre.next = remain;
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (a != null && b != null ) {
            if (a.val < b.val) {
                cur.next = a;
                cur = cur.next;
                a = a.next;
            } else {
                cur.next = b;
                cur = cur.next;
                b = b.next;
            }
        }
        if (a != null) {
            cur.next = a;
        }
        if (b != null) {
            cur.next = b;
        }
        return pre.next;
    }

}
