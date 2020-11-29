package SwordFingerOffer;

import DataStructure.TreeNode;

import java.util.Stack;

/**
 * @ClassName: _54二叉搜索树的第k大节点
 * @Author: lerry_li
 * @CreateTime: 2020/11/29
 * @Description
 */
public class _54二叉搜索树的第k大节点 {
    /**
     * 解法1：遍历：右-根-左（迭代）
     */
    public int kthLargest(TreeNode root, int k) {
        if(root==null||k<1){
            return 0;
        }
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root=root.right;
            }
            TreeNode node=stack.pop();
            k--;
            if(k==0){
                return node.val;
            }
            if(node.left!=null){
                root=node.left;
            }
        }
        return 0;
    }
    /**
     * 解法2：递归
     */
    public int kthLargest2(TreeNode root, int k) {
        K=0;
        dfs(root,k);
        return res;
    }
    int res;
    int K;
    public void dfs(TreeNode root,int k){
        if(root==null){
            return;
        }
        dfs(root.right,k);
        K++;
        if(K==k){
            res=root.val;
            return;
        }
        dfs(root.left,k);
    }
}
