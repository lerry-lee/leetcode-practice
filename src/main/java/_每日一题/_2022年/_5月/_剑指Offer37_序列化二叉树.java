package _每日一题._2022年._5月;

import _数据结构.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/14
 * @Description
 */
public class _剑指Offer37_序列化二叉树 {
    /**
     * 解法1：递归 时间O(N) 空间O(N)
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            return sb.substring(0, sb.length() - 1);
        }

        private void dfs(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("null").append(",");
                return;
            }
            sb.append(root.val).append(",");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] arr = data.split(",");
            Deque<String> deque = new LinkedList<>();
            for (String em : arr) deque.addLast(em);
            return dfs(deque);
        }

        private TreeNode dfs(Deque<String> deque) {
            if (deque.isEmpty()) return null;
            String val = deque.removeFirst();
            if (val.equals("null")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = dfs(deque);
            root.right = dfs(deque);
            return root;
        }
    }
}
