package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/15
 * @Description
 */
public class _剑指Offer17_打印从1到最大的n位数 {
    class Solution {
        public int[] printNumbers(int n) {
            if (n < 1) return new int[]{};
            int total = (int) (Math.pow(10, n) - 1);
            int[] res = new int[total];
            for (int i = 0; i < total; i++) {
                res[i] = i + 1;
            }
            return res;
        }
    }
}
