package _每日一题._2022年._5月2日;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _670_最大交换 {

    /**
     * 解法1：贪心
     */
    class Solution {

        public int maximumSwap(int num) {
            String s = String.valueOf(num);
            int len = s.length();
            char[] charArray = s.toCharArray();

            // 记录每个数字出现的最后一次出现的下标
            int[] last = new int[10];
            for (int i = 0; i < len; i++) {
                last[charArray[i] - '0'] = i;
            }

            // 从左向右扫描，找到当前位置右边的最大的数字并交换
            for (int i = 0; i < len - 1; i++) {
                // 找最大，所以倒着找
                for (int d = 9; d > charArray[i] - '0'; d--) {
                    if (last[d] > i) {
                        swap(charArray, i, last[d]);
                        // 只允许交换一次，因此直接返回
                        return Integer.parseInt(new String(charArray));
                    }
                }
            }
            return num;
        }

        private void swap(char[] charArray, int index1, int index2) {
            char temp = charArray[index1];
            charArray[index1] = charArray[index2];
            charArray[index2] = temp;
        }
    }
}
