package _剑指Offer;

import _数据结构.TreeNode;

import java.util.*;

/**
 * @ClassName: _27二叉树的镜像
 * @Author: lerry_li
 * @CreateDate: 2021/03/02
 * @Description
 */
public class _27二叉树的镜像 {
    /**
     * 解法思路：左右子树交换
     * 解法1：递归
     * 解法2：迭代(用栈)
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rootCp=root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                swap(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            root = node.right;
        }
        return rootCp;
    }

    public void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

}
