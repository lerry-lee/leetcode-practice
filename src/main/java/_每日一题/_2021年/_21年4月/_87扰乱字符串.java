package _每日一题._2021年._21年4月;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName: _87扰乱字符串
 * @Author: lerry_li
 * @CreateDate: 2021/04/16
 * @Description
 */
public class _87扰乱字符串 {

    public static void main(String[] args) {
        _87扰乱字符串 instance = new _87扰乱字符串();
        System.out.println(instance.isScramble("great", "rgeat"));//true
        System.out.println(instance.isScramble("abcde", "caebd"));//false
    }

    HashMap<String, Boolean> memo = new HashMap<>();

    /**
     * 解法2：记忆化递归
     */
    public boolean isScramble(String s1, String s2) {
        // 长度不等，必定不能变换
        if (s1.length() != s2.length()) {
            return false;
        }
        // 长度相等，先特判下
        if (s1.equals(s2)) {
            return true;
        }
        // 看一下字符个数是否一致，不同直接return false
        int n = s1.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }

        // 相同的话，开始判断判断，满足一个就能 return true
        for (int i = 1; i < n; i++) {

            //是否重复计算过
            if (memo.containsKey(s1.substring(0, i))) {
                return memo.get(s1.substring(0, i));
            }

            // S1 -> T1，S2 -> T2
            // S1 -> T2，S2 -> T1
            boolean flag = (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
                    (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)));

            memo.put(s1.substring(0, i), flag);

            if (flag) {
                return true;
            }
        }
        return false;
    }

}
