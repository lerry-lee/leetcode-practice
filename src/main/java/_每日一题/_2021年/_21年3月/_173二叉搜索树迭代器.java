package _每日一题._2021年._21年3月;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _173二叉搜索树迭代器
 * @Author: lerry_li
 * @CreateTime: 2021/03/28
 * @Description
 */
public class _173二叉搜索树迭代器 {
    /**
     * 解法1：先中序遍历然后保存到list中，然后每次使用cursor取对应的元素 时间O(N) 空间O(N)
     */
    class BSTIterator {
        private List<Integer> values;
        private int cursor;

        public BSTIterator(TreeNode root) {
            values = new ArrayList<>();
            cursor = 0;
            dfs(root);
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            values.add(root.val);
            dfs(root.right);
        }

        public int next() {
            return values.get(cursor++);
        }

        public boolean hasNext() {
            if (cursor == values.size()) {
                return false;
            }
            return true;
        }
    }

    /**
     * 解法2：用栈 时间O(1) 空间O(n)
     */
    class BSTIterator2 {
        private Stack<TreeNode> stack;
        private TreeNode cur;

        public BSTIterator2(TreeNode root) {
            stack = new Stack<>();
            cur = root;
        }

        public int next() {
            //将左子节点入栈
            //若cur不为null，则说明cur的左子结点还没有遍历
            //否则，cur为null，说明之前已经遍历了cur的左子节点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //取出栈顶元素
            cur = stack.pop();
            //记录返回值
            int res = cur.val;
            //cur指向右子节点
            cur = cur.right;
            return res;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
