package _每日一题._2022年._5月;

import _数据结构.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 * @Description
 */
public class _99_恢复二叉搜索树 {
    /**
     * 解法1：中序遍历+找到交换的两个数字+重新赋值二叉树 时间O(N) 空间O(N)
     */
    class Solution {
        public void recoverTree(TreeNode root) {
            List<Integer> nums = new ArrayList<Integer>();
            inorder(root, nums);
            int[] swapped = findTwoSwapped(nums);
            recover(root, 2, swapped[0], swapped[1]);
        }

        public void inorder(TreeNode root, List<Integer> nums) {
            if (root == null) {
                return;
            }
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }

        public int[] findTwoSwapped(List<Integer> nums) {
            int n = nums.size();
            int index1 = -1, index2 = -1;
            for (int i = 0; i < n - 1; ++i) {
                if (nums.get(i + 1) < nums.get(i)) {
                    index2 = i + 1;
                    if (index1 == -1) {
                        index1 = i;
                    } else {
                        break;
                    }
                }
            }
            int x = nums.get(index1), y = nums.get(index2);
            return new int[]{x, y};
        }

        public void recover(TreeNode root, int count, int x, int y) {
            if (root != null) {
                if (root.val == x || root.val == y) {
                    root.val = root.val == x ? y : x;
                    if (--count == 0) {
                        return;
                    }
                }
                recover(root.right, count, x, y);
                recover(root.left, count, x, y);
            }
        }
    }

    /**
     * 解法2：隐式的中序遍历
     */
    class Solution2 {
        public void recoverTree(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            TreeNode x = null, y = null, pred = null;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null) {
                        x = pred;
                    } else {
                        break;
                    }
                }
                pred = root;
                root = root.right;
            }

            swap(x, y);
        }

        public void swap(TreeNode x, TreeNode y) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }
}
