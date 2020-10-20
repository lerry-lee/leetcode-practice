package _每日一题._20年9月;

import _数据结构.TreeNode;

import java.util.*;

/**
 * @ClassName : _538把二叉搜索树转换为累加树
 * @CreateTime : 2020/09/21 09
 * @Author : lerry_li
 * @Descrpition : 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * <p>
 * <p>
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 */
public class _538把二叉搜索树转换为累加树 {
    /**
     * 解法1：暴力破解，将节点值存到数组并排序
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        List<Integer> nodeVals = new ArrayList<>();
        getNodeVals(nodeVals, root);
        int[] nums = new int[nodeVals.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nodeVals.get(i);
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        dp[dp.length - 1] = 0;
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + nums[i + 1];
        }

        changeTree(root, hashMap, dp);
        return root;
    }

    public void getNodeVals(List<Integer> nodeVals, TreeNode root) {
        if (root == null) return;
        nodeVals.add(root.val);
        getNodeVals(nodeVals, root.left);
        getNodeVals(nodeVals, root.right);
    }

    public void changeTree(TreeNode root, HashMap<Integer, Integer> hashMap, int[] dp) {
        if (root == null) return;
        root.val += dp[hashMap.get(root.val)];
        changeTree(root.left, hashMap, dp);
        changeTree(root.right, hashMap, dp);
    }

    /**
     * 解法2：利用二叉搜索树性质，左子树小于根节点，右子树大于根节点
     * 反向中序遍历
     * 二叉搜索树是一棵空树，或者是具有下列性质的二叉树：
     * <p>
     * 若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
     * <p>
     * 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
     * <p>
     * 它的左、右子树也分别为二叉搜索树。
     * <p>
     * 由这样的性质我们可以发现，二叉搜索树的中序遍历是一个单调递增的有序序列。如果我们反序地中序遍历该二叉搜索树，即可得到一个单调递减的有序序列。
     * <p>
     * 本题中要求我们将每个节点的值修改为原来的节点值加上所有大于它的节点值之和。这样我们只需要反序中序遍历该二叉搜索树，记录过程中的节点值之和，并不断更新当前遍历到的节点的节点值，即可得到题目要求的累加树。
     */
    int sum = 0;

    public TreeNode convertBST_b(TreeNode root) {
        if (root == null) return null;
        convertBST_b(root.right);
        sum += root.val;
        root.val = sum;
        convertBST_b(root.left);
        return root;
    }

}
