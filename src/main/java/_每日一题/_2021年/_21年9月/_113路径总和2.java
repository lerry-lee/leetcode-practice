package _每日一题._2021年._21年9月;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/10
 */
public class _113路径总和2 {
    /**
     * 解法1：dfs
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //特判
        if (root == null) return new ArrayList<>();
        //dfs
        dfs(root, new ArrayList<>(), targetSum);
        return res;
    }

    private void dfs(TreeNode root, ArrayList<Integer> path, int targetSum) {
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if (root.left != null) dfs(root.left, path, targetSum);
        if (root.right != null) dfs(root.right, path, targetSum);
        path.remove(path.size() - 1);
    }

    List<List<Integer>> res = new ArrayList<>();
}
