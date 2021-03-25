package _每日一题._2021年._21年3月;

import _工具类.CommonMethod;
import _数据结构.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _82删除排序链表中的重复元素2
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description
 */
public class _82删除排序链表中的重复元素2 {
    /**
     * 解法1：利用数组额外空间 时间O(N) 空间O(N)
     * 思路：
     *      由于要消除所有重复的元素，所以对于遍历的每一个元素，都向后搜索其重复的元素（若有→则跳过该元素，若无→则添加该元素）
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义一个存放节点值的数组
        List<Integer> nodeValues = new ArrayList<>();
        //遍历链表，填充数组
        ListNode cur = head;
        while (cur != null) {
            nodeValues.add(cur.val);
            cur = cur.next;
        }
        //定义一个虚拟头结点
        ListNode dummy = new ListNode(0);
        //temp指向dummy，用于遍历新链表
        ListNode temp = dummy;
        //从第0个元素开始，遍历节点值的数组
        int i = 0;
        while (i < nodeValues.size()) {
            //对于当前元素i，记录其值val
            int val = nodeValues.get(i);
            //向后遍历，找到第一个不同于当前值val的元素j
            int j = i + 1;
            for (; j < nodeValues.size() && nodeValues.get(j) == val; j++) {
            }
            //若j为i的后一个元素，则说明i元素无重复，可以添加到链表中
            if (j == i + 1) {
                temp.next = new ListNode(val);
                temp = temp.next;
            }
            //i指向j的位置（若i不重复，则相当于i+1；若i重复，则相当于i指向下一个不重复的元素）
            i = j;
        }
        //返回链表真实的头结点
        return dummy.next;
    }

    /**
     * 解法2：快慢指针 时间O(N) 空间O(1)
     * 思路：
     *      和解法1的思路一致，只不过使用指针直接在遍历链表的同时处理
     *      tips：最终需要指向null，因为有可能整个链表都是重复元素
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义一个虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            while (temp != null && temp.val == cur.val) {
                temp = temp.next;
            }
            if (temp == cur.next) {
                prev.next = cur;
                prev = prev.next;
            }
            cur = temp;
        }
        prev.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        _82删除排序链表中的重复元素2 instance = new _82删除排序链表中的重复元素2();
        ListNode head1 = CommonMethod.initListNode(Arrays.asList(1, 2, 3, 3, 4, 4, 5));
        ListNode head2 = CommonMethod.initListNode(Arrays.asList(1, 1, 1, 2, 3, 4, 5));
        CommonMethod.display(instance.deleteDuplicates2(head1));
        CommonMethod.display(instance.deleteDuplicates2(head2));
    }
}
