package DailyProblem._20年10月;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lerry_li on 2020/10/27
 */
public class _144二叉树的前序遍历 {
    /**
     * 解法1：递归
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root);
        return res;
    }

    public void dfs(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        dfs(res, root.left);
        dfs(res, root.right);
    }

    /**
     * 解法2：迭代
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            TreeNode node = stack.pop();
            root = node.right;
        }
        return res;
    }
}
