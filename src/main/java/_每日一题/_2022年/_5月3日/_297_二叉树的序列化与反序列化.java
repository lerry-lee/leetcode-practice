package _每日一题._2022年._5月3日;

import _数据结构.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/03
 * @Description
 */
public class _297_二叉树的序列化与反序列化 {
    /**
     * 解法1：先序遍历+递归构造（利用链表，每次用掉头部元素）
     */
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder preOrder = new StringBuilder();
            dfs(root, preOrder);
            preOrder.deleteCharAt(preOrder.length() - 1);
            return preOrder.toString();
        }

        public void dfs(TreeNode root,StringBuilder preOrder) {
            if (root == null) preOrder.append("null").append(",");
            else {
                preOrder.append(root.val).append(",");
                dfs(root.left, preOrder);
                dfs(root.right, preOrder);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] vals = data.split(",");
            List<String> dataList = new LinkedList<>(Arrays.asList(vals));
            return dfs(dataList);
        }

        public TreeNode dfs(List<String> dataList) {
            if (dataList.isEmpty()) return null;
            String data=dataList.get(0);
            dataList.remove(0);
            if (data.equals("null")) return null;
            TreeNode node = new TreeNode(Integer.parseInt(data));
            node.left = dfs(dataList);
            node.right = dfs(dataList);
            return node;
        }
    }
}
