package _剑指Offer;

import _数据结构.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _06从尾到头打印链表
 * @Author: lerry_li
 * @CreateDate: 2021/04/02
 * @Description
 */
public class _06从尾到头打印链表 {
    /**
     * 解法1：递归
     */
    public int[] reversePrint(ListNode head) {
        nodes = new ArrayList<>();
        dfs(head);
        int[] res = new int[nodes.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = nodes.get(i);
        }
        return res;
    }

    List<Integer> nodes;

    public void dfs(ListNode head) {
        if (head == null) {
            return;
        }
        dfs(head.next);
        nodes.add(head.val);
    }
}
