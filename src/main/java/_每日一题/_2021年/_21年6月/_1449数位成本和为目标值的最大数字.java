package _每日一题._2021年._21年6月;

import java.util.Arrays;

/**
 * @ClassName: _1449数位成本和为目标值的最大数字
 * @Author: lerry_li
 * @CreateDate: 2021/06/12
 * @Description
 * dp(完全背包问题)
 */
public class _1449数位成本和为目标值的最大数字 {

    public static void main(String[] args) {
        _1449数位成本和为目标值的最大数字 instance = new _1449数位成本和为目标值的最大数字();
        System.out.println(instance.largestNumber(new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5}, 9));//7772
        System.out.println(instance.largestNumber(new int[]{7, 6, 5, 5, 5, 6, 8, 7, 8}, 12));//85
        System.out.println(instance.largestNumber(new int[]{2, 4, 6, 2, 4, 6, 4, 4, 4}, 5));//0
        System.out.println(instance.largestNumber(new int[]{6, 10, 15, 40, 40, 40, 40, 40, 40}, 47));//32211
    }

    /**
     * 解法1：dp(完全背包问题) 时间O(n*target) 空间O(n*target)
     * 思路：
     *  该问题可以看作是恰好装满背包容量为target，物品重量为cost[i]，价值为1的完全背包问题
     */
    public String largestNumber1(int[] cost, int target) {
        //特判
        if (cost == null || cost.length == 0) return "0";
        //cost[i]看作物品重量，target为背包容量，物品价值均为1
        //dp[i][j]表示前i个物品装满容量为j的背包时的最大价值，目标是求dp[n][target]
        int n = cost.length;
        int[][] dp = new int[n + 1][target + 1];
        //由于背包必须装满，因此初始化dp[0][j]=-INF表示0个物品背包容量为j时无法装满，dp[0][0]=0表示0个物品背包容量为0时的最大价值为0
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        dp[0][0] = 0;
        //用一个数组记录背包选择的情况，由于组成的整数是按数组下标+1来的，因此优先考虑下标靠后的数
        //注意我们并没有记录转移来源是i还是i-1，这是因为若from[i][j]的值为j，则必定从i-1转移过来，否则必定从i转移过来。
        int[][] from = new int[n + 1][target + 1];
        //状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                //当背包容量为j时，当前物品(重量是wi)是装还是不装？
                int wi = cost[i - 1];
                //若j<wi，则当前物品不装
                if (j < wi) {
                    dp[i][j] = dp[i - 1][j];
                    //记录由谁转移而来
                    from[i][j] = j;
                }
                //否则，考虑当前物品是装还是不装，选最优
                //这里注意：由于每个物品的数量无限，因此即使选择装了当前物品，状态转移也是由dp[i]转
                else {
                    if (dp[i - 1][j] > dp[i][j - wi] + 1) {
                        dp[i][j] = dp[i - 1][j];
                        //记录由谁转移而来
                        from[i][j] = j;
                    } else {
                        dp[i][j] = dp[i][j - wi] + 1;
                        //记录由谁转移而来
                        from[i][j] = j - wi;
                    }
                }
            }
        }
        //最后如何构建最大价值表示的结果呢？
        //若dp[n][target]<0，则n个物品无法装满容量为target的背包，返回0
        if (dp[n][target] < 0) return "0";
        //结合from数组
        StringBuilder sb = new StringBuilder();
        //i从最后一个物品到第一个物品
        //j从背包容量target开始递减
        for (int i = n, j = target; i > 0; ) {
            //表示当前第i个物品不装，由i-1转移而来
            if (j == from[i][j]) i--;
                //否则表示装第i个物品
            else {
                sb.append(i);
                j = from[i][j];
            }
        }
        return sb.toString();
    }

    /**
     * 解法1：dp+空间优化 时间O(n*target) 空间O(target)
     * 上述代码有两处空间优化：
     * 1.其一是滚动数组优化。
     * 由于 dp[i+1][] 每个元素值的计算只与 dp[i-1][] 和 dp[i][] 的元素值有关，因此可以使用滚动数组的方式，去掉 dp 的第一个维度。
     * 2.其二是去掉 from 数组。
     * 在状态倒退时，直接根据dp[j]与dp[j−cost[i]]+1是否相等来判断，若二者相等则说明是从dp[j−cost[i]]转移而来，即选择了第i个数位。
     */
    public String largestNumber(int[] cost, int target) {
        //特判
        if (cost == null || cost.length == 0) return "0";
        //cost[i]看作物品重量，target为背包容量，物品价值均为1
        //dp[j]表示装满容量为j的背包时的最大价值，目标是求dp[target]
        int n = cost.length;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        int[][] from = new int[n + 1][target + 1];
        //状态转移
        for (int i = 1; i <= n; i++) {
            //当前物品的重量wi
            int wi = cost[i - 1];
            //当背包容量为j时，当前物品(重量是wi)是装还是不装？
            for (int j = wi; j <= target; j++) {
                dp[j] = Math.max(dp[j], dp[j - wi] + 1);
            }
        }
        //若dp[target]<0，则n个物品无法装满容量为target的背包，返回0
        if (dp[target] < 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = n, j = target; i > 0; i--) {
            for (int wi = cost[i - 1]; j >= wi && dp[j] == dp[j - wi]+1; j -= wi) sb.append(i);
        }
        return sb.toString();
    }

}
