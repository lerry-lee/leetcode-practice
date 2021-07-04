package _每日一题._2021年._21年6月;

import _数据结构.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _剑指Offer37序列化二叉树
 * @Author: lerry_li
 * @CreateDate: 2021/07/04
 * @Description
 * 解法1：bfs
 */
public class _剑指Offer37序列化二叉树 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder("[");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    sb.append(cur.val).append(",");
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else {
                    sb.append("null,");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if (data.equals("[]")) return null;
        String[] arr = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!arr[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(cur.left);
            }
            i++;
            if (!arr[i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(cur.right);
            }
            i++;
        }
        return root;
    }
}
