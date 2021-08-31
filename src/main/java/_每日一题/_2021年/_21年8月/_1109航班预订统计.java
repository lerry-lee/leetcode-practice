package _每日一题._2021年._21年8月;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/31
 */
public class _1109航班预订统计 {
    /**
     * 解法1：暴力 时间O(N^2) 空间(N)
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //特判
        if (bookings == null || bookings.length == 0) return new int[]{};
        int[] res = new int[n];
        for (int[] booking : bookings) {
            int from = booking[0], to = booking[1], val = booking[2];
            for (int i = from; i <= to; i++) {
                res[i - 1] += val;
            }
        }
        return res;
    }

    /**
     * 解法2：差分 时间O(N) 空间(N)
     */
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        //特判
        if (bookings == null || bookings.length == 0) return new int[]{};
        //差分数组，dif[i]表示第i个航班和第i-1个航班的差值
        //差分数组的前缀和即为答案
        int[] dif = new int[n];
        for (int[] booking : bookings) {
            int fromi = booking[0] - 1, toi = booking[1], val = booking[2];
            dif[fromi] += val;
            if (toi < n) dif[toi] -= val;
        }
        for (int i = 1; i < n; i++) {
            dif[i] += dif[i - 1];
        }
        return dif;
    }
}
