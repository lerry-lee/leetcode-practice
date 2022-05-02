package _每日一题._2022年._5月2日;

import _数据结构.ListNode;
import _数据结构.TreeNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _109_有序链表转换二叉搜索树 {
    /**
     * 解法1：递归+双指针找中间节点（作为二叉树的根节点）
     */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return new TreeNode(head.val);
            ListNode fast = head, slow = head;
            ListNode prev = new ListNode(0, head);
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                prev = prev.next;
            }
            TreeNode root = new TreeNode(slow.val);
            ListNode right = slow.next;
            slow.next = null;
            prev.next = null;
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(right);
            return root;
        }
    }
}
