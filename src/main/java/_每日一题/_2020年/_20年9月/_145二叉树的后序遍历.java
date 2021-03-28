package _每日一题._2020年._20年9月;

import _数据结构.TreeNode;

import java.util.*;

/**
 * Created by lerry_li on 2020/09/29
 */

public class _145二叉树的后序遍历 {

    /**
     * 解法1：递归（简单略）
     * 解法2：迭代: 根右左→反转
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop().left;
            }
        }
        List<Integer> res_ = new ArrayList<>(res.size());
        for (int i = res.size() - 1; i >= 0; i--) {
            res_.add(res.get(i));
        }
        return res_;
    }

    /**
     * 解法3：真正 解法2并不是真正意义上的后序遍历
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //记录上一次遍历的节点
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            //只要有左子节点，就入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //取出栈顶元素
            root = stack.pop();
            //后序遍历：左→右→根
            //1.若root的right节点为空，则可以遍历root节点
            //2.若root的right节点已经遍历过了，则可以遍历root节点
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            }
            //否则，需要遍历root的right节点，遍历前将root再次入栈
            else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
