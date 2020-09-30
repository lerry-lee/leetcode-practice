package _腾讯推荐._链表;

import _数据结构.ListNode;

/**
 * Created by lerry_li on 2020/09/30
 */

/**
 * 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class _合并K个升序链表 {
    /**
     * 解法1：分治法
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int l,int r){
        if(l==r) return lists[l];
        if(l>r) return null;
        int mid=l+(r-l)/2;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
