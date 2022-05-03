package _每日一题._2022年._5月3日;

import _数据结构.TreeNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/03
 * @Description
 */
public class _222_完全二叉树的节点个数 {
    /**
     * 解法1：利用满二叉树的性质
     */
    class Solution {
        public int countNodes(TreeNode root) {
            // 节点为空，返回0个节点
            if(root == null){
                return 0;
            }
            // 递归计算左子树的高度、右子树的高度
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            // 1.如果左右子树的高度相同，说明，左子树已经满了，不然右子树不可能达到相同的高度
            if(left == right){
                // 此时左子树的高度为left，总节点数为2^left-1，再+1表示加上当前root
                // 返回右子树的节点数(递归计算)+2^left
                return countNodes(root.right) + (1<<left);
            }
            // 2.否则，左右子树高度不同，那么，右子树一定是满的，不然肯定高度和左子树相同了
            else{
                // 此时右子树的高度为right，总节点数为2^right-1，再+1表示加上当前root
                // 返回左子树的节点数(递归计算)+2^right
                return countNodes(root.left) + (1<<right);
            }
        }
        // 计算满二叉树的高度，由于是满的，只需算左子树即可，右子树不可能比左子树高
        private int getDepth(TreeNode root){
            int level = 0;
            while(root != null){
                level++;
                root = root.left;
            }
            return level;
        }
    }
}
