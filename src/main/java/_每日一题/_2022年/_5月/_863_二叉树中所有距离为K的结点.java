package _每日一题._2022年._5月;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/10
 */
public class _863_二叉树中所有距离为K的结点 {

    /**
     * 解法1：dfs+哈希表（存父节点）
     */
    class Solution {
        Map<Integer, TreeNode> parents = new HashMap<Integer, TreeNode>();
        List<Integer> ans = new ArrayList<Integer>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            // 从 root 出发 DFS，记录每个结点的父结点
            findParents(root);

            // 从 target 出发 DFS，寻找所有深度为 k 的结点
            findAns(target, null, 0, k);

            return ans;
        }

        public void findParents(TreeNode node) {
            if (node.left != null) {
                parents.put(node.left.val, node);
                findParents(node.left);
            }
            if (node.right != null) {
                parents.put(node.right.val, node);
                findParents(node.right);
            }
        }

        public void findAns(TreeNode node, TreeNode from, int depth, int k) {
            if (node == null) {
                return;
            }
            if (depth == k) {
                ans.add(node.val);
                return;
            }
            if (node.left != from) {
                findAns(node.left, node, depth + 1, k);
            }
            if (node.right != from) {
                findAns(node.right, node, depth + 1, k);
            }
            if (parents.get(node.val) != from) {
                findAns(parents.get(node.val), node, depth + 1, k);
            }
        }
    }
}
