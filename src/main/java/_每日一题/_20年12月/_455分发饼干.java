package _每日一题._20年12月;

import java.util.Arrays;

/**
 * @ClassName: _455分发饼干
 * @Author: lerry_li
 * @CreateTime: 2020/12/30
 * @Description
 */
public class _455分发饼干 {
    /**
     * 解法1：排序 时间O(NlogN) 空间O(1)
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;

        for (int i = s.length - 1, j = g.length - 1; i >= 0; i--) {
            for (int k = j; k >= 0; k--) {
                if (s[i] >= g[k]) {
                    res++;
                    j = k - 1;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        _455分发饼干 instance = new _455分发饼干();
        int[] g = {1, 2, 3};
        int[] s = {1, 2,2};
        System.out.println(instance.findContentChildren(g, s));
    }
}
