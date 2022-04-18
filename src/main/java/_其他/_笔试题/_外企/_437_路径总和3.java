package _其他._笔试题._外企;

import _数据结构.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/18
 * @Description
 */
public class _437_路径总和3 {
    /**
     * 解法1：直接递归
     */
    private int res=0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,false);
        return res;
    }
    public void dfs(TreeNode root,int targetSum,boolean hasRoot){
        if(root==null){
            return;
        }
        if(root.val==targetSum){
            res++;
        }
        if(!hasRoot){
            dfs(root.left,targetSum,false);
            dfs(root.right,targetSum,false);
        }
        dfs(root.left,targetSum-root.val,true);
        dfs(root.right,targetSum-root.val,true);

    }

    /**
     * 解法2：递归+前缀和
     */
    Map<Integer, Integer> map = new HashMap<>();
    int ans, t;
    public int pathSum2(TreeNode root, int _t) {
        if (root == null) return 0;
        t = _t;
        map.put(0, 1);
        dfs(root, root.val);
        return ans;
    }
    void dfs(TreeNode root, int val) {
        if (map.containsKey(val - t)) ans += map.get(val - t);
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (root.left != null) dfs(root.left, val + root.left.val);
        if (root.right != null) dfs(root.right, val + root.right.val);
        map.put(val, map.getOrDefault(val, 0) - 1);
    }
}
