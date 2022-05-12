package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _剑指Offer_67_把字符串转换成整数 {
    /**
     * 解法1：直接模拟 时间O(N) 空间O(1)
     */
    class Solution {
        public int strToInt(String str) {
            //特判
            if (str == null || str.length() == 0) return 0;
            //是否有正负号
            boolean hasSign = false;
            int sign = 1;
            //是否便利过数字
            boolean hasNum = false;
            //转化成数组
            char[] arr = str.toCharArray();
            //去掉开头结尾的连续空格
            int l = 0, r = arr.length - 1;
            while (l <= r) {
                if (arr[l] == ' ') {
                    l++;
                } else {
                    break;
                }
            }
            while (l <= r) {
                if (arr[r] == ' ') {
                    r--;
                } else {
                    break;
                }
            }
            long res = 0;
            //遍历
            for (int i = l; i <= r; i++) {
                //为数字
                if (Character.isDigit(arr[i])) {
                    res = res * 10 + (arr[i] - '0');
                    if (sign == 1 && res > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if (sign == -1 && -res < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                    hasNum = true;
                }
                //为正负号
                else if (arr[i] == '+' || arr[i] == '-') {
                    if (hasNum || hasSign) break;
                    sign = arr[i] == '+' ? 1 : -1;
                    hasSign = true;
                }
                //否则，为字母
                else {
                    //如果已有数字，break，否则return 0
                    if (hasNum) break;
                    else return 0;
                }
            }
            return (int) (sign * res);
        }
    }
}
