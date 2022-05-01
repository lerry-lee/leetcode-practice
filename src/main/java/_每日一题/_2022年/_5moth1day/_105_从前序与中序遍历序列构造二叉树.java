package _每日一题._2022年._5moth1day;

import _数据结构.TreeNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _105_从前序与中序遍历序列构造二叉树 {
    /**
     * 解法1：递归
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null) return null;
            return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd) return null;
            if (preStart == preEnd) return new TreeNode(preorder[preStart]);
            TreeNode root = new TreeNode(preorder[preStart]);
            int rootIdx = inStart;
            while (rootIdx <= inEnd) {
                if (inorder[rootIdx] == preorder[preStart]) break;
                rootIdx++;
            }
            int inLeftStart=inStart,inLeftEnd=rootIdx-1;
            int preLeftStart=preStart+1,preLeftEnd=preLeftStart+(inLeftEnd-inLeftStart);
            int inRightStart=rootIdx+1,inRightEnd=inEnd;
            int preRightStart=preLeftEnd+1,preRightEnd=preEnd;
            root.left=dfs(preorder,preLeftStart,preLeftEnd,inorder,inLeftStart,inLeftEnd);
            root.right=dfs(preorder,preRightStart,preRightEnd,inorder,inRightStart,inRightEnd);
            return root;
        }
    }
}
