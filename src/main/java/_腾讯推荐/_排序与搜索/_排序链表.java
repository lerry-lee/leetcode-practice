package _腾讯推荐._排序与搜索;

import _数据结构.ListNode;

/**
 * Created by lerry_li on 2020/10/18
 */
public class _排序链表 {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode node2=sortList(head.next);
        return mergeSort(new ListNode(head.val),node2);
    }
//    public ListNode sort(ListNode node){
//        if(node.next==null) return node;
//        ListNode node2=sort(node.next);
//        return mergeSort(node,node2);
//    }
    public ListNode mergeSort(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=mergeSort(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeSort(l1,l2.next);
            return l2;
        }
    }
}
