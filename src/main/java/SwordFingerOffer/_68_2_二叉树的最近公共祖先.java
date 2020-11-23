package SwordFingerOffer;

import DataStructure.TreeNode;

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
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = deque.pollFirst();
                if (currNode.left != null) {
                    parentNode.put(currNode.left, currNode);
                    deque.offerLast(currNode.left);
                }
                if (currNode.right != null) {
                    parentNode.put(currNode.right, currNode);
                    deque.offerLast(currNode.right);
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
