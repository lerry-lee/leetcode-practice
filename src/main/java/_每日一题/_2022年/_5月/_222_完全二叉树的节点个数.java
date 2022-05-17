package _每日一题._2022年._5月;

import _数据结构.TreeNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/17
 */
public class _222_完全二叉树的节点个数 {
    /**
     * solution：Using the properties of a complete binary tree, recursive calculation Time O(logN) Space O(logN) stack overhead
     */
    class Solution {
        public int countNodes(TreeNode root) {
            // check empty
            if (root == null) return 0;
            // calculate the depth of the leftChildTree and rightChildTree
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            // 1. If the height of the left subtree and the right subtree are the same, the left subtree is a full binary tree
            // The total number of nodes in a full binary tree is equal to 2^(h)-1, h is depth
            // Add the root node, then recursively calculate the right subtree
            if (leftDepth == rightDepth) {
                return (int) (Math.pow(2, leftDepth) + countNodes(root.right));
            }
            // 2. Otherwise, the depth of the left subtree is bigger than the right subtree
            // At this time, the right subtree is a full binary tree.
            return (int) (Math.pow(2, rightDepth) + countNodes(root.left));
        }

        private int getDepth(TreeNode root) {
            // recursive exit
            if (root == null) return 0;
            return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        }
    }
}
