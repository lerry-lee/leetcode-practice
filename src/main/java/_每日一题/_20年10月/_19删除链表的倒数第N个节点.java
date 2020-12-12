package _每日一题._20年10月;

import _数据结构.ListNode;


import java.util.Stack;

/**
 * Created by lerry_li on 2020/10/18
 */

/**
 * . 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class _19删除链表的倒数第N个节点 {
    /**
     * 解法1：先遍历出链表长度 时间O(n) 空间O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        int totalNodes = 0;
        ListNode node = head;
        while (node != null) {
            totalNodes++;
            node = node.next;
        }
        if (n == totalNodes) return head.next;
        node = head;
        for (int i = 1; i < totalNodes - n; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }

    /**
     * 解法2：用栈 时间O(n) 空间O(n)
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int i = 0;
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (i == n) break;
            i++;
        }
        node.next = node.next.next;
        return dummy.next;
    }

    /**
     * 解法3：双指针 时间O(n) 空间O(1)
     * 由于我们需要找到倒数第 n 个节点，因此我们可以使用两个指针同时对链表进行遍历，
     * 并且 first 比 second 超前 n 个节点。当 first 遍历到链表的末尾时，
     * second 就恰好处于倒数第 n 个节点。
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
