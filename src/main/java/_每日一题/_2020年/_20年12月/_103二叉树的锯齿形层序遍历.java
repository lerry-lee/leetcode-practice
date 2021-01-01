package _每日一题._2020年._20年12月;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _103二叉树的锯齿形层序遍历
 * @Author: lerry_li
 * @CreateDate: 2020/12/23
 * @Description
 */
public class _103二叉树的锯齿形层序遍历 {
    /**
     * 层次遍历改
     * 解法1：递归（对应层添加）
     * 解法2：迭代（双端队列）
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        List<Integer> curr = res.get(level);
        if (level % 2 == 0) {
            curr.add(root.val);
        } else {
            curr.add(0, root.val);
        }
        dfs(res, root.left, level + 1);
        dfs(res, root.right, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            res.add(new ArrayList<>());
            List<Integer> curr = res.get(level);
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (level % 2 == 0) {
                    curr.add(node.val);
                } else {
                    curr.add(0, node.val);
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
