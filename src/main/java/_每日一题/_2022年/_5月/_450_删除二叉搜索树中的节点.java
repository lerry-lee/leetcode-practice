package _每日一题._2022年._5月;

import _数据结构.TreeNode;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _450_删除二叉搜索树中的节点 {
    /**
     * 解法1：找节点、删除/移动（不能保证树平衡）
     * 思路：
     *      根据二叉搜索树的性质，递归搜索节点，找到当前节点后，然后根据其有没有子树，进行如下处理：
     *      1.有左右子树的情况：
     *          将左子树接到右子树的最左子节点上
     *      2.只有一个子树：
     *          将该子树提上来，空节点也算
     */
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            //key<当前节点值，去左子树里面找
            if(key < root.val){
                root.left = deleteNode(root.left, key);
            }
            //key>当前节点值，去右子树里面找
            else if(key > root.val) {
                root.right = deleteNode(root.right, key);
            }
            //key=当前节点值，删除当前节点
            else {
                //如果当前节点，左右子树都不为空
                if(root.left != null && root.right != null){
                    //找到右子树的最左子节点，因为它满足大于可以充当新的根节点的条件
                    TreeNode node=root.right;
                    while(node.left!=null){
                        node=node.left;
                    }
                    //把左子树接到找到的节点的左子树上
                    node.left=root.left;
                    root=root.right;
                }
                //否则，当前节点只有一个子树，直接移上来完事
                else if(root.left == null){
                    return root.right;
                }else {
                    return root.left;
                }
            }
            return root;
        }
    }

    /**
     * 解法2：找节点、删除（尽量保证树的初始平衡）
     */
    class Solution2 {
        /*
        One step right and then always left
        */
        public int successor(TreeNode root) {
            root = root.right;
            while (root.left != null) root = root.left;
            return root.val;
        }

        /*
        One step left and then always right
        */
        public int predecessor(TreeNode root) {
            root = root.left;
            while (root.right != null) root = root.right;
            return root.val;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;

            // 如果节点比根节点的值大，递归处理右子树
            if (key > root.val) root.right = deleteNode(root.right, key);
            // 如果节点比根节点的值小，递归处理左子树
            else if (key < root.val) root.left = deleteNode(root.left, key);
            // 否则，需要删除当前节点
            else {
                // 为叶子节点的话，直接删除
                if (root.left == null && root.right == null) root = null;
                // 有右子树的话，寻找右子树的最左节点，它的值可以作为新的根节点，然后递归处理右子树
                else if (root.right != null) {
                    root.val = successor(root);
                    root.right = deleteNode(root.right, root.val);
                }
                // 没有右子树的话，寻找左子树的最右节点，它的值可以作为新的根节点，然后递归处理左子树
                else {
                    root.val = predecessor(root);
                    root.left = deleteNode(root.left, root.val);
                }
            }
            return root;
        }
    }
}
