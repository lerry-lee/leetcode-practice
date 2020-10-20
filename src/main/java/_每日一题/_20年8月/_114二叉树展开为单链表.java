package _每日一题._20年8月;

import _数据结构.TreeNode;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/08/02 11:32
 * @description 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class _114二叉树展开为单链表 {
    /**
     * 解法：参考题解
     * 1.将左子树插入到右子树的地方
     * 2.将原来的右子树接到左子树的最右边节点
     * 3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     */
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left==null){
                root=root.right;
            }
            else{
                TreeNode left_r=root.left;
                while(left_r.right!=null) left_r=left_r.right;
                left_r.right=root.right;
                root.right=root.left;
                root.left=null;
            }
        }
    }
}
