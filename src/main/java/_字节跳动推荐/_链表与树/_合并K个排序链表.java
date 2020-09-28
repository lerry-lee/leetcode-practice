package _字节跳动推荐._链表与树;

import _数据结构.ListNode;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/17 20:20
 * @description 合并K个排序链表
 */
public class _合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1) return null;
        int i=0,j=lists.length-1;
        return merge_helper(lists,i,j);
    }
    public ListNode merge_helper(ListNode[] lists,int l,int r){
        if(l==r) return lists[l];
        int mid=(l+r)/2;
        ListNode l1=merge_helper(lists,l,mid);
        ListNode l2=merge_helper(lists,mid+1,r);
        return mergeTwo(l1,l2);
    }
    public ListNode mergeTwo(ListNode node1, ListNode node2){
        if(node1==null) return node2;
        if(node2==null) return node1;
        if(node1.val<node2.val){
            node1.next= mergeTwo(node1.next,node2);
            return node1;
        }
        else{
            node2.next= mergeTwo(node1,node2.next);
            return node2;
        }
    }

}
