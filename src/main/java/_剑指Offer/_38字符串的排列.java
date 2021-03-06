package _剑指Offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: _38字符串的排列
 * @Author: lerry_li
 * @CreateTime: 2021/03/06
 * @Description
 */
public class _38字符串的排列 {
    /**
     * 解法1：回溯+哈希表（swap）
     * 解法2：回溯+哈希表（bool）
     */
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[]{};
        }
        List<String> permutation = new ArrayList<>();
        char[] array = s.toCharArray();
        int len = array.length;
        boolean[] visited = new boolean[len];
        dfs_bool(new HashSet<>(), permutation, array, visited, new StringBuilder(), len);
//        dfs_swap(permutation, array, 0, len);
        System.out.println(permutation);
        String[] res = new String[permutation.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = permutation.get(i);
        }
        return res;
    }

    public void dfs_swap(List<String> permutation, char[] array, int t, int len) {
        if (t >= len) {
            permutation.add(new String(array));
            return;
        }
        Set<Character> hashSet = new HashSet<>();
        for (int i = t; i < len; i++) {
            if (hashSet.contains(array[i])) {
                continue;
            }
            hashSet.add(array[i]);
            swap(array, t, i);
            dfs_swap(permutation, array, t + 1, len);
            swap(array, t, i);
        }
    }

    public void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public void dfs_bool(Set<String> hashSet, List<String> permutation, char[] array, boolean[] visited,
                         StringBuilder sb, int len) {
        if (sb.length() == len) {
            if (!hashSet.contains(sb.toString())) {
                String cur = new String(sb);
                hashSet.add(cur);
                permutation.add(cur);
            }
            return;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            sb.append(array[i]);
            dfs_bool(hashSet, permutation, array, visited, sb, len);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        _38字符串的排列 instance = new _38字符串的排列();
        instance.permutation("abc");
        instance.permutation("aaa");
        instance.permutation("aab");

    }

}
