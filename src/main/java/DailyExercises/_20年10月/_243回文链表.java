package DailyExercises._20年10月;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lerry_li on 2020/10/23
 */
public class _243回文链表 {
    /**
     * 解法1：线性表 时间O(n) 空间O(n)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        List<Integer> nodeList = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            nodeList.add(temp.val);
            temp = temp.next;
        }
        for (int i = nodeList.size() - 1; i >= 0; i--) {
            if (nodeList.get(i) != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 解法2：递归 时间O(n) 空间O(n)
     * 用一个全局变量记录左边的节点，递归从链表最后一个节点开始，两两比较
     */
    public boolean isPalindrome2(ListNode head) {
        left = head;
        return check(head);
    }

    ListNode left;

    public boolean check(ListNode right) {
        if (right != null) {
            if (!check(right.next)) {
                return false;
            }
            if (right.val == left.val) {
                left = left.next;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 解法3：双指针 时间O(n) 空间O(1)
     * 找到链表中间节点，反转后半部分，然后比较
     */
    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        ListNode pre = null, newHead = null;
        while (right != null) {
            newHead = new ListNode(right.val);
            newHead.next = pre;
            pre = newHead;
            right = right.next;
        }
        while (newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}
