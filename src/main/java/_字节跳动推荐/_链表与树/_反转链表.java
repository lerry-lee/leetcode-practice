package _字节跳动推荐._链表与树;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/15 18:52
 * @description 206.反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * TODO:递归
 */
public class _反转链表 {
    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode temp=null;
        ListNode root=null;
        while(head!=null){
            root=new ListNode(head.val);
            root.next=temp;
            temp=root;
            head=head.next;
        }
        return root;
    }
    //递归???
    public ListNode reverseList_递归(ListNode head) {
        if(head.next==null||head==null) return head;
        ListNode node=reverseList(head.next);
        //假设其余节点都反转完了，剩下当前节点和当前子节点，然后反转这俩；啥意思？
        head.next.next=head;
        head.next=null;
        return node;
    }
}
