package _每日一题._2021年._21年6月;

import java.util.*;

/**
 * @ClassName: _剑指Offer38字符串的排列
 * @Author: lerry_li
 * @CreateDate: 2021/06/26
 * @Description
 * 解法1：回溯dfs+hash表去重
 */
public class _剑指Offer38字符串的排列 {

    public static void main(String[] args) {
        _剑指Offer38字符串的排列 instance = new _剑指Offer38字符串的排列();
        System.out.println(Arrays.toString(instance.permutation("abc")));
        System.out.println(Arrays.toString(instance.permutation("abca")));
    }

    /**
     * 解法1：回溯dfs+hash表去重
     */
    public String[] permutation(String s) {
        //特判
        if (s == null || s.length() == 0) return new String[]{};
        char[] arr = s.toCharArray();
//        Arrays.sort(arr);
        listRes = new ArrayList<>();
        dfs(arr, 0);
        String[] res = new String[listRes.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = listRes.get(i);
        }
        return res;
    }

    List<String> listRes;

    private void dfs(char[] arr, int t) {
        if (t == arr.length) {
            listRes.add(new String(arr));
            return;
        }
        //使用hash表去重，打头的元素不能重复
        Set<Character> hashSet = new HashSet<>();
        for (int i = t; i < arr.length; i++) {
            //去重
//            if (i > t && arr[i] == arr[i-1]) continue;
            if (hashSet.contains(arr[i])) continue;
            hashSet.add(arr[i]);
            swap(arr, i, t);
            dfs(arr, t + 1);
            swap(arr, i, t);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
