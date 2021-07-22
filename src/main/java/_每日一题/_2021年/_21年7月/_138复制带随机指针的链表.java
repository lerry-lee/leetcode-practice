package _每日一题._2021年._21年7月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _138复制带随机指针的链表
 * @Author: lerry_li
 * @CreateDate: 2021/07/22
 * @Description
 * 遍历+哈希表
 */
public class _138复制带随机指针的链表 {
    /**
     * 遍历+哈希表 时间O(N) 空间O(N)
     */
    public Node copyRandomList(Node head) {
        //特判
        if (head == null) return null;
        Node dummy = new Node(0);
        Node cur=dummy;
        Map<Node, Node> hashMap = new HashMap<>();
        Node p = head;
        while (p != null) {
            cur.next = new Node(p.val);
            cur = cur.next;
            hashMap.put(p, cur);
            p = p.next;
        }
        p=head;
        cur=dummy.next;
        while(p!=null){
            cur.random=hashMap.get(p.random);
            p=p.next;
            cur=cur.next;
        }
        return dummy.next;
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
