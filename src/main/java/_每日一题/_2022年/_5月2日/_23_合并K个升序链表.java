package _每日一题._2022年._5月2日;

import _数据结构.ListNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _23_合并K个升序链表 {
    /**
     * 解法1：归并排序
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            int l = 0, r = lists.length - 1;
            return merge(lists,l,r);
        }

        private ListNode merge(ListNode[] lists, int l, int r) {
            if(l>r) return null;
            if(l==r) return lists[l];
            int mid=l+(r-l)/2;
            ListNode l1=merge(lists,l,mid);
            ListNode l2=merge(lists,mid+1,r);
            return merge2Lists(l1,l2);
        }

        private ListNode merge2Lists(ListNode l1, ListNode l2) {
            if(l1==null) return l2;
            if(l2==null) return l1;
            if(l1.val<l2.val){
                l1.next=merge2Lists(l1.next,l2);
                return l1;
            }
            l2.next=merge2Lists(l2.next,l1);
            return l2;
        }
    }
}
