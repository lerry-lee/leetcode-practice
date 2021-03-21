package _每日一题._2021年._21年3月;

import _数据结构.TreeNode;

/**
 * @ClassName: _968监控二叉树
 * @Author: lerry_li
 * @CreateTime: 2021/03/21
 * @Description
 */
public class _968监控二叉树 {
    int res;

    /**
     * 解法1：树形dp
     * 状态定义：
     * 1表示未安装摄像头（且未被监控）
     * 2表示未安装摄像头（但已被监控），
     * 3表示已安装摄像头（摄像头+1）
     */
    public int minCameraCover(TreeNode root) {
        res = 0;
        //最终还要判断root的状态
        int rootState = dp(root);
        //若root未被监控，需要装一个摄像头
        if (rootState == 1) {
            res++;
        }
        return res;
    }

    public int dp(TreeNode root) {
        //root为空相当于已被监控（且不用安装摄像头），返回状态2
        if (root == null) {
            return 2;
        }
        //递归计算子节点
        int leftState = dp(root.left), rightState = dp(root.right);
        //若左子节点和右子节点中至少有一个安装了摄像头(3)，有一个被监控(2)，则root也被监控到了（不用安装摄像头）
        if (leftState + rightState >= 5) {
            return 2;
        }
        //若左子节点和右子节点都已经被监控，则root需要状态为未被监控
        if (leftState == 2 && rightState == 2) {
            return 1;
        }
        //否则，左子节点和右子节点至少有一个没有被监控到，则root需要安装一个摄像头
        else {
            //摄像头+1
            res++;
            return 3;
        }
    }
}
