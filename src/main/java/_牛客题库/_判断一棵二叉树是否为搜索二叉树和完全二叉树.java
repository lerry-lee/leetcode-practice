package _牛客题库;

import _数据结构.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _判断一棵二叉树是否为搜索二叉树和完全二叉树
 * @Author: lerry_li
 * @CreateDate: 2021/06/02
 * @Description
 */
public class _判断一棵二叉树是否为搜索二叉树和完全二叉树 {
    public boolean[] judgeIt(TreeNode root) {
        //特判
        if (root == null) return new boolean[]{false, false};
        // write code here
        boolean[] res = new boolean[2];
        res[0] = checkSearchTree(root);
        //完全二叉树判断
        res[1] = checkFullTree(root);
        return res;
    }

    private boolean checkFullTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //标记是否已经出现null节点
        boolean hasNull = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                //若前面节点的子节点已经出现了null节点，则当前节点的直接点必须为null
                if (hasNull) {
                    if (cur.left != null || cur.right != null) return false;
                } else {
                    //当前节点的左子结点要么有值，要么为null同时右子节点必须为null
                    if (cur.left != null && cur.right != null) {
                        queue.offer(cur.left);
                        queue.offer(cur.right);
                    } else if (cur.right != null) return false;
                        //否则，左子节点有值或为NULL，右子节点为null
                    else hasNull = true;
                }
            }
        }
        return true;
    }

    /**
     * 判断二叉搜索树法1：递归+中序遍历思想
     * 思路：
     *      中序遍历二叉树，每次判断当前节点的值是否大于上一个节点的值
     */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

    /**
     * 判断二叉搜索树法2：递归+二叉搜索树性质
     * 思路：
     *      对于二叉搜索树的每一个节点，其左子树的所有节点的值均<当前节点的值，其右子树的所有节点的值均>当前节点的值
     */
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    //为啥不对？
    private boolean checkSearchTree(TreeNode root) {
        if (root == null) return true;
        //左<根，右>跟
        if (root.left != null && root.val < root.left.val) return false;
        boolean left = checkSearchTree(root.left);
        if (!left) return false;
        if (root.right != null && root.val > root.right.val) return false;
        return checkSearchTree(root.left);
    }
}
