package _剑指Offer;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _32_2_从上到下打印二叉树2
 * @Author: lerry_li
 * @CreateDate: 2021/04/13
 * @Description
 * 解法1：dfs
 * 解法2：bfs
 */
public class _32_2_从上到下打印二叉树2 {
    /**
     * 解法1：dfs 时间O(N) 空间O(N)
     */
    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    /**
     * 解法2：bfs 时间O(N) 空间O(N)
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                curLevel.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            res.add(curLevel);
        }
        return res;
    }

}
