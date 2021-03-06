package _字节推荐._数组与排序;

import java.util.ArrayList;
import java.util.List;

/**
 * 第K个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 */
public class _第K个排列 {

    /**
     * 解法：dfs+剪枝：时间复杂度O（n^2） 空间复杂度O（n）
     * 有图解参考
     */
    int[] factorial;
    String res;

    public String getPermutation(int n, int k) {
        factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) factorial[i] = i * factorial[i - 1];
        boolean[] visited = new boolean[n + 1];
        dfs(n, k, 0, visited, new ArrayList<>());
        return res;
    }

    public void dfs(int n, int k, int t, boolean[] visited, List<String> pai) {
        if (t >= n) {
            res = String.join("", pai);
            return;
        }
        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int x = factorial[n - 1 - t];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            if (x < k) {
                k -= x;
                continue;
            }
            pai.add(i + "");
            visited[i] = true;
            dfs(n, k, t + 1, visited, pai);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    /**
     * 求全排列的两种方式：1）交换法 2）bool法
     * 交换法的时间和空间复杂度比bool法略低一些，但得到的全排列顺序不是严格递增的
     */
    int count = 0;//计数：第几次排列
    int[] nums;
    List<Integer> pai = new ArrayList<>();

    //交换法：得到的顺序不是严格递增的
    public void backTrack(int t, int n, int k) {
        if (t > n) {
            count++;
            System.out.print("第" + count + "次排列：");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();

            if (count == k) {
                System.out.print("结果：");
                for (int num : nums) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = t; i <= n /*&& count < k*/; i++) {
            swap(nums, i, t);
            backTrack(t + 1, n, k);
            swap(nums, i, t);
        }
    }

    //bool判断法，时间复杂度比交换法高一些，但得到的序列是严格递增的
    public void backTrack_bool(int[] nums, int t, int n, int k, boolean[] bool) {
        if (t > n) {
            count++;

            if (count == k) {
                System.out.print("结果：");
                for (int num : nums) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = 0; i <= n && count < k; i++) {
            if (!bool[i]) {
                bool[i] = true;
                pai.add(nums[i]);
                backTrack_bool(nums, t + 1, n, k, bool);
                bool[i] = false;
                pai.remove(pai.size() - 1);
            }
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
