package SwordFingerOffer;

import DataStructure.CommonMethod;
import DataStructure.TreeNode;

/**
 * @ClassName: _07重建二叉树
 * @Signature: Created by lerry_li on 2020/11/17
 * @Description:
 */
public class _07重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = inStart;
        for (; rootIdx <= inEnd; rootIdx++) {
            if (inorder[rootIdx] == rootVal) {
                break;
            }
        }
        //中序遍历根节点的左子树
        int left_inStart = inStart, left_inEnd = rootIdx - 1;
        //中序遍历根节点的右子树
        int right_inStart = rootIdx + 1, right_inEnd = inEnd;
        //前序遍历根节点的左子树
        int left_preStart = preStart + 1, left_preEnd = left_preStart + (left_inEnd - left_inStart);
        //前序遍历根节点的右子树
        int right_preStart = left_preEnd + 1, right_preEnd = preEnd;

//        System.out.println("当前根节点：" + rootVal);

        if (left_preStart <= left_preEnd) {
//            System.out.println("递归生成" + rootVal + "的左子树");
//            System.out.println("preorder:");
//            CommonMethod.display(preorder, left_preStart, left_preEnd);
//            System.out.println("inorder:");
//            CommonMethod.display(inorder, left_inStart, left_inEnd);
            root.left = dfs(preorder, left_preStart, left_preEnd, inorder, left_inStart, left_inEnd);
        }
        if (right_preStart <= right_preEnd) {
//            System.out.println("递归生成" + rootVal + "的右子树");
//            System.out.println("preorder:");
//            CommonMethod.display(preorder, right_preStart, right_preEnd);
//            System.out.println("inorder:");
//            CommonMethod.display(inorder, right_inStart, right_inEnd);
            root.right = dfs(preorder, right_preStart, right_preEnd, inorder, right_inStart, right_inEnd);
        }

        return root;
    }

    public static void main(String[] args) {
        _07重建二叉树 instance = new _07重建二叉树();
        int[] preorder = {5, 1, 2, 4, 3};
        int[] inorder = {1, 2, 3, 4, 5};
        TreeNode root = instance.buildTree(preorder, inorder);
        CommonMethod.display(root, "preorder");
        CommonMethod.display(root, "inorder");
    }
}
