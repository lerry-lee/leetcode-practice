package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/05
 * @Description
 */
public class _剑指Offer33_二叉搜索树的后序遍历序列 {
    /**
     * 解法1：递归
     */
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder == null || postorder.length <= 1) return true;
            return dfs(postorder, 0, postorder.length - 1);
        }

        private boolean dfs(int[] postorder, int start, int rootIdx) {
            if (start>=rootIdx) return true;
            int i = rootIdx - 1;
            for (; i >= start; i--) {
                if (postorder[i] < postorder[rootIdx]) break;
            }
            for (int j = start; j < i; j++) {
                if (postorder[j] > postorder[rootIdx]) return false;
            }
            return dfs(postorder, i + 1, rootIdx - 1) && dfs(postorder, start, i);
        }
    }
}
