package _剑指Offer;

import _数据结构.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _37序列化二叉树
 * @Author: lerry_li
 * @CreateDate: 2021/04/19
 * @Description
 * 解法1：bfs
 */
public class _37序列化二叉树 {
    /**
     * 解法1：bfs 时间O(N) 空间O(N)
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        sb.append("null,");
                    } else {
                        sb.append(node.val).append(",");
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            System.out.println(sb.toString());
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }
            data = data.substring(1, data.length() - 1);
//            System.out.println(data);
            String[] vals = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            queue.offer(root);
            int i = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(!vals[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(node.left);
                }
                i++;
                if(!vals[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(node.right);
                }
                i++;
            }
            return root;
        }
    }
}
