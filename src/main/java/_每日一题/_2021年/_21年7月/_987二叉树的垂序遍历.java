package _每日一题._2021年._21年7月;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: _987二叉树的垂序遍历
 * @Author: lerry_li
 * @CreateDate: 2021/07/31
 * @Description
 */
public class _987二叉树的垂序遍历 {
    /**
     * 解法1：dfs+排序
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //特判
        if (root == null) return res;
        leftList = new ArrayList<>();
        rightList = new ArrayList<>();
        //假设root的坐标为(0,0)，递归标点
        dfs(root, 0, 0);
        int i = 0;
        for (List<int[]> leftCol : leftList) {
            leftCol.sort(((o1, o2) -> {
                if(o1[0]==o2[0]) return Integer.compare(o1[1],o2[1]);
                return Integer.compare(o1[0],o2[0]);
            }));
        }
        for (List<int[]> rightCol : rightList) {
            rightCol.sort(((o1, o2) -> {
                if(o1[0]==o2[0]) return Integer.compare(o1[1],o2[1]);
                return Integer.compare(o1[0],o2[0]);
            }));
        }
        for (int j = leftList.size() - 1; j >= 0; j--) {
            List<int[]> leftCol = leftList.get(j);
            res.add(new ArrayList<>());
            for(int[] point:leftCol){
                res.get(i).add(point[1]);
            }
            i++;
        }
        for (List<int[]> rightCol : rightList) {
            res.add(new ArrayList<>());
            for(int[] point:rightCol){
                res.get(i).add(point[1]);
            }
            i++;
        }
        return res;
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root == null) return;
        if (x >= 0) {
            int level = x;
            if (rightList.size() <= level) {
                rightList.add(new ArrayList<>());
            }
            rightList.get(level).add(new int[]{y, root.val});
        } else {
            int level = -x - 1;
            if (leftList.size() <= level) {
                leftList.add(new ArrayList<>());
            }
            leftList.get(level).add(new int[]{y, root.val});
        }
        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }

    List<List<int[]>> leftList;
    List<List<int[]>> rightList;
}
