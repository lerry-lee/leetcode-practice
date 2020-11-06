package DailyExercises._20年9月;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/06 10:11
 * @description 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class _107二叉树的层次便利2 {
    /**
     * 解法1：BFS广度优先遍历
     * 1）使用双端队列，从头部取出节点，从尾部加入新节点
     * 2）时间复杂度O（n） 空间复杂度O（n）
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> temp=new ArrayList<>();
        if(root==null) return temp;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.addLast(root);
        // temp.add(new ArrayList<>());
        // temp.get(0).add(root.val);
        while(!deque.isEmpty()){
            temp.add(new ArrayList<>());
            int nodeNum=deque.size();
            for(int i=0;i<nodeNum;i++){
                TreeNode node=deque.removeFirst();
                temp.get(temp.size()-1).add(node.val);
                if(node.left!=null) {deque.addLast(node.left);}
                if(node.right!=null){deque.addLast(node.right);}
            }

        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=temp.size()-1;i>=0;i--) res.add(temp.get(i));
        return res;
    }
    /**
     * 解法2：DFS深度优先遍历
     * 1）递归、
     * 2）list在对应层添加节点即可
     */
}
