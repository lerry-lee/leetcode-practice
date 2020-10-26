package _字节跳动推荐._链表与树;

import _数据结构.TreeNode;

import java.util.HashMap;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/17 21:20
 * @description 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class _二叉树的最近公共祖先 {
    /**
     * 递归：
     * 只要判断一个节点的左子树里有p，右子树里有q，那么当前节点就是最近公共祖先
     * 可以参考画图理解
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==null||q==null) return null;
        if(root==p) return p;
        if(root==q) return q;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }



    /**
     * 哈希表：时间复杂度O（n） 空间复杂度O（n）
     * 建立(当前节点：父节点)的哈希表parent，(当前节点：是否访问)的哈希表visited
     * 遍历p的父节点，设置visited为true
     * 遍历q的父节点，如果visited为true，返回该节点（为最近公共祖先节点）
     */
    //建立父节点哈希表，存储每个节点的父节点
    HashMap<Integer, TreeNode> parentMap = new HashMap<>();
    HashMap<Integer, Boolean> nodeVisited = new HashMap<>();

    public TreeNode lowestCommonAncestor_hash(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p != root) {
            nodeVisited.replace(p.val, true);
            p = parentMap.get(p.val);
        }

        while (q != root) {
            if (nodeVisited.get(q.val)) {
                break;
            }
            q = parentMap.get(q.val);
        }

        return q;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            parentMap.put(node.left.val, node);
            dfs(node.left);
        }
        if (node.right != null) {
            parentMap.put(node.right.val, node);
            dfs(node.right);
        }
        nodeVisited.put(node.val, false);
    }

}
