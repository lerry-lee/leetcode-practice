package _剑指Offer;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _27二叉树的镜像
 * @Author: lerry_li
 * @CreateDate: 2021/03/02
 * @Description
 */
public class _27二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //0.
        dfs(root);

        //1.使用迭代方法层次遍历
        List<List<Integer>> nodesValues = new ArrayList<>();
        int level = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            nodesValues.add(new ArrayList<>());
            List<Integer> cur = nodesValues.get(level);
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                //逆序
                cur.add(0, node.val);
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
                if (node.left != null) {
                    deque.offerLast(node.right);
                }
            }
            level++;
        }

//        System.out.println(nodesValues);

        //2.使用递归方法重新赋值结点的值
        dfs(root, nodesValues, 0);

        dfs2(root);

        return root;
    }

    public void dfs(TreeNode root, List<List<Integer>> nodesValues, int level) {
        if (root == null) {
            return;
        }
        List<Integer> cur = nodesValues.get(level);
//        if (cur.get(0) == 123) {
//            root = null;
//            return;
//        }
        root.val = cur.get(0);
        cur.remove(0);
        dfs(root.left, nodesValues, level + 1);
        dfs(root.right, nodesValues, level + 1);
    }

    public void dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left == null) {
            root.left = new TreeNode(123);
        } else {
            dfs(root.left);
        }
        if (root.right == null) {
            root.right = new TreeNode(123);
        } else {
            dfs(root.right);
        }

    }

    public void dfs2(TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.val == 123) {
                root.left = null;
            }else{
                dfs(root.left);
            }
        }
        if (root.right != null) {
            if (root.right.val == 123) {
                root.right = null;
            }else{
                dfs(root.right);
            }
        }
    }
}
