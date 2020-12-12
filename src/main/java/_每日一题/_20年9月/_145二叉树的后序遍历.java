package _每日一题._20年9月;

import _数据结构.TreeNode;

import java.util.*;

/**
 * Created by lerry_li on 2020/09/29
 */

/**
 * 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class _145二叉树的后序遍历 {

    /**
     * 解法1：递归（简单略）
     * 解法2：迭代:用栈模拟递归
     */
    /**
     * 前序遍历的迭代算法：
     * 核心思想为：
     * <p>
     * 每拿到一个 节点 就把它保存在 栈 中
     * <p>
     * 继续对这个节点的 左子树 重复 过程1，直到左子树为 空
     * <p>
     * 因为保存在 栈 中的节点都遍历了 左子树 但是没有遍历 右子树，所以对栈中节点 出栈 并对它的 右子树 重复 过程1
     * <p>
     * 直到遍历完所有节点
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop().left;
            }
        }
        List<Integer> res_ = new ArrayList<>(res.size());
        for (int i = res.size() - 1; i >= 0; i--) {
            res_.add(res.get(i));
        }
        return res_;
    }
}
