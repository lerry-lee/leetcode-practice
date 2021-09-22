package _每日一题._2021年._21年9月;

import _数据结构.ListNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/22
 */
public class _725分隔链表 {
    /**
     * 解法1：模拟 时间O(N) 空间O(1)
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        if (head == null) {
            return res;
        }
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        cur = head;
        if (n <= k) {
            for (int i = 0; i < n; i++) {
                ListNode temp = cur.next;
                res[i] = cur;
                cur.next = null;
                cur = temp;
            }
        } else {
            int num = n / k;
            int mod = n % k;
            for (int i = 0; i < k; i++) {
                res[i] = cur;
                if (i < mod) {
                    for (int j = 0; j < num; j++) {
                        cur = cur.next;
                    }
                } else {
                    for (int j = 0; j < num - 1; j++) {
                        cur = cur.next;
                    }
                }
                ListNode temp = cur.next;
                cur.next = null;
                cur = temp;
            }
        }
        return res;
    }
}
