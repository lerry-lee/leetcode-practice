package DailyProblem._20年7月;

import DataStructure.TreeNode;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/01 22:02
 * @description 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class _105从前序与中序遍历序列构造二叉树 {
    /**
     * 思路1：递归法
     * 1.从【先序遍历数组】找root根节点（第一个节点）
     * 2.在【中序遍历数组】中找到root根节点对应的下标，
     * (1)将根节点左侧的数组和其长度拿出来（左子树的中序遍历数组），右侧的数组及其长度拿出来（右子树的中序遍历数组）
     * (2)根据【中序遍历左右子树数组】的长度可以划分出【先序遍历数组】的左右子树的子数组
     * 3.然后递归求解
     * (1)recursive(先序遍历的左子树数组，中序遍历的左子树数组)
     * (2)recursive(先序遍历的左子树数组，中序遍历的左子树数组)
     * 4.重复123步骤，直到数组中只有一个元素，直接返回该元素的节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        if (pre_start == pre_end) return new TreeNode(preorder[pre_start]);
        TreeNode head = new TreeNode(preorder[pre_start]);
        int rootIdx = in_start;
        for (int i = in_start; i <= in_end; i++) {
            if (preorder[pre_start] == inorder[i]) {
                rootIdx = i;
                break;
            }
        }
        int left_start_idx = pre_start + 1;
        int left_end_idx = left_start_idx + rootIdx - in_start - 1;
        int right_start_idx = left_end_idx + 1;
        int right_end_idx = pre_end;
        if (left_end_idx >= left_start_idx)
            head.left = helper(preorder, left_start_idx, left_end_idx, inorder, in_start, rootIdx - 1);
        if (right_end_idx >= right_start_idx)
            head.right = helper(preorder, right_start_idx, right_end_idx, inorder, rootIdx + 1, in_end);
        return head;
    }
}
