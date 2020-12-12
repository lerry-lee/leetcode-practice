package _每日一题._20年7月;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/21 10:02
 * @description 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：3
 * 输出：
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 8
 */
public class _95不同的二叉搜索树2 {
    /**
     * 思路1：递归
     * 我们可以利用一下查找二叉树的性质。左子树的所有值小于根节点，右子树的所有值大于根节点。
     * 所以如果求 1...n 的所有可能。
     * 我们只需要把 1 作为根节点，[ ] 空作为左子树，[ 2 ... n ] 的所有可能作为右子树。
     * 2 作为根节点，[ 1 ] 作为左子树，[ 3...n ] 的所有可能作为右子树。
     * 3 作为根节点，[ 1 2 ] 的所有可能作为左子树，[ 4 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
     * 4 作为根节点，[ 1 2 3 ] 的所有可能作为左子树，[ 5 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
     * ...
     * n 作为根节点，[ 1... n ] 的所有可能作为左子树，[ ] 作为右子树。
     * 至于，[ 2 ... n ] 的所有可能以及 [ 4 ... n ] 以及其他情况的所有可能，可以利用上边的方法，把每个数字作为根节点，然后把所有可能的左子树和右子树组合起来即可。
     * 如果只有一个数字，那么所有可能就是一种情况，把该数字作为一棵树。而如果是 [ ]，那就返回 null。
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return dfs(1, n);
    }

    public List<TreeNode> dfs(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = dfs(start, i - 1);
            List<TreeNode> rightTrees = dfs(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;

    }
}
