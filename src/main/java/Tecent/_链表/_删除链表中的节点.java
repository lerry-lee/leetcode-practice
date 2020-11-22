package Tecent._链表;

import DataStructure.ListNode;

/**
 * Created by lerry_li on 2020/10/10
 */

/**
 * 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2：
 * <p>
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 */
public class _删除链表中的节点 {
    /**
     * 解法1：下一个节点的值往前赋值 时间复杂度O(n) 空间O(1)
     */
    public void deleteNode(ListNode node) {
        ListNode pre = node, cnt = node.next;
        while (cnt.next != null) {
            pre.val = cnt.val;
            cnt = cnt.next;
            pre = pre.next;
        }
        pre.val = cnt.val;
        pre.next = null;
    }

    /**
     * 解法2：与下一个节点交换 时间O(1) 空间O(1)
     */
    public void deleteNode_(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
