package _数据结构;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/08/18 10:01
 * @description 链表
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
