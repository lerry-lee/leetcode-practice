package _力扣每日一题._20年9月;

import _数据结构.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by lerry_li on 2020/09/28
 */

/**
 *  填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class _117填充每个节点的下一个右侧节点 {
    /**
     * 解法1：广度优先遍历 时间复杂度O(n) 空间复杂度O(n)
     * 双端队列Deque
     */
    public Node connect(Node root) {
        if(root==null) return null;
        Deque<Node> deque=new LinkedList<>();
        deque.offerLast(root);
        Node current=null;
        while(!deque.isEmpty()){
            int size=deque.size();
            for(int i=0;i<size;i++){
                Node node=deque.pollFirst();
                if(i==0) current=node;
                else{
                    current.next=node;
                    current=node;
                }
                if(node.left!=null) deque.offerLast(node.left);
                if(node.right!=null) deque.offerLast(node.right);
            }
        }
        return root;
    }
}
