package _每日一题._20年11月;

import _数据结构.TreeNode;

/**
 * @ClassName: _222完全二叉树的节点个数
 * @Author: lerry_li
 * @CreateDate: 2020/11/24
 * @Description
 */
public class _222完全二叉树的节点个数 {
    /**
     * 解法1：递归（未利用完全二叉树的性质）
     */
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=countNodes(root.left);
        int right=countNodes(root.right);
        return left+right+1;
    }
    /**
     * 解法2：二分查找+位运算
     * 思路：
     *      先求完全二叉树的深度h，那么最后一层的节点个数在1~2^h之间，节点总数在[2^h,2^(h+1)-1]
     *      利用二分查找性质，每次找一半
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //统计二叉树的深度
        int height = 0;
        TreeNode node = root;
        while (node.left != null) {
            height++;
            node = node.left;
        }
        int low = 1 << height, high = (1 << (height + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, height, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int height, int k) {
        int bits = 1 << (height - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

}
