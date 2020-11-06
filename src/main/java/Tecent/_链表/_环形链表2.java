package Tecent._链表;

import DataStructure.ListNode;

/**
 * Created by lerry_li on 2020/10/08
 */

/**
 * 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 */
public class _环形链表2 {
    /**
     * 解法1：哈希表法
     * 解法2：双指针法
         * 设链表共有 a+b 个节点，其中 链表头部到链表入口 有 a个节点（不计链表入口节点）， 链表环 有 b个节点；
         * 设两指针分别走了 f，s 步，则有：
         * fast 走的步数是slow步数的 2 倍，即 f = 2s ；
         * fast 比 slow多走了 n 个环的长度，即 f = s + nb ；（ 解析： 双指针都走过 a 步，然后在环内绕圈直到重合，重合时 fast 比 slow 多走环的长度整数倍 ）；
         * 以上两式相减得：f = 2nb，s = nb，即fast和slow 指针分别走了 2n，n 个 环的周长 （注意： n 是未知数，不同链表的情况不同）。
         * 如果让指针从链表头部一直向前走并统计步数k，那么所有 走到链表入口节点时的步数 是：k=a+nb（先走 a 步到入口节点，之后每绕 1 圈环（ b 步）都会再次到入口节点）。
         * 而目前，slow 指针走过的步数为 nb 步。因此，我们只要想办法让 slow 再走 a 步停下来，就可以到环的入口。
         * 因此，slow再走a，fast指向head再走a，两指针将在环形链表入口节点相遇
     */
    public ListNode detectCycle(ListNode head) {
        /**
         * 1.走a+nb步一定是在环入口
         * 2.第一次相遇时慢指针已经走了nb步
         */
        if (head == null||head.next==null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast=head;
                break;
            }
        }
        if(fast==head){
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }
}
