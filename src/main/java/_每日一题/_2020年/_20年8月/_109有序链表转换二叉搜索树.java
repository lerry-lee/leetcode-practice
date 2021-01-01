package _每日一题._2020年._20年8月;


import _数据结构.ListNode;
import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/08/18 09:36
 * @description 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class _109有序链表转换二叉搜索树 {
    /**
     * 解法：递归插入新节点，节点值为有序序列中点
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] nodes = listToArray(list);
        // display(nodes);
        TreeNode root = new TreeNode(nodes[nodes.length / 2]);
        insertToTree(root, nodes, 0, nodes.length - 1, nodes.length / 2);
        return root;
    }

    public void insertToTree(TreeNode root, int[] nodes, int start, int end, int mid) {
        if (start > end) {
            root = null;
            return;
        }
        // root=new TreeNode(nodes[mid]);
        // root.val=nodes[mid];
        // System.out.print(root.val+" ");
        if (mid > start) {
            int l_mid = (mid - 1 + start) / 2;
            root.left = new TreeNode(nodes[l_mid]);
            insertToTree(root.left, nodes, start, mid - 1, l_mid);
        }
        if (end > mid) {
            int r_mid = (end + mid + 1) / 2;
            root.right = new TreeNode(nodes[r_mid]);
            insertToTree(root.right, nodes, mid + 1, end, r_mid);
        }
    }

    public int[] listToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void display(int[] res) {
        for (int n : res) System.out.print(n + " ");
        System.out.println();
    }
}
