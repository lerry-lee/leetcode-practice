package _每日一题._2021年._21年5月;

import _数据结构.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: _993二叉树的堂兄弟节点
 * @Author: lerry_li
 * @CreateDate: 2021/05/17
 * @Description
 * 解法1：递归
 */
public class _993二叉树的堂兄弟节点 {

    public static void main(String[] args) {
        _993二叉树的堂兄弟节点 instance = new _993二叉树的堂兄弟节点();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(instance.isCousins(root, 4, 3));

    }

    /**
     * 解法1：递归
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || x == y) return false;
        dfs(root, 0, x, y, 0);
        System.out.println(lX + " " + lY + " " + fX + " " + fY);
        return lX == lY && fX != fY;
    }

    int lX = 0, lY = 0;
    int fX = 0, fY = 0;

    private void dfs(TreeNode root, int father, int x, int y, int level) {
        if (root == null || (lX > 0 && lY > 0)) return;
        if (lX == 0 && root.val == x) {
            fX = father;
            lX = level;
        }
        if (lY == 0 && root.val == y) {
            fY = father;
            lY = level;
        }
        dfs(root.left, root.val, x, y, level + 1);
        dfs(root.right, root.val, x, y, level + 1);

    }
}
