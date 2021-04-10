package _剑指Offer;

import _数据结构.TreeNode;

/**
 * @ClassName: _26树的子结构
 * @Author: lerry_li
 * @CreateDate: 2021/04/10
 * @Description
 */
public class _26树的子结构 {
    /**
     * 解法1：递归 时间o(MN) 空间O(M) M为A的节点数，N为B的节点数
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        //首先A和B直接匹配判断isMatched
        //然后A的左子树和B比较isSubStructure
        //然后A的右子树和B比较isSubStructure
        return isMatched(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 当A和B的根节点相同时，递归判断B是否是A的子集
     */
    public boolean isMatched(TreeNode A, TreeNode B) {
        //B为空了，返回true
        if (B == null) {
            return true;
        }
        //B不为空，A为空了，返回false
        if (A == null) {
            return false;
        }
        //A和B的值不同，返回false
        if (A.val != B.val) {
            return false;
        }
        //A和B的值相同，递归判断子树
        return isMatched(A.left, B.left) && isMatched(A.right, B.right);
    }
}
