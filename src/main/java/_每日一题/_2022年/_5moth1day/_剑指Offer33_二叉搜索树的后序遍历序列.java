package _每日一题._2022年._5moth1day;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _剑指Offer33_二叉搜索树的后序遍历序列 {
    /**
     * 解法1：递归
     */
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder == null || postorder.length <= 1) return true;
            return dfs(postorder,0,postorder.length-1);
        }

        public boolean dfs(int[] postorder, int start, int end) {
            if (start >= end) return true;
            int rootVal = postorder[end];
            int i = start;
            for (; i < end; i++) {
                if (postorder[i] > rootVal) {
                    break;
                }
            }
            for (int j = i; j < end; j++) {
                if (postorder[j] < rootVal) {
                    return false;
                }
            }
            return dfs(postorder, start, i - 1) && dfs(postorder, i, end - 1);
        }
    }
}
