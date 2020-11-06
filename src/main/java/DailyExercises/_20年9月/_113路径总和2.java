package DailyExercises._20年9月;

/**
 * Created by lerry_li on 2020/09/26
 */

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class _113路径总和2 {
    /**
     * 解法1：深度优先遍历 回溯法
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths=new ArrayList<>();
        if(root==null) return paths;
        dfs(paths,new ArrayList<>(),root,sum);
        return paths;
    }
    public void dfs(List<List<Integer>> paths, List<Integer> path, TreeNode root, int target){
        if(root.left==null&&root.right==null){
            if(target==root.val) {
                path.add(root.val);
                paths.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(root.val);
        target-=root.val;
        if(root.left!=null) dfs(paths,path,root.left,target);
        if(root.right!=null) dfs(paths,path,root.right,target);
        path.remove(path.size()-1);
    }
}
