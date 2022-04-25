package _剑指Offer;

import _数据结构.TreeNode;

import java.util.*;

/**
 * @ClassName: _68_1_二叉树的最近公共祖先
 * @Author: lerry_li
 * @CreateDate: 2020/11/23
 * @Description
 */
public class _68_2_二叉树的最近公共祖先 {
    /**
     * 解法1：哈希表法 时间O(N) 空间O(N)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        if (p == q) {
            return p;
        }
        Map<TreeNode, TreeNode> parentNode = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.remove();
                if (currNode.left != null) {
                    parentNode.put(currNode.left, currNode);
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    parentNode.put(currNode.right, currNode);
                    queue.add(currNode.right);
                }
            }
        }
        Set<TreeNode> hashSet = new HashSet<>();
        while (p != root) {
            hashSet.add(p);
            p = parentNode.get(p);
        }
        while (q != root) {
            if (hashSet.contains(q)) {
                return q;
            }
            q = parentNode.get(q);
        }
        return root;
    }

    /**
     * 解法2：递归
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        if (p == q) {
            return p;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
