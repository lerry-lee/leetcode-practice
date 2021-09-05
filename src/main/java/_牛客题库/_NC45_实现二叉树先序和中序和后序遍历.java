package _牛客题库;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _NC45_实现二叉树先序和中序和后序遍历
 * @Author: lerry_li
 * @CreateTime: 2021/09/04
 * @Description
 */
public class _NC45_实现二叉树先序和中序和后序遍历 {
    /**
     * 解法1：迭代
     */
    public int[][] threeOrders (TreeNode root) {
        //栈模拟递归
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        //前序遍历：根左右
        List<Integer> preOrder=new ArrayList<>();
        while(!stack.isEmpty()||cur!=null){
            //只要左子节点不为空，就遍历左子节点
            while(cur!=null){
                //每次遍历前，将当前根节点的值加入list
                preOrder.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            }
            //否则，遍历右子节点
            cur=stack.pop();
            cur=cur.right;
        }
        int n=preOrder.size();
        int[][] res=new int[3][n];
        for(int i=0;i<n;i++){
            res[0][i]=preOrder.get(i);
        }
        //中序遍历：左根右
        cur=root;
        List<Integer> inOrder=new ArrayList<>();
        while(!stack.isEmpty()||cur!=null){
            //只要左子节点不为空，就遍历左子节点
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            //取出栈顶节点，将节点值加入list
            cur=stack.pop();
            inOrder.add(cur.val);
            //遍历右子节点
            cur=cur.right;
        }
        for(int i=0;i<n;i++){
            res[1][i]=inOrder.get(i);
        }
        //后序遍历：左右根
        cur=root;
        //记录上一个遍历的节点
        TreeNode pre=null;
        List<Integer> postOrder=new ArrayList<>();
        while(!stack.isEmpty()||cur!=null){
            //只要左子节点不为空，就遍历左子节点
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            //取出栈顶节点
            cur=stack.pop();
            //若节点的右子节点为空||右子节点已经遍历过
            //  则将根节点的值加入list
            if(cur.right==null||cur.right==pre){
                postOrder.add(cur.val);
                pre=cur;
                //置遍历指针为空，好继续访问栈顶节点
                cur=null;
            }
            //否则，右子节点需要遍历
            else{
                //根节点放回栈，因为它的右子节点还没有遍历
                stack.push(cur);
                //遍历右子节点
                cur=cur.right;
            }
        }
        for(int i=0;i<n;i++){
            res[2][i]=postOrder.get(i);
        }
        return res;
    }
}
