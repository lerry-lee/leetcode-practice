package _剑指Offer;

import _数据结构.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _52两个链表的第一个公共节点
 * @Signature: Created by lerry_li on 2020/11/05
 * @Description: 输入两个链表，找出它们的第一个公共节点
 */
public class _52两个链表的第一个公共节点 {
    /**
     * 解法1：哈希表 时间O(M+N) 空间O(max(M,N))
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        while (headA != null) {
            nodeSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (nodeSet.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 解法2：浪漫法 时间O(M+N) 空间O(1)
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
            if (nodeA == null && nodeB == null) {
                return null;
            }
            if (nodeA == null) {
                nodeA = headB;
            }
            if (nodeB == null) {
                nodeB = headA;
            }
        }
        return nodeA;
    }
}
