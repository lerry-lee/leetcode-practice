package _剑指Offer;

import _数据结构.TreeNode;

/**
 * @ClassName: _28对称的二叉树
 * @Author: lerry_li
 * @CreateTime: 2021/04/10
 * @Description
 */
public class _28对称的二叉树 {
    /**
     * 解法1：DFS递归 时间O(N) 空间O(N)
     * 思路：
     *      对于根节点的左右子树，递归向下比较，根据对称性，L.left和R.right比较，L.right和R.left比较
     */
    public boolean isSymmetric(TreeNode root) {
        //根节点为null，直接返回true
        if (root == null) {
            return true;
        }
        //check根节点的left和right节点
        return check(root.left, root.right);
    }

    /**
     * 递归检查，L和R为对称位置的左子树/右子树的节点
     * @param L root左子树的待检查节点
     * @param R root右子树的待检查节点
     * @return true/false
     */
    private boolean check(TreeNode L, TreeNode R) {
        //左右子节点同时为null，返回true
        if (L == null && R == null) {
            return true;
        }
        //左右子节点某一个为null或者两者的val不同时，返回false
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        //递归检查L的left和R的right，L的right和R的left
        return check(L.left, R.right) && check(L.right, R.left);
    }

}
