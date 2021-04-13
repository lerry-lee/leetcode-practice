package _剑指Offer;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _32_1_从上到下打印二叉树
 * @Author: lerry_li
 * @CreateDate: 2021/04/13
 * @Description
 * 解法1：dfs
 * 解法2：bfs
 */
public class _32_1_从上到下打印二叉树 {
    /**
     * 解法1：dfs 时间O(N) 空间O(N)
     */
    static List<List<Integer>> nums;
    static int size;

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        nums = new ArrayList<>();
        size = 0;
        dfs(root, 0);
        int[] res = new int[size];
        int i = 0;
        while (i < size) {
            for (List<Integer> numsi : nums) {
                for (int num : numsi) {
                    res[i++] = num;
                }
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (nums.size() <= level) {
            nums.add(new ArrayList<>());
        }
        nums.get(level).add(root.val);
        size++;
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    /**
     * 解法2：bfs 时间O(N) 空间O(N)
     */
    public int[] levelOrder2(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> nums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                nums.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
        }
        int[] res = new int[nums.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums.get(i);
        }
        return res;
    }
}
