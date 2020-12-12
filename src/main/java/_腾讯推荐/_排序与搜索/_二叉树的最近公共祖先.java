package _腾讯推荐._排序与搜索;

import _数据结构.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lerry_li on 2020/10/26
 */
public class _二叉树的最近公共祖先 {
    /**
     * 解法1：递归
     * 只要判断一个节点的左子树里有p，右子树里有q，那么当前节点就是最近公共祖先
     * 可以参考画图理解
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }

    /**
     * 解法2：哈希表存父节点
     */

    Map<TreeNode, TreeNode> hashMap;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == root || q == root) return root;
        if (p == q) return p;
        hashMap = new HashMap<>();
        Set<TreeNode> hashSet = new HashSet<>();
        dfs(root);
        while (p != root) {
            hashSet.add(p);
            p = hashMap.get(p);
        }
        while (q != root) {
            if (hashSet.contains(q)) {
                return q;
            }
            q = hashMap.get(q);
        }
        return root;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            hashMap.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            hashMap.put(root.right, root);
            dfs(root.right);
        }
    }
}
