package _每日一题._2022年;

import _数据结构.Node;
import _数据结构.TreeNode;

import java.util.Stack;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/30
 */
public class _剑指Offer54_二叉搜索树的第k大节点 {

    /**
     * 解法1：迭代
     */
    class Solution {
        public int kthLargest(TreeNode root, int k) {
            Stack<TreeNode> stack=new Stack();
            while(!stack.isEmpty()||root!=null){
                while(root!=null){
                    stack.push(root);
                    root=root.right;
                }
                root=stack.pop();
                if(--k==0){
                    return root.val;
                }
                root=root.left;
            }
            return -1;
        }
    }
}
