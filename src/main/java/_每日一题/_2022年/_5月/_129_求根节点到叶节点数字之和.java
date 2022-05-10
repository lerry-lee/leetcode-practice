package _每日一题._2022年._5月;

import _数据结构.TreeNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/10
 */
public class _129_求根节点到叶节点数字之和 {
    class Solution {
        public int sumNumbers(TreeNode root) {
            return dfs(root,0);
        }

        private int dfs(TreeNode root, int res) {
            if(root==null) return 0;
            res=res*10+root.val;
            if(root.left==null&&root.right==null){
                return res;
            }
            return dfs(root.left,res)+dfs(root.right,res);
        }
    }
}
