package _字节跳动推荐._链表与树;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/15 18:53
 * @description 链表节点数据结构
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(){

    }

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String str=super.toString();
        return str.substring(str.length()-8);
    }
}
