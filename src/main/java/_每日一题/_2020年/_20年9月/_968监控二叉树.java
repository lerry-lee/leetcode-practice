package _每日一题._2020年._20年9月;

import _数据结构.TreeNode;

/**
 * @ClassName : _968监控二叉树
 * @CreateTime : 2020/09/22 09
 * @Author : lerry_li
 * @Descrpition :监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 */
public class _968监控二叉树 {
    public int minCameraCover(TreeNode root) {
        //若root的状态是1，即未被监控，那么需要安装一个摄像头，计数器+1
        if (dfs(root) == 1) cnt++;
        return cnt;
    }

    int cnt = 0;

    /**
     * 每个节点三种状态：
     * 1-->未被监控
     * 2-->已被监控（该节点未安装摄像头）
     * 3-->已被监控（该节点已安装摄像头，计数器+1）
     * 因此，只有状态3计数器需要+1
     */
    public int dfs(TreeNode node) {
        //如果当前节点为空，可以理解为已经被监控，直接返回状态2
        if (node == null) return 2;
        //递归计算左子节点、右子节点的状态
        int left = dfs(node.left), right = dfs(node.right);
        //如果左子节点、右子节点的状态为3，表示均安装了摄像头
        //那么它们的父节点（当前节点）已被监控，直接返回状态2
        if (left == 3 && right == 3) {
            return 2;
        }
        /*
        上一个判断条件排除了3+3的情况;
        如果左子结点、右子节点的状态分别为3和2(顺序不定)，
        说明左子结点和右子节点中有一个安装了摄像头，
        有一个已被监控（未安装摄像头），因此它们的父节点（当前节点）已被监控，直接返回状态2
         */
        if (left + right == 5) {
            return 2;
        }
        //如果左子结点、右子节点的状态都是已被监控（未安装摄像头）
        //那么它们的父节点（当前节点）的状态为未被监控，直接返回状态1
        if (left == 2 && right == 2) {
            return 1;
        }
        //否则(包含左子结点和右子节点至少一个未被监控的情况)，当前节点需要安装摄像头，计数器+1，返回状态3
        else {
            cnt++;
            return 3;
        }
    }
}
