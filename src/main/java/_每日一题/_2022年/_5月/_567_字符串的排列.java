package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 * @Description
 */
public class _567_字符串的排列 {
    /**
     * 解法1：滑动窗口+计数数组 时间O(N) 空间O(S)
     */
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            //特判
            if (s1 == null || s2 == null) return false;
            if (s1.length() == 0) return true;
            if (s2.length() == 0) return false;
            if(s2.length()<s1.length()) return false;
            //统计s1频次
            int len1 = s1.length();
            int[] freq1 = new int[26];
            for (char c : s1.toCharArray()) {
                freq1[c - 'a']++;
            }
            //滑动窗口[l,r]
            char[] arr = s2.toCharArray();
            int len2 = arr.length;
            int[] freq2 = new int[26];
            for (int i = 0; i < len1; i++) {
                freq2[arr[i] - 'a']++;
            }
            if (check(freq1, freq2)) return true;
            for (int i = len1; i < len2; i++) {
                freq2[arr[i] - 'a']++;
                freq2[arr[i - len1] - 'a']--;
                if (check(freq1, freq2)) return true;
            }
            return false;
        }

        private boolean check(int[] freq1, int[] freq2) {
            for (int i = 0; i < 26; i++) {
                if (freq1[i] != freq2[i]) return false;
            }
            return true;
        }
    }
}
