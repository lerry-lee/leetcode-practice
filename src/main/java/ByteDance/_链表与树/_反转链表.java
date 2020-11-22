package ByteDance._链表与树;

import DataStructure.ListNode;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/15 18:52
 * @description 206.反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class _反转链表 {
    /**
     * 解法1：迭代
     */
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;//遍历过程中，负责将旧链表的节点链接到新链表的头上
        ListNode root = null;//遍历过程中，负责记录新链表头
        while (head != null) {
            temp = new ListNode(head.val);//相当于取出当前节点
            temp.next = root;//将当前节点链接到新链表上，作为头节点
            root = temp;//头节点更新
            head = head.next;//旧链表向后遍历
        }
        return root;//返回新链表的头节点
    }

    /**
     * 解法2：递归
     */
    public ListNode reverseList_递归(ListNode head) {
        if (head.next == null || head == null) return head;
        ListNode node = reverseList(head.next);
        //假设其余节点都反转完了，剩下当前节点和当前子节点，然后反转这俩；啥意思？
        head.next.next = head;
        head.next = null;
        return node;
    }
}
