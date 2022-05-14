package _每日一题._2022年._5月;

import java.util.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/14
 * @Description
 */
public class _剑指Offer38_字符串的排列 {

    public static void main(String[] args) {
        _剑指Offer38_字符串的排列 instance = new _剑指Offer38_字符串的排列();
        System.out.println(Arrays.toString(instance.new Solution2().permutation("abcb")));
    }

    /**
     * 解法1：回溯(swap)+哈希表去重
     */
    class Solution {
        List<String> res;

        public String[] permutation(String s) {
            if (s == null || s.length() == 0) return new String[]{};
            res = new ArrayList<>();
            char[] arr = s.toCharArray();
            dfs(arr, 0);
            return res.toArray(new String[0]);
        }

        private void dfs(char[] arr, int t) {
            if (t == arr.length) {
                res.add(new String(arr));
                return;
            }
            Set<Character> visited = new HashSet<>();
            for (int i = t; i < arr.length; i++) {
                if (visited.contains(arr[i])) continue;
                visited.add(arr[i]);
                swap(arr, t, i);
                dfs(arr, t + 1);
                swap(arr, t, i);
            }
        }

        private void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    /**
     * 解法2：排序+回溯(visited)
     * 【注意】：去重的判断条件非常细节！
     *      if (visited[i] || (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])) continue;
     *      两种情况：
     *      1. 当前元素已经被访问过，即visited[i]==true，跳过；
     *      2. 当前元素未被访问，当前元素和前一个元素相同，即arr[i] == arr[i - 1]，并且前一个元素未被访问，跳过；
     *
     */
    class Solution2 {
        List<String> res;
        boolean[] visited;
        StringBuilder sb;

        public String[] permutation(String s) {
            if (s == null || s.length() == 0) return new String[]{};
            res = new ArrayList<>();
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            visited = new boolean[arr.length];
            sb = new StringBuilder();
            dfs(arr);
            return res.toArray(new String[0]);
        }

        private void dfs(char[] arr) {
            if (sb.length() == arr.length) {
                res.add(new String(sb));
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                if (visited[i] || (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])) continue;
                visited[i] = true;
                sb.append(arr[i]);
                dfs(arr);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
}
