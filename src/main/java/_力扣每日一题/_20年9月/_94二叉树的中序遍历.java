package _力扣每日一题._20年9月;

import _力扣每日一题.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName ： _94二叉树的中序遍历
 * @Date ： 上午9:59 20-9-14
 * @Author ： lerry_li
 * @Description ： 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 **/
public class _94二叉树的中序遍历 {
    /**
     * 解法1：递归
     */
    public List<Integer> inorderTraversal_recursive(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        dfs(res,root);
        return res;
    }
    public void dfs(List<Integer> res, TreeNode root){
        if(root==null) return;
        dfs(res,root.left);
        res.add(root.val);
        dfs(res,root.right);
    }
    /**
     * 解法2：迭代
     * 思路：用栈模拟
     * 1）根节点入栈，搜索到左子叶节点，把搜索过程中的左子节点入栈
     * 2）左子也叶节点出栈，添加节点值
     * 3）左子叶节点的父节点出栈，添加节点值，右子节点入栈
     * 4）重复123,节点为NULL并且栈为空
     */
    public List<Integer> inorderTraversal_iterative(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }
}
