package _每日一题._2021年._21年2月;

/**
 * @ClassName: _1208尽可能使字符串相等
 * @Author: lerry_li
 * @CreateTime: 2021/02/05
 * @Description
 */
public class _1208尽可能使字符串相等 {
    /**
     * 解法1：先求每个对应下标的字符的ascii码的差值，然后用滑动窗口解 时间O(N) 空间O(N)
     */
    public int equalSubstring(String s, String t, int maxCost) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dif = new int[len];
        for (int i = 0; i < len; i++) {
            dif[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0, right = 0;
        int cost = 0;

        while (right < len) {
            cost += dif[right];
            if (cost > maxCost) {
                cost -= dif[left];
                left++;
            }
            right++;
        }
        return right - left;
    }

    public static void main(String[] args) {
        _1208尽可能使字符串相等 instance = new _1208尽可能使字符串相等();
        System.out.println(instance.equalSubstring("abcd", "bcdf", 3));
        System.out.println(instance.equalSubstring("abcd", "cdef", 3));
        System.out.println(instance.equalSubstring("abcd", "acde", 0));
        System.out.println(instance.equalSubstring("krrgw", "zjxss", 19));
        System.out.println(instance.equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14));
    }
}
