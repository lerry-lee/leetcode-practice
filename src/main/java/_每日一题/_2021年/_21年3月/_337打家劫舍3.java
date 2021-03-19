package _每日一题._2021年._21年3月;

import _数据结构.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _337打家劫舍3
 * @Author: lerry_li
 * @CreateTime: 2021/03/19
 * @Description
 */
public class _337打家劫舍3 {
    Map<TreeNode, Integer> memo;

    /**
     * 解法1：带备忘录的递归
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        memo = new HashMap<>();
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //是否已经计算过
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        //选择当前节点和孙子节点
        int sum1 = root.val;
        if (root.left != null) {
            sum1 += dfs(root.left.left) + dfs(root.left.right);
        }
        if (root.right != null) {
            sum1 += dfs(root.right.left) + dfs(root.right.right);
        }
        //选择当前节点的子节点
        int sum2 = dfs(root.left) + dfs(root.right);
        int maxSum = Math.max(sum1, sum2);
        memo.put(root, maxSum);
        return maxSum;
    }
}
