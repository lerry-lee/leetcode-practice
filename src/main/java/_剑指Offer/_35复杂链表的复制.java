package _剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _35复杂链表的复制
 * @Author: lerry_li
 * @CreateDate: 2021/03/03
 * @Description
 */
public class _35复杂链表的复制 {
    /**
     * 解法1：哈希表 时间O(N) 空间O(N)
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        Map<Node, Node> hashMap = new HashMap<>();
        //1.复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while (temp != null) {
            hashMap.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        //2.构建新链表的next和random指向
        temp = head;
        while (temp != null) {
            hashMap.get(temp).next = hashMap.get(temp.next);
            hashMap.get(temp).random = hashMap.get(temp.random);
            temp = temp.next;
        }
        //3.返回新链表的头结点
        return hashMap.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
