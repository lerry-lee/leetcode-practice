package _每日一题._2022年._5月;

import _数据结构.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _297_二叉树的序列化与反序列化 {
    /**
     * 解法1；递归 时间O(N) 空间O(N)
     * tips:
     *      注意递归构造二叉树的时候，使用链表，每次删除头结点用来新建一个节点
     */
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            //特判
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            return sb.substring(0, sb.length() - 1);
        }

        //按照先序遍历，根左右
        private void dfs(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("N").append(",");
                return;
            }
            sb.append(root.val).append(",");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            //特判
            if (data == null || data.length() == 0) return null;
            String[] vals = data.split(",");
            Deque<String> valsDeque = new LinkedList<>();
            for (String val : vals) {
                valsDeque.addLast(val);
            }
            //递归构造
            return dfs(valsDeque);
        }

        //按照先序遍历，跟左右
        private TreeNode dfs(Deque<String> valsDeque) {
            if (valsDeque.isEmpty()) return null;
            String val = valsDeque.removeFirst();
            if (val.equals("N")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = dfs(valsDeque);
            root.right = dfs(valsDeque);
            return root;
        }
    }
}
