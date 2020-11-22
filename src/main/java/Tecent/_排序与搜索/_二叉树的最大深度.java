package Tecent._排序与搜索;

import DataStructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by lerry_li on 2020/10/23
 */
public class _二叉树的最大深度 {
    /**
     * 解法1：递归1 (全局变量)
     */
    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        dfs(root, 0);
        return maxDepth;
    }

    int maxDepth;

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    /**
     * 解法2：递归2 （递归求左右子树的高度）
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth2(root.left) + 1;
        int rightDepth = maxDepth2(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

    /**
     * 解法3：BFS （双端队列）
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        int res = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
                if (node.right != null) {
                    deque.offerLast(node.right);
                }
            }
        }
        return res;
    }

    /**
     * 解法4：迭代（用栈） 模拟二叉树的遍历（不解决此题）
     */
    public int maxDepth4(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0, temp = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                temp++;
                stack.push(root);
                root = root.left;
            } else {
                res = Math.max(res, temp);
                TreeNode node = stack.pop();
                root = node.right;
                if (root == null) {
                    temp--;
                } else {
                    temp++;
                }
            }
        }
        return res;
    }
}
