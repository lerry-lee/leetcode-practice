package DailyExercises._20年10月;

import DataStructure.ListNode;

/**
 * Created by lerry_li on 2020/10/10
 */

/**
 * 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class _142环形链表2 {
    /**
     * 解法1：哈希表
     * 解法2：快慢指针：相遇后，快指针指向头结点，继续遍历再相遇即为入环节点
     */

    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) break;
        }
        if(fast.next==null||fast.next.next==null) return null;
        fast=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
