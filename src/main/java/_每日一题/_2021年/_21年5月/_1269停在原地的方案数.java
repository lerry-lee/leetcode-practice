package _每日一题._2021年._21年5月;

import java.util.HashMap;

/**
 * @ClassName: _1269停在原地的方案数
 * @Author: lerry_li
 * @CreateDate: 2021/05/13
 * @Description
 * 解法1：记忆化递归
 * 解法2：动态规划
 */
public class _1269停在原地的方案数 {

    public static void main(String[] args) {
        _1269停在原地的方案数 instance = new _1269停在原地的方案数();
        System.out.println(instance.numWays(3, 2));//4
        System.out.println(instance.numWays(2, 4));//2
        System.out.println(instance.numWays(4, 2));//8
        System.out.println(instance.numWays(27, 7));//127784505
    }

    /**
     * 解法1：记忆化递归
     */
    public int numWays1(int steps, int arrLen) {
        if (arrLen <= 0 || steps <= 0) return 0;
        memo = new HashMap<>();
        return dfs(steps, arrLen, 0);
    }

    private int dfs(int steps, int arrLen, int position) {
        if (steps == 0) {
            if (position == 0) {
                return 1;
            }
            return 0;
        }
        //特判，向右移动的位置超过剩余步数，则一定回不到原点
        if (steps < position) {
            return 0;
        }
        //若相等， 则只有一种方案回到原点，一直往左移动
        else if (steps == position) {
            return 1;
        }
        //查备忘录
        if (memo.containsKey(position) && memo.get(position).containsKey(steps)) {
            return memo.get(position).get(steps);
        }
        //向左、向右、不动
        int toLeft = 0, toRight = 0, still = 0;
        if (position > 0) {
            toLeft = dfs(steps - 1, arrLen, position - 1);
//            HashMap<Integer, Integer> hashMap = new HashMap<>();
//            hashMap.put(steps, toLeft);
//            memo.put(position, hashMap);
        }
        if (position < arrLen - 1) {
            toRight = dfs(steps - 1, arrLen, position + 1);
//            HashMap<Integer, Integer> hashMap = new HashMap<>();
//            hashMap.put(steps, toRight);
//            memo.put(position, hashMap);
        }
        still = dfs(steps - 1, arrLen, position);
        //加入备忘录
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int res = toLeft + toRight + still;
        hashMap.put(steps, res);
        memo.put(position, hashMap);
        return res % (1000000007);
    }

    HashMap<Integer, HashMap<Integer, Integer>> memo;

    /**
     * 解法2：动态规划 时间O(steps*max(steps,arrLen)) 空间O(steps*max(steps,arrLen))
     * 对于这道题，需要计算在 steps 步操作之后，指针位于下标 0 的方案数
     * 状态定义：
     *      dp[i][j]表示剩余步数为i，位置为j时的方案数
     * 状态转移：
     *      dp[i][j]可由上一次的状态转移而来，具体有以下三种情况：
     *      1）由dp[i-1][j]转移而来，即操作为[不动]
     *      2）由dp[i-1][j-1]转移而来，即操作为[向右]
     *      3）由dp[i-1][j+1]转移而来，即操作为[向左]
     *      dp[i][j]的值为上述三种情况的和
     * 初始化：
     *      dp[0][0]=1，即剩余步数为0，位置为0时，方案数为1，即到达0坐标
     * 最后返回dp[steps][0]
     */
    public int numWays2(int steps, int arrLen) {
        int maxPosition = Math.min(steps, arrLen - 1);
        int[][] dp = new int[steps + 1][maxPosition + 1];
        //初始化
        dp[0][0] = 1;
        //状态转移
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxPosition; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000007;
                }
                if (j <= maxPosition - 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % 1000000007;
                }
            }
        }
        //返回
        return dp[steps][0];
    }

    /**
     * 解法2：动态规划+空间优化 时间O(steps*max(steps,arrLen)) 空间O(max(steps,arrLen))
     */
    public int numWays(int steps, int arrLen) {
        int maxPosition = Math.min(steps, arrLen - 1);
        int[] dp = new int[maxPosition + 1];
        int[] prev = new int[maxPosition + 1];
        //初始化
        dp[0] = 1;
        prev[0] = 1;
        //状态转移
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxPosition; j++) {
                dp[j] = prev[j];
                if (j > 0) {
                    dp[j] = (dp[j] + prev[j - 1]) % 1000000007;
                }
                if (j <= maxPosition - 1) {
                    dp[j] = (dp[j] + prev[j + 1]) % 1000000007;
                }
            }
            for (int j = 0; j <= maxPosition; j++) {
                prev[j] = dp[j];
            }
        }
        //返回
        return dp[0];
    }
}
