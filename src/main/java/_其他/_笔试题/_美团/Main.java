package _其他._笔试题._美团;

/**
 * @ClassName: Main
 * @Author: lerry_li
 * @CreateDate: 2021/08/08
 * @Description
7 2 1
2 3
4 5
6 7
0 0
0 0
0 0
0 0
1 1
 */

import java.util.*;

class TreeNode {
    public int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {

    static HashMap<Integer, int[]> childVals;
    static HashMap<Integer, TreeNode> val2node;
    static List<Integer> res;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        TreeNode root = new TreeNode(k);
        childVals = new HashMap<>();
        val2node=new HashMap<>();
        val2node.put(k,root);
        for (int i = 1; i <= n; i++) {
            childVals.put(i, new int[]{sc.nextInt(), sc.nextInt()});
        }
        buildNode(root);
        for (int i = 1; i <= m; i++) {
            reverseChildNodes(val2node.get(sc.nextInt()));
        }
        res=new ArrayList<>();
        dfs(root);
        for (int i = 0; i < res.size(); i++) {
            if(i==0) System.out.print(res.get(i));
            else System.out.print(" "+res.get(i));
        }
    }

    private static void reverseChildNodes(TreeNode node) {
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
    }

    private static void buildNode(TreeNode root) {
        int[] childs=childVals.get(root.val);
        if(childs[0]!=0) {
            root.left = new TreeNode(childs[0]);
            val2node.put(childs[0],root.left);
            buildNode(root.left);
        }
        if(childs[1]!=0) {
            root.right = new TreeNode(childs[1]);
            val2node.put(childs[0],root.right);
            buildNode(root.right);
        }
    }

    private static void dfs(TreeNode root) {
        if(root==null) return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }

    private static int func4(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        int m = nums.length / 2;
        int dif = 0;
        while (true) {
            for (int i = 0; i < m; i++) {
                if (nums[i] == nums[m + i]) continue;
                if (freq.get(nums[i]) > freq.get(nums[m + i])) {
                    freq.put(nums[m + i], freq.get(nums[m + i]) + freq.get(nums[i]));
                    dif += freq.get(nums[i]);
                    freq.remove(nums[i]);
                } else {
                    freq.put(nums[i], freq.get(nums[m + i]) + freq.get(nums[i]));
                    dif += freq.get(nums[m + i]);
                    freq.remove(nums[m + i]);
                }
            }
        }

    }


    public static void test2() {
        Scanner sc = new Scanner(System.in);//a iC C   C GmyyyySp p
        String str = sc.nextLine();
        System.out.println(func2(str));
    }

    private static String func2(String str) {
        if (str == null || str.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        char prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == prev || arr[i] == ' ') continue;
            if (prev != ' ') sb.append(prev);
            prev = arr[i];
        }
        sb.append(prev);
        return sb.toString();
    }
}
