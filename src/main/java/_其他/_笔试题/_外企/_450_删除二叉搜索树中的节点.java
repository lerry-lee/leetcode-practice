package _其他._笔试题._外企;

import _数据结构.TreeNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/17
 * @Description
 */
public class _450_删除二叉搜索树中的节点 {
    /**
     * 解法1：参考图解
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        //key<当前节点值，去左子树里面找
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        //key>当前节点值，去右子树里面找
        else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        //key=当前节点值，删除当前节点
        else {
            //如果当前节点，左右子树都不为空
            if(root.left != null && root.right != null){
                //找到右子树的最左子节点，因为它满足大于可以充当新的根节点的条件
                TreeNode node=root.right;
                while(node.left!=null){
                    node=node.left;
                }
                //把左子树接到找到的节点的左子树上
                node.left=root.left;
                root=root.right;
            }
            //否则，当前节点只有一个子树，直接移上来完事
            else if(root.left == null){
                return root.right;
            }else {
                return root.left;
            }
        }
        return root;
    }
}
