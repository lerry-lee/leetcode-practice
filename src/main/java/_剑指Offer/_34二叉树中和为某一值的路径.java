package _剑指Offer;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _34二叉树中和为某一值的路径
 * @Author: lerry_li
 * @CreateDate: 2021/04/14
 * @Description
 * 解法1：回溯
 */
public class _34二叉树中和为某一值的路径 {
    /**
     *  解法1：回溯 时间O(N) 空间O(N)
     */
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, target, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(TreeNode root, int target, ArrayList<Integer> cur, int curSum) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        curSum += root.val;
        //到达叶节点
        if (root.left == null && root.right == null) {
            if (curSum == target) {
                res.add(new ArrayList<>(cur));
            }
            cur.remove(cur.size() - 1);
            return;
        }
        //左
        dfs(root.left, target, cur, curSum);
        //右
        dfs(root.right, target, cur, curSum);
        cur.remove(cur.size() - 1);
    }
}
