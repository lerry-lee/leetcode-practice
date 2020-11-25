package DailyProblem._20年9月;

/**
 * Created by lerry_li on 2020/09/27
 */

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class _235二叉搜索树的最近公共祖先 {
    /**
     * 解法1：由先序遍历和中序遍历确定
     * 先序遍历可以确定最上层的根节点
     * 中序遍历可以确定p和q是否在同一颗子树中，若不在，则返回根节点，若在则递归
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        dfs(root, p, q);
        int n = preList.size();
        int[] preOrder = new int[n];
        int[] inOrder = new int[n];
        for (int i = 0; i < n; i++) {
            preOrder[i] = preList.get(i);
            inOrder[i] = inList.get(i);
        }
        find(preOrder, 0, n - 1, inOrder, 0, n - 1, PVAL, QVAL);
        find(root, ROOTVAL);
        return NODE;
    }

    List<Integer> preList = new ArrayList<>();
    List<Integer> inList = new ArrayList<>();
    int ROOTVAL = 0;
    int PVAL = 0;
    int QVAL = 0;
    TreeNode NODE = null;

    public void find(int[] preOrder, int preS, int preE, int[] inOrder, int inS, int inE, int pVal, int qVal) {
        int rootVal = preOrder[preS];
        if (rootVal == pVal || rootVal == qVal) {
            ROOTVAL = rootVal;
            return;
        }
        int pIdx = inS, qIdx = inS, rootIdx = inS;
        for (int i = inS; i <= inE; i++) {
            if (inOrder[i] == rootVal) rootIdx = i;
            if (inOrder[i] == pVal) pIdx = i;
            if (inOrder[i] == qVal) qIdx = i;
        }
        if (qIdx < rootIdx && pIdx < rootIdx) {
            inE = rootIdx - 1;
            preS += 1;
            preE = preS + (inE - inS);
            find(preOrder, preS, preE, inOrder, inS, inE, pVal, qVal);
        } else if (qIdx > rootIdx && pIdx > rootIdx) {
            inS = rootIdx + 1;
            preS = preE - (inE - inS);
            find(preOrder, preS, preE, inOrder, inS, inE, pVal, qVal);
        } else ROOTVAL = rootVal;
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        if (root == p) PVAL = root.val;
        else if (root == q) QVAL = root.val;
        preList.add(root.val);
        dfs(root.left, p, q);
        inList.add(root.val);
        dfs(root.right, p, q);
    }

    public void find(TreeNode root, int val) {
        if (root == null) return;
        if (root.val == val) {
            NODE = root;
            return;
        }
        find(root.left, val);
        find(root.right, val);
    }

    /**
     * 解法2：利用二叉搜索树的性质
     * 利用二叉搜索树的特点，如果p、q的值都小于root，说明p q 肯定在root的左子树中；
     * 如果p q都大于root，说明肯定在root的右子树中;
     * 如果一个在左一个在右 则说明此时的root记为对应的最近公共祖先
     */
    public TreeNode m2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    /**
     * 解法3：哈希表 --> _字节跳动推荐._链表与树._二叉树的最近祖先.java
     */

    /**
     * 解法4：递归 --> _字节跳动推荐._链表与树._二叉树的最近祖先.java
     */
}
