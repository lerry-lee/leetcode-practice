package _每日一题._2022年;

import _数据结构.TreeNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _110_平衡二叉树 {
    /**
     * 解法1：递归（包含重复计算）
     * 解法2：递归（不含重复计算）
     */
    class Solution2 {
        public boolean isBalanced(TreeNode root) {
            if(root==null) return true;
            return check(root)!=-1;
        }
        //检查当前根节点是否合法，合法返回高度，不合法返回-1
        public int check(TreeNode root){
            //递归出口
            if(root==null) return 0;
            //分别计算左子树、右子树
            int left=check(root.left),right=check(root.right);
            //如果左右子树高度差>1，或者左右子树中有不平衡的，返回-1
            if(Math.abs(left-right)>1) return -1;
            if(left==-1||right==-1) return -1;
            //否则，当前根节点的左右子树是平衡的，返回根节点高度
            return Math.max(left,right)+1;
        }
    }

}
