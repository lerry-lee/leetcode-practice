package _字节推荐._链表与树;

import _数据结构.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/22 10:14
 * @description 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 1.我的思路：从末尾向前找（相当于反转），找到第一个不相同的节点，它的前一个节点就是第一个相同的节点
 * 2.浪漫题解：两个链表a，b，构造ab和ba，这样两个新链表长度相同了，若末尾存在共同的节点，那同时遍历时必然会相遇（使用双指针模拟ab和ba）
 * 太浪漫了
 * 3.哈希表
 */
public class _相交链表 {

    //浪漫：O(m+n),O(1)
    //这里注意一点：如果A和B不相交，while会不会无限循环？
    //答案是不会，因为ab和ba遍历到末尾后，如果没有相交的部分，那最后双指针一定都是null，而null==null是要跳出循环的
    public ListNode getIntersectionNode_romantic(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            if (pA == null) pA = headB;
            else pA = pA.next;
            if (pB == null) pB = headA;
            else pB = pB.next;
        }
        return pA;
    }

    //存储反转的链表节点，然后顺序遍历即可？
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<String> headA_strs = new ArrayList<>();
        List<String> headB_strs = new ArrayList<>();
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            headA_strs.add(0, tempA.toString());
            tempA = tempA.next;
        }
        while (tempB != null) {
            headB_strs.add(0, tempB.toString());
            tempB = tempB.next;
        }
        int i = 0;
        while (i < headA_strs.size() && i < headB_strs.size()) {
            if (!headA_strs.get(i).equals(headB_strs.get(i))) break;
            i++;
        }
//        System.out.println("i:"+i);
        int cnt = 0;
        int stop = headA_strs.size() - i;
        while (headA != null && cnt < stop) {
            headA = headA.next;
            cnt++;
        }
        return headA;
    }
}
