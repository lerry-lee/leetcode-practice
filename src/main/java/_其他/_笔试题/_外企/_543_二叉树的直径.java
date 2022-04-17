package _其他._笔试题._外企;

import _数据结构.TreeNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/17
 * @Description
 */
public class _543_二叉树的直径 {
    //全局变量记录最多节点个数
    private int res=1;

    /**
     * 求二叉树的最大直径：实际上就是求以某个节点为根节点的二叉树的高度和（左子树高度+右子树高度+1）
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res-1;
    }
    //递归求解
    public int dfs(TreeNode root){
        //空节点返回个数为0
        if(root==null){
            return 0;
        }
        //计算以左子节点为根节点的子树的高度
        int leftDepth=dfs(root.left);
        //计算以右子节点为根节点的子树的高度
        int rightDepth=dfs(root.right);
        //更新全局变量
        res=Math.max(res,leftDepth+rightDepth+1);
        //返回左子树高度和右子树高度的最大值，+1表示根节点
        return Math.max(leftDepth,rightDepth)+1;
    }
}
