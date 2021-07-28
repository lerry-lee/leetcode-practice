package _每日一题._2021年._21年7月;

import _数据结构.TreeNode;

import java.util.*;

/**
 * @ClassName: _863二叉树中所有距离为K的结点
 * @Author: lerry_li
 * @CreateDate: 2021/07/28
 * @Description
 */
public class _863二叉树中所有距离为K的结点 {
    /**
     * 树转图+bfs
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //特判
        if (root == null || target == null) return new ArrayList<>();
        if (k == 0) return Collections.singletonList(target.val);
        //树转有向图
        hashMap = new HashMap<>();
        dfs(null, root);
        Set<TreeNode> visited = new HashSet<>();
        //bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                for (TreeNode nb : hashMap.get(cur)) {
                    if (!visited.contains(nb)) {
                        queue.offer(nb);
                        visited.add(nb);
                    }
                }
            }
            distance++;
            if (distance == k) break;
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll().val);
        }
        return res;
    }

    private void dfs(TreeNode root, TreeNode cur) {
        if (cur == null) return;
        List<TreeNode> adj = hashMap.getOrDefault(cur, new ArrayList<>());
        if (root != null) adj.add(root);
        if (cur.left != null) adj.add(cur.left);
        if (cur.right != null) adj.add(cur.right);
        hashMap.put(cur, adj);
        dfs(cur, cur.left);
        dfs(cur, cur.right);
    }

    Map<TreeNode, List<TreeNode>> hashMap;
}
