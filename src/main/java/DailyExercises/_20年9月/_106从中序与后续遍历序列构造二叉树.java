package DailyExercises._20年9月;

/**
 * Created by lerry_li on 2020/09/25
 */

import DataStructure.TreeNode;

/**
 *  从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class _106从中序与后续遍历序列构造二叉树 {
    /**
     * 解法1：递归
     * 后序遍历可以确定根节点，然后根据根节点在中序遍历数组里面找到其左子树、右子树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||inorder.length==0||postorder==null||postorder.length==0) return null;
        return dfs(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode dfs(int[] inorder,int s1,int e1,int[] postorder,int s2,int e2){
        if(s1>e1) return null;
        if(s1==e1) return new TreeNode(inorder[s1]);

        int rootVal=postorder[e2];
        TreeNode root=new TreeNode(rootVal);
        int rootIdx=s1;

        for (int i = s1; i <=e1; i++) {
            if(inorder[i]==rootVal){
                rootIdx=i;
                break;
            }
        }
        int left_e1=rootIdx-1;
        int left_e2=s2+left_e1-s1;
        root.left=dfs(inorder,s1,left_e1,postorder,s2,left_e2);
        int right_s1=rootIdx+1;
        int right_e2=e2-1;
        int right_s2=right_e2-(e1-right_s1);
        root.right=dfs(inorder,right_s1,e1,postorder,right_s2,right_e2);
        return root;
    }
}
