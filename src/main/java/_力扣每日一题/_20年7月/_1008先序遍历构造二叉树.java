package _力扣每日一题._20年7月;

import _力扣每日一题.dataStructure.TreeNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/01 21:06
 * @description 1008. 先序遍历构造二叉树
 * 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 * <p>
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node
 * .val。此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）
 */
public class _1008先序遍历构造二叉树 {
    /**
     * 思路1：二叉搜索树，由于中序遍历得到的是一个升序数组，因此可以将先序遍历结果排序，得到中序遍历，然后根据先序、中序遍历确定该二叉树
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        //得到中序遍历数组
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        //根据先序遍历数组、中序遍历数组，可以确定一个二叉树
        //具体构造方法见：105从前序与中序遍历序列构造二叉树
        return null;
    }

    /**
     * 思路2：根据先序遍历，依次插入二叉树【为何可以这样做？】
     */
    public TreeNode _根据先序遍历直接插入(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode head = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode temp = head;
            while (true) {
                while (temp.left != null && preorder[i] < temp.val) {
                    temp = temp.left;
                }
                if (preorder[i] < temp.val) {
                    temp.left = new TreeNode(preorder[i]);
                    break;
                }
                while (temp.right != null && preorder[i] > temp.val) {
                    temp = temp.right;
                }
                if (preorder[i] > temp.val) {
                    temp.right = new TreeNode(preorder[i]);
                    break;
                }
            }
        }
        return head;
    }

    /**
     * 思路3：可以用栈解决
     * 使用 for 循环迭代先序遍历中剩下的所有元素：
     * <p>
     * 将栈顶的元素作为父节点，当前先序遍历中的元素作为子节点。如果栈顶的元素值小于子节点的元素值，则将栈顶的元素弹出并作为新的父节点，直到栈空或栈顶的元素值大于子节点的元素值。注意，这里作为父节点的是最后一个被弹出栈的元素，而不是此时栈顶的元素；
     * <p>
     * 如果父节点的元素值小于子节点的元素值，则子节点为右孩子，否则为左孩子；
     * <p>
     * 将子节点放入栈中。
     */
    public TreeNode _用栈(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode head=new TreeNode(preorder[0]);
        stack.push(head);
        TreeNode root=head;
        for(int i=1;i<preorder.length;i++){
            int val=preorder[i];
            //每次创建一个临时节点，值为遍历到的节点值
            TreeNode temp=new TreeNode(val);
            //每次操作的初始父节点为：栈顶节点
            head=stack.peek();
            //如果临时节点的值比栈顶节点的值要小，那么说明是它的左孩子
            if(val<stack.peek().val){
                head.left=temp;
            }
            //否则，一直弹出值小于临时节点值的栈顶的节点，直到栈顶节点值比临时节点值要大（或栈空了），说明上一次弹出的节点是它的父节点
            else{
                while(!stack.isEmpty()&&stack.peek().val<val){
                    head=stack.pop();
                }
                head.right=temp;
            }
            //每次把临时节点入栈
            stack.push(temp);
        }
        return root;
    }

}
