package _每日一题._2021年._21年4月;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _783二叉搜索树节点最小距离
 * @Author: lerry_li
 * @CreateDate: 2021/04/13
 * @Description
 */
public class _783二叉搜索树节点最小距离 {
    /**
     * 解法1：中序遍历(递归)+额外数组 时间O(n) 空间O(N)
     * 思路：
     *      对于二叉搜索树，中序(根)遍历就是有序的
     */
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        nums = new ArrayList<>();
        dfs(root);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < nums.size(); i++) {
            minDiff = Math.min(minDiff, nums.get(i) - nums.get(i - 1));
        }
        System.out.println(nums);
        return minDiff;
    }

    static List<Integer> nums;

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        nums.add(root.val);
        dfs(root.right);
    }

    /**
     * 解法2：中序遍历(递归)+只保存前一个节点的值 时间O(N) 空间O(N) 表示递归栈的所用空间
     */
    public int minDiffInBST2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDiff = Integer.MAX_VALUE;
        prev = Integer.MAX_VALUE;
        dfs2(root);
        return minDiff;
    }

    private void dfs2(TreeNode root) {
        if (root == null) {
            return;
        }
        //左
        dfs2(root.left);
        //根
        if (prev != Integer.MAX_VALUE) {
            minDiff = Math.min(minDiff, root.val - prev);
        }
        prev = root.val;
        //右
        dfs2(root.right);
    }

    static int minDiff;
    static int prev;

    /**
     * 解法3：中序遍历(迭代)+只保存前一个节点的值 时间O(N) 空间O(N)
     */
    public int minDiffInBST3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDiff = Integer.MAX_VALUE;
        int prev = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            //左子节点不为空，则左子节点入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //弹出当前节点
            root = stack.pop();
            if (prev != Integer.MAX_VALUE) {
                minDiff = Math.min(minDiff, root.val - prev);
            }
            prev = root.val;
            System.out.print(root.val+" ");
            //搜索当前节点的右子节点
            root = root.right;
        }
        return minDiff;
    }
}
