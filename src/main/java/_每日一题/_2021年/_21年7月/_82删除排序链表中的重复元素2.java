package _每日一题._2021年._21年7月;

import _数据结构.ListNode;

/**
 * @ClassName: _82删除排序链表中的重复元素2
 * @Author: lerry_li
 * @CreateDate: 2021/07/24
 * @Description
 */
public class _82删除排序链表中的重复元素2 {
    /**
     * 解法1：指针 时间O(N) 空间O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        //特判
        if (head == null || head.next == null) return head;
        //虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //遍历指针
        ListNode prev = dummy, cur = dummy.next;
        while (cur != null) {
            //跳过相同的节点
            while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
            //while结束：
            //此时cur和cur.next不同，或者cur为最后一个节点
            //如果prev的next节点就是cur节点，那么说明cur节点未重复
            if (cur == prev.next) prev = prev.next;
                //否则，说明该节点至少为2个，需要跳过所有的这些节点
            else {
                prev.next = cur.next;
            }
            cur = cur.next;

        }
        //最后将prev.next指向null
        prev.next = null;
        return dummy.next;
    }
}
