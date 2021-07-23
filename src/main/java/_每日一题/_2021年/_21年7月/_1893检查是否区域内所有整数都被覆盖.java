package _每日一题._2021年._21年7月;

import java.util.Arrays;

/**
 * @ClassName: _1893检查是否区域内所有整数都被覆盖
 * @Author: lerry_li
 * @CreateDate: 2021/07/23
 * @Description
 */
public class _1893检查是否区域内所有整数都被覆盖 {

    public static void main(String[] args) {
        _1893检查是否区域内所有整数都被覆盖 instance = new _1893检查是否区域内所有整数都被覆盖();
        System.out.println(instance.isCovered(new int[][]{{1, 1}}, 1, 50));
        System.out.println(instance.isCovered(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5));
        System.out.println(instance.isCovered(new int[][]{{1, 10}, {10, 20}}, 21, 21));
    }

    /**
     * 解法1：暴力 时间O(N^2) 空间O(right-left)
     */
    public boolean isCovered2(int[][] ranges, int left, int right) {
        boolean[] sector = new boolean[right - left + 1];
        for (int[] range : ranges) {
            if (range[0] <= left && range[1] >= right) {
                return true;
            }
            if (range[0] >= left) {
                for (int i = range[0]; i <= range[1] && i <= right; i++) {
                    sector[i - left] = true;
                }
            } else if (range[1] <= right) {
                for (int i = range[1]; i >= left && i >= range[0]; i--) {
                    sector[i - left] = true;
                }
            }
        }
        for (boolean sec : sector) {
            if (!sec) return false;
        }
        return true;
    }

    /**
     * 解法2：排序+双指针
     */
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            else return Integer.compare(o1[0], o2[0]);
        });
        for (int[] range : ranges) {
            if (left >= range[0]&&left<=range[1]) {
                left = range[1]+1;
            };
        }
        return left>right;
    }

    /**
     * 解法3：差分数组 todo
     */
}
