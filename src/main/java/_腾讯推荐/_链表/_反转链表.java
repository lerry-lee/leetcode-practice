package _腾讯推荐._链表;

import _数据结构.ListNode;


/**
 * Created by lerry_li on 2020/09/27
 */
public class _反转链表 {
    /**
     * 解法1：递归
     * 可以参考图解
     * 递归到最后一个节点，直接返回该节点
     * 然后，反转倒数第二个节点和最后一个节点，返回反转后的头结点
     * 依次类推
     */
    public ListNode reverseList(ListNode head) {
        //只剩一个节点或节点为空，返回该节点或空节点
        if (head == null || head.next == null) return head;
        //反转当前节点的next节点，得到反转后的头结点
        ListNode newHead = reverseList(head.next);
        //当前节点的next节点已经反转完了，剩下的工作为：
        //反转当前节点和next节点
        ListNode headNext = head.next;
        headNext.next = head;
        head.next = null;
        //返回新的头结点
        return newHead;
    }

    /**
     * 解法2：迭代
     * 一个newHead节点指向新的头结点，一个current节点遍历head链表，每次对应当前的节点
     * 具体可看图解
     */
    public ListNode reverseList_(ListNode head) {
        ListNode newHead=null,current;
        while(head!=null){
            current=new ListNode(head.val);
            current.next=newHead;
            newHead=current;
            head=head.next;
        }
        return newHead;
    }

}
