package _剑指Offer;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _32_3_从上到下打印二叉树3
 * @Author: lerry_li
 * @CreateDate: 2021/01/04
 * @Description
 */
public class _32_3_从上到下打印二叉树3 {
    /**
     * 解法1：迭代（使用双端队列）
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            res.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (level % 2 == 0) {
                    res.get(level).add(node.val);
                } else {
                    res.get(level).add(0, node.val);
                }
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
                if (node.right != null) {
                    deque.offerLast(node.right);
                }
            }
            level++;
        }
        return res;
    }
}
