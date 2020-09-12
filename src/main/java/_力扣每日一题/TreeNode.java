package _力扣每日一题;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/01 21:07
 * @description 二叉树数据结构
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
