package DailyProblem._20年10月;

import DataStructure.TreeNode;

/**
 * @ClassName: _129求根到叶子节点数字之和
 * @Signature: Created by lerry_li on 2020/10/29
 * @Description: 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 */
public class _129求根到叶子节点数字之和 {
    /**
     * 解法1：深度优先遍历
     * 递归：到达叶节点，将当前路径的数字累加到res上
     */
    public int sumNumbers(TreeNode root) {
        res = 0;
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        return res;
    }

    int res;

    public void dfs(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            sum = sum * 10 + root.val;
            res += sum;
            System.out.println("sum:" + sum + "\tres:" + res);
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum * 10 + root.val);
        }
        if (root.right != null) {
            dfs(root.right, sum * 10 + root.val);
        }
    }
}
