package _每日一题._2021年._21年3月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _131分割回文串
 * @Author: lerry_li
 * @CreateDate: 2021/03/07
 * @Description
 */
public class _131分割回文串 {
    /**
     * 暴力回溯
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        dfs(res, new ArrayList<>(), s, 0);
        return res;
    }

    public void dfs(List<List<String>> res, List<String> cur, String s, int t) {
        if (t >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = t; i < s.length(); i++) {
            if (!check(s, t, i)) {
                continue;
            }
            cur.add(s.substring(t, i + 1));
            dfs(res, cur, s, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public boolean check(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    /**
     * 解法2：中心扩展预处理+回溯
     */
    public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        //1.使用中心扩展法预处理所有回文串
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < 2 * len; i++) {
            int l, r;
            if (i % 2 == 0) {
                l = i / 2 - 1;
                r = i / 2 + 1;
            } else {
                l = i / 2;
                r = i / 2 + 1;
            }
            while (l >= 0 && r < len) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                dp[l][r]=true;
                l--;
                r++;
            }
        }
        //递归回溯
        dfs1(res, dp, new ArrayList<>(), s, 0);
        return res;
    }

    public void dfs1(List<List<String>> res, boolean[][] dp, List<String> cur, String s, int t) {
        if (t >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = t; i < s.length(); i++) {
            if (i > t && !dp[t][i]) {
                continue;
            }
            cur.add(s.substring(t, i + 1));
            dfs1(res,dp, cur, s, i + 1);
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args) {
        _131分割回文串 instance=new _131分割回文串();
        System.out.println(instance.partition2("abbab"));
    }
}
