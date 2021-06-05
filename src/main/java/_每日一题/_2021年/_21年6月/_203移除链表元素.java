package _每日一题._2021年._21年6月;

import _数据结构.ListNode;

/**
 * @ClassName: _203移除链表元素
 * @Author: lerry_li
 * @CreateDate: 2021/06/05
 * @Description
 */
public class _203移除链表元素 {
    /**
     * 解法1：朴素 时间O(N) 空间O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        //特判
        if(head==null) return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy,cur=head;
        while(cur!=null){
            if(cur.val==val){
                ListNode curNext=cur.next;
                cur.next=null;
                prev.next=curNext;
                cur=curNext;
            }else{
                cur=cur.next;
                prev=prev.next;
            }
        }
        return dummy.next;
    }
}
