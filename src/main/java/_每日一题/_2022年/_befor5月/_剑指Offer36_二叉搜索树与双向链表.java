package _每日一题._2022年._befor5月;

import _数据结构.Node;

import java.util.Stack;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/30
 */
public class _剑指Offer36_二叉搜索树与双向链表 {


    /**
     * 解法1：递归
     * 解法2：迭代
     */
    class Solution {

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            Node head=null,prev=null,cur=null;
            Stack<Node> stack=new Stack();
            while(!stack.isEmpty()||root!=null){
                while(root!=null){
                    stack.push(root);
                    root=root.left;
                }
                cur=stack.pop();
                if(head==null){
                    head=cur;
                    prev=head;
                }else{
                    prev.right=cur;
                    cur.left=prev;
                    prev=cur;
                }
                root=cur.right;
            }
            head.left=cur;
            cur.right=head;
            return head;
        }
    }
}
