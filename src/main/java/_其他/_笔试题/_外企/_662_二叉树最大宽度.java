package _其他._笔试题._外企;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/23
 */
public class _662_二叉树最大宽度 {
    /**
     * 解法1：层次遍历+节点索引号标记
     * 这道题只要求某层的最大宽度，跟节点值无关，因此可以直接使用节点的索引号，而且所有null节点也算，
     *              1
     *             2 3
     *           4 5 6 7
     *    如上二叉树，去掉任意中间节点，不影响此树的最大宽度，观察索引号，可得如下规律：
     *    假设根节点的索引号为index，则左子结点=index*2，右子节点=index*2+1
     *    最终只需用每一层的最后一个节点（最右节点）的索引号-第一个节点（最左节点）的索引号即可
     */
    int res=0;
    List<List<Integer>> w=new ArrayList();
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root,0,1);
        for(List<Integer> b:w) res=Math.max(res,b.get(b.size()-1)-b.get(0));
        return res+1;
    }
    public void dfs(TreeNode root, int level, int index){
        if(root==null) return;
        if(w.size()==level){
            w.add(new ArrayList());
        }
        w.get(level).add(index);
        if(root.left!=null) dfs(root.left,level+1,index*2);
        if(root.right!=null) dfs(root.right,level+1,index*2+1);
    }
}
