package _每日一题._2020年._20年12月;

import java.util.*;

/**
 * @ClassName: _387字符串中的第一个唯一字符
 * @Author: lerry_li
 * @CreateDate: 2020/12/23
 * @Description
 */
public class _387字符串中的第一个唯一字符 {
    /**
     * 解法1：借助辅助计数数组去掉重复的字符，然后遍历字符串输出第一个字符 时间O(N)（加上字符串操作的时间复杂度） 空间O(C)
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] helper = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            helper[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (helper[i] > 1) {
                s = s.replace((char) (i + 'a'), ' ');
            }
        }
//        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                return i;
            }
        }
        return -1;
    }

    /**
     * 解法2：遍历一遍字符串使用计数数组计数，然后第二次遍历输出计数为1的第一个字符，时间O(N) 空间O(N)
     */
    public int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] helper = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            helper[idx]++;
        }
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (helper[idx] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _387字符串中的第一个唯一字符 instance = new _387字符串中的第一个唯一字符();
        while (true) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            System.out.println(instance.firstUniqChar2(s));
        }
    }
}
