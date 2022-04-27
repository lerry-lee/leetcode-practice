package _每日一题._2022年;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/27
 * @Description
 */
public class _297_二叉树的序列化与反序列化 {
    /**
     * 解法1：先序遍历
     */
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            List<Integer> preOrder = new ArrayList<>();
            dfs(root, preOrder);
            StringBuilder sb = new StringBuilder();
            for (Integer val : preOrder) {
                sb.append(val).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        /**
         * 序列化递归方法
         */
        public void dfs(TreeNode root, List<Integer> preOrder) {
            if (root == null) preOrder.add(null);
            else {
                preOrder.add(root.val);
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

        /**
         * 反序列化递归方法
         */
        public TreeNode dfs(List<String> dataList) {
            if (dataList.isEmpty()) return null;
            String data=dataList.get(0);
            //每次用完一个数据，就把它从list中删除，这一点很重要
            dataList.remove(0);
            if (data.equals("null")) return null;
            TreeNode node = new TreeNode(Integer.parseInt(data));
            node.left = dfs(dataList);
            node.right = dfs(dataList);
            return node;
        }
    }
}
