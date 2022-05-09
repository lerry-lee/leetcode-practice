package _每日一题._2022年._5月;

import _数据结构.TreeNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 * @Description
 */
public class _108_将有序数组转换为二叉搜索树 {
    /**
     * 解法1：递归 时间O(N) 空间O(logN) 递归栈的深度
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            //特判
            if (nums == null || nums.length == 0) return null;
            //递归构建
            return dfs(nums, 0, nums.length - 1);
        }

        private TreeNode dfs(int[] nums, int l, int r) {
            //递归出口
            if (l > r) return null;
            if (l == r) return new TreeNode(nums[l]);
            //取中间下标所在的元素，作为根节点元素，可保证左右子树的节点数量之差<1
            int mid = l + (r - l) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = dfs(nums, l, mid - 1);
            root.right = dfs(nums, mid + 1, r);
            return root;
        }
    }
}
