package _每日一题._2021年._21年9月;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/11
 */
public class _983最低票价 {

    public static void main(String[] args) {
        _983最低票价 instance = new _983最低票价();
        int[] days = new int[]{1, 4, 6, 7, 8, 20};
        int[] costs = new int[]{7, 2, 15};
        //[1,4,6,7,8,20]
        //[7,2,15]
        System.out.println(instance.mincostTickets2(days, costs));
    }

    /**
     * 解法1：记忆化搜索
     */
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) return 0;
        Arrays.fill(memo, -1);
        for (int day : days) {
            daysSet.add(day);
        }
        return dp(1, costs);
    }

    private int dp(int i, int[] costs) {
        if (i > 365) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        //如果第i天在旅行计划里，那么需要考虑买1天的票/买7天的票/买30天的票
        if (daysSet.contains(i)) {
            memo[i] = Math.min(dp(i + 1, costs) + costs[0], Math.min(dp(i + 7, costs) + costs[1],
                    dp(i + 30, costs) + costs[2]));
        }
        //否则，当天不用买
        else {
            memo[i] = dp(i + 1, costs);
        }

        return memo[i];
    }

    Set<Integer> daysSet = new HashSet<>();
    int[] memo = new int[366];

    /**
     * 解法2：dp
     */
    public int mincostTickets2(int[] days, int[] costs) {
        if (days == null || days.length == 0) return 0;
        int minDay = days[0], maxDay = days[days.length - 1];
        //dp[i]表示从第天开始旅行，所需要的最小花费
        //最终求dp[minDay]
        int[] dp = new int[maxDay + 31];
        //记录days下标
        int dayI = days.length - 2;
        //状态转移，从后往前
        for (int i = maxDay - 1; i >= minDay; i--) {
            //判断当天需要买票吗，有可能当天不在旅行计划里
            if (days[dayI] != i) {
                dp[i] = dp[i + 1];
            }
            //否则，选择买1天/7天/30天的票，选择花费最小的
            else {
                dp[i] = Math.min(dp[i + 1] + costs[0], Math.min(dp[i + 7] + costs[1], dp[i + 30] + costs[2]));
                //下标要移动
                dayI--;
            }
        }
        return dp[minDay];
    }
}
