package _每日一题._2022年._5月3日;

import _数据结构.TreeNode;

import java.util.ArrayDeque;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/03
 * @Description
 */
public class _449_序列化和反序列化二叉搜索树 {
    /**
     * 解法1：后序遍历
     */
    class Solution {
        //存储后序遍历的结果
        public StringBuilder postorder(TreeNode root, StringBuilder sb) {
            if (root == null)
                return sb;
            postorder(root.left, sb);
            postorder(root.right, sb);
            sb.append(root.val);
            sb.append(' ');
            return sb;
        }

        // Encodes a tree to a single string.
        // 二叉树编码成字符串
        public String serialize(TreeNode root) {
            StringBuilder sb = postorder(root, new StringBuilder());
            if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        // 从后序遍历中构建二叉树
        // 精髓在于[lower,upper]通过这个，可以判断节点属于哪个子树
        public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
            // 序列为空时，返回空节点
            if (nums.isEmpty())
                return null;
            // 获得根节点的值
            int val = nums.getLast();
            // 如果根节点的值不符合[lower,upper]的范围，说明不是一个合法的节点，留给递归上一层去处理
            if (val < lower || val > upper)
                return null;
            // 否则，新建一个节点
            nums.removeLast();
            TreeNode root = new TreeNode(val);
            // 因为是倒着来的，所以先右子树、再左子树
            root.right = helper(val, upper, nums);
            root.left = helper(lower, val, nums);
            // 返回根节点
            return root;
        }

        // Decodes your encoded data to tree.
        // 字符串解码成二叉树
        public TreeNode deserialize(String data) {
            if (data.isEmpty())
                return null;
            ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
            for (String s : data.split("\\s+"))
                nums.add(Integer.valueOf(s));
            return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
        }
    }
}
