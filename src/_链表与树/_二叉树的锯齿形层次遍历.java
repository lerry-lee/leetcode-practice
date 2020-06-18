package _链表与树;

import java.util.*;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/17 21:46
 * @description TODO
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class _二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode temp = deque.peekFirst();
            if (temp.left != null) {
                deque.addLast(temp.left);
            }
            if (temp.right != null) {
                deque.addLast(temp.right);
            }
            System.out.print(temp.val + " ");
            deque.removeFirst();
        }
        System.out.println();
        return null;
    }

    List<List<Integer>> lists;

    public void m2(TreeNode root) {
        lists = new ArrayList<>();
        getLevelOrder(root, 0);
        System.out.println(lists);
    }

    public void getLevelOrder(TreeNode node, int level) {
        if (node == null) return;
        if (lists.size()<=level){
            lists.add(new ArrayList<>());
        }
        if(level%2==0) lists.get(level).add(node.val);
        else lists.get(level).add(0,node.val);

        getLevelOrder(node.left,level+1);
        getLevelOrder(node.right,level+1);
    }
}
