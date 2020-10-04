package _腾讯推荐._链表;

import _数据结构.ListNode;

/**
 * Created by lerry_li on 2020/10/04
 */
public class _环形链表 {
    /**
     * 解法1：哈希表
     * 解法2：双指针（若有环，则快的必追上慢的）
     */
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode low=head,fast=head.next;
        while(fast.next!=null&&fast.next.next!=null){
            if(low==fast) return true;
            fast=fast.next.next;
            low=low.next;
        }
        return false;

    }
}
