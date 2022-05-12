package _每日一题._2022年._5月;

import _数据结构.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _449_序列化和反序列化二叉搜索树 {
    /**
     * 解法1：当作普通二叉树来做。
     * 解法2：利用二叉搜索树的性质来做。
     */
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            return sb.substring(0, sb.length() - 1);
        }

        private void dfs(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val).append(",");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] vals = data.split(",");
            Deque<Integer> deque = new LinkedList<>();
            for (String val : vals) deque.addLast(Integer.valueOf(val));
            return dfs(deque, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode dfs(Deque<Integer> deque, int minVal, int maxVal) {
            if (deque.isEmpty()) return null;
            int val = deque.peekFirst();
            if (val > minVal && val < maxVal) {
                deque.removeFirst();
                TreeNode root = new TreeNode(val);
                root.left = dfs(deque, minVal, val);
                root.right = dfs(deque, val, maxVal);
                return root;
            }
            return null;
        }
    }
}
