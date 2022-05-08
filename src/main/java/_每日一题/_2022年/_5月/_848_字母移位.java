package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/08
 * @Description
 */
public class _848_字母移位 {
    /**
     * 解法1：直接做
     */
    class Solution {
        public String shiftingLetters(String s, int[] shifts) {
            //特判
            if (s == null || s.length() == 0) return "";
            if (shifts == null || shifts.length == 0) return s;
            char[] arr = s.toCharArray();
            int cnt = 0;
            //倒着处理
            for (int i = shifts.length - 1; i >= 0; i--) {
                //当前需要移位的次数
                cnt = (cnt+shifts[i])%26;
                //移位后的字符
                int cur = arr[i] - 'a';
                int temp = (cur + cnt)%26;
                arr[i] = (char) (temp + 'a');
            }
            return new String(arr);
        }
    }
}
