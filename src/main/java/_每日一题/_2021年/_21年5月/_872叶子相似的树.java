package _每日一题._2021年._21年5月;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _872叶子相似的树
 * @Author: lerry_li
 * @CreateDate: 2021/05/10
 * @Description
 * 解法1：递归遍历
 */
public class _872叶子相似的树 {

    /**
     * 解法1：递归遍历 时间O(M+N) 空间O(M+N)
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        List<Integer> val1 = new ArrayList<>();
        List<Integer> val2 = new ArrayList<>();
        dfs(root1, val1);
        dfs(root2, val2);
        if (val1.size() != val2.size()) {
            return false;
        }
        for (int i = 0; i < val1.size(); i++) {
            if (!val1.get(i).equals(val2.get(i))) return false;
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> val) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            val.add(root.val);
        } else {
            dfs(root.left, val);
            dfs(root.right, val);
        }
    }
}
