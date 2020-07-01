package _力扣每日一题;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/01 21:07
 * @description 二叉树数据结构
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
