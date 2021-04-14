package _剑指Offer;

import java.util.Arrays;

/**
 * @ClassName: _33二叉搜索树的后序遍历序列
 * @Author: lerry_li
 * @CreateDate: 2021/04/14
 * @Description
 * 解法1：递归分治(借助中序遍历数组)
 * 解法2：递归分治
 * 解法3：单调栈？
 */
public class _33二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {
        _33二叉搜索树的后序遍历序列 instance = new _33二叉搜索树的后序遍历序列();
        System.out.println(instance.verifyPostorder2(new int[]{1, 6, 3, 2, 5}));
        System.out.println(instance.verifyPostorder2(new int[]{1, 3, 2, 6, 5}));
    }


    /**
     * 解法1：递归分治(借助中序遍历数组) 时间O(NlogN~N^2) 空间O(N)
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        int len = postorder.length;
        int[] inorder = new int[len];
        System.arraycopy(postorder, 0, inorder, 0, len);
        Arrays.sort(inorder);
        return check(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    //通过对比中序遍历和后序遍历，判断①根节点是否一致，②左子树是否合法，③右子树是否合法
    public boolean check(int[] inorder, int in_s, int in_e, int[] postorder, int post_s, int post_e) {
        int root = postorder[post_e];
        int root_idx = -1;
        for (int i = in_s; i <= in_e; i++) {
            if (inorder[i] == root) {
                root_idx = i;
                break;
            }
        }
        if (root_idx == -1) {
            return false;
        }
        //中序数组的左子树
        int in_left_s = in_s;
        int in_left_e = root_idx - 1;
        //中序数组的右子树
        int in_right_s = root_idx + 1;
        int in_right_e = in_e;
        //后续数组的左子树
        int post_left_s = post_s;
        int post_left_e = post_s + in_left_e - in_left_s;
        //后序数组的右子树
        int post_right_s = post_left_e + 1;
        int post_right_e = post_e - 1;

        //若root的左子树存在(超过1个)
        boolean left_flag = true;
        if (in_left_e >= in_left_s) {
            left_flag = check(inorder, in_left_s, in_left_e, postorder, post_left_s, post_left_e);
        }
        //若root的右子树存在(超过1个)
        boolean right_flag = true;
        if (in_right_e >= in_right_s) {
            right_flag = check(inorder, in_right_s, in_right_e, postorder, post_right_s, post_right_e);
        }
        return left_flag && right_flag;
    }


    /**
     * 解法2：递归分治 时间O(N^2) 空间O(N)
     * 思路：判断根节点是否合法+左子树是否合法+右子树是否合法
     * 【重点：对于二叉搜索树来说，根节点的值大于左子树的值，根节点的值小于右子树的值】
     * 【重点：后序遍历的末尾是根节点，其前面的元素是左子树和右子树，且左子树在前面，右子树在后面】
     */
    public boolean verifyPostorder2(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        int len = postorder.length;
        return check2(postorder, 0, len - 1);
    }

    private boolean check2(int[] postorder, int start, int end) {
        //只有1个元素时，返回true
        if (start >= end) {
            return true;
        }
        //root为数组最后一个元素，前面为左子树和右子树的元素
        int root = postorder[end];
        //找到第一个比root大的元素，即为右子树的开始
        int right = start;
        while (right < end && postorder[right] < root) {
            right++;
        }
        //右子树区间范围内的元素都要比root大
        int temp = right;
        while (temp < end) {
            if (postorder[temp] < root) {
                return false;
            }
            temp++;
        }
        //左子树范围为[start,right-1]，右子树范围为[right,end-1]
        //递归检查左子树、右子树
        return check2(postorder, start, right - 1) && check2(postorder, right, end - 1);
    }
}
