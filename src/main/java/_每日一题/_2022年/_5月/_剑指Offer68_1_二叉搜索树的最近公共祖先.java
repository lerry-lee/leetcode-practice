package _每日一题._2022年._5月;

import _数据结构.TreeNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/04
 */
public class _剑指Offer68_1_二叉搜索树的最近公共祖先 {
    /**
     * 解法1：递归+二叉搜索树性质 时间O(N) 空间O(N)递归栈空间
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null||root==p||root==q){
                return root;
            }
            //如果根节点的值<p和q的值，说明p和q的的祖先在根节点的右子树中，递归寻找
            if(root.val<p.val&&root.val<q.val) return lowestCommonAncestor(root.right,p,q);
            //如果根节点的值>p和q的值，说明p和q的的祖先在根节点的左子树中，递归寻找
            if(root.val>p.val&&root.val>q.val) return lowestCommonAncestor(root.left,p,q);
            //否则，当前根节点就是p和q的祖先节点
            return root;
        }
    }

    /**
     * 解法2：迭代
     */
    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while(root != null) {
                if(root.val < p.val && root.val < q.val) // p,q 都在 root 的右子树中
                    root = root.right; // 遍历至右子节点
                else if(root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
                    root = root.left; // 遍历至左子节点
                else break;
            }
            return root;
        }
    }
}
