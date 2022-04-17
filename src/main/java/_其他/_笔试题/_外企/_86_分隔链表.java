package _其他._笔试题._外企;

import _数据结构.ListNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/17
 * @Description
 */
public class _86_分隔链表 {
    /**
     * 解法1：一次遍历，prev+cur两个指针 时间O(N) 空间O(1)
     */
    public ListNode partition(ListNode head, int x) {
        //虚拟头节点
        ListNode dummy=new ListNode(0,head);
        ListNode prev=dummy,cur=head;
        //分隔节点前半部分的尾节点
        ListNode split_tail=null;
        //cur遍历链表
        while(cur!=null){
            //如果还没找到第一个比x大于等于的节点，那么先找
            if(split_tail==null){
                //如果找到了，标记该节点的前驱节点为前半部分尾节点
                if(cur.val>=x){
                    split_tail=prev;
                }
                //双指针后移
                prev=prev.next;
                cur=cur.next;
            }
            //否则，已经找到分隔位置了，接下来，把小于x的节点摘除拿到前半部分，追加到尾节点后面
            else{
                //小于x的节点需要摘除
                if(cur.val<x){
                    //prev的next指向cur的next，把cur单独摘出来
                    prev.next=prev.next.next;
                    cur.next=null;
                    //保存尾节点的next，防止丢失
                    ListNode temp=split_tail.next;
                    //尾节点next指向摘除的cur
                    split_tail.next=cur;
                    //cur的next指向原来尾节点的next，继续连上
                    cur.next=temp;
                    //尾节点后移，因为新加了一个节点
                    split_tail=split_tail.next;
                    //cur指针重新定位
                    cur=prev.next;
                }
                //大于等于的不用管
                else{
                    prev=prev.next;
                    cur=cur.next;
                }
            }
        }
        return dummy.next;
    }
}
