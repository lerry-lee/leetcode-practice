package _力扣每日一题._20年9月;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/12 09:48
 * @description 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 */
public class _637二叉树的层平均值 {
    /**
     * 解法1：dfs递归
     */
    public List<Double> averageOfLevels_dfs(TreeNode root) {
        List<Double> res=new ArrayList<>();
        if(root==null) return res;
        List<List<Integer>> level_list =new ArrayList<>();
        dfs(level_list,root,0);
        for(int i = 0; i< level_list.size(); i++){
            List<Integer> level_row= level_list.get(i);
            long sum=0;
            for(int j=0;j<level_row.size();j++){
                sum+=level_row.get(j);
            }
            res.add(sum*1.0/level_row.size());
        }
        return res;
    }
    public void dfs(List<List<Integer>> levels,TreeNode root,int level) {
        if (level >= levels.size()) {
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(root.val);
        if (root.left != null) dfs(levels, root.left, level + 1);
        if (root.right != null) dfs(levels, root.right, level + 1);
    }
    /**
     * 解法2：bfs迭代
     * 数据结构：双端队列deque(双向链表likedlist实现)
     */
    public List<Double> averageOfLevels_bfs(TreeNode root) {
        List<Double> res=new ArrayList<>();
        if(root==null) return res;
        Deque<TreeNode> dequeue=new LinkedList<>();
        dequeue.addLast(root);
        while(!dequeue.isEmpty()){
            long sum=0,n=dequeue.size();
            for(int i=0;i<n;i++){
                TreeNode node=dequeue.pollFirst();
                sum+=node.val;
                if(node.left!=null) dequeue.offerLast(node.left);
                if(node.right!=null) dequeue.offerLast(node.right);
            }
            res.add(sum*1.0/n);
        }
        return res;
    }
}
