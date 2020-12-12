package _每日一题._20年10月;

/**
 * Created by lerry_li on 2020/10/01
 */

/**
 * 秋叶收藏集
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 * <p>
 * 示例 1：
 * <p>
 * 输入：leaves = "rrryyyrryyyrr"
 * <p>
 * 输出：2
 * <p>
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 * <p>
 * 示例 2：
 * <p>
 * 输入：leaves = "ryr"
 * <p>
 * 输出：0
 * <p>
 * 解释：已符合要求，不需要额外操作
 * <p>
 * 提示：
 * <p>
 * 3 <= leaves.length <= 10^5
 * leaves 中只包含字符 'r' 和字符 'y'
 */
public class _19秋叶收藏集 {
    /**
     * 使用动态规划的思想，设计dp数组，使用3个dp数组记录状态，n为字符串长度
     * <p>
     * dp[0][i] 代表 从0到i 改成红色（纯红）需要修改几次
     * dp[1][i] 代表 从0到i 改成先红再黄（红黄），需要修改几次
     * dp[2][i] 代表 从0到i 改为先红再黄再红（红黄红），需要修改几次
     * <p>
     * 根据 i 是红是黄，判断转移情况
     * <p>
     * dp[0][i] 红色的就不加，如果是黄的，就比之前加1
     * dp[1][i] 从纯红改过来的，还是本身红黄改过来的，做比较取最小值
     * dp[2][i] 从红黄状态变化过来，还是本身状态变化过来，做比较
     * 所以最后要求的答案即：dp[2][n-1]
     * <p>
     * 填dp表的时候，先填角标为0的列，红则为0，否则为1
     * 需要注意的是，因为每个位置叶子数要求大于等于1，
     * 在(2,1)位置，要转为红黄红，之前的步骤必须是红黄，所以有dp[2][1] = dp[1][1];
     */
    public int minimumOperations(String leaves) {
        if (leaves == null || leaves.length() == 0) return 0;
        int n = leaves.length();
        int[][] dp = new int[3][n];
        for (int i = 0; i < 3; i++) {
            dp[i][0] = leaves.charAt(0) == 'r' ? 0 : 1;
        }
        for (int i = 1; i < n; i++) {
            char c = leaves.charAt(i);
            if (c == 'r') {
                dp[0][i] = dp[0][i - 1];
                dp[1][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + 1;
                dp[2][i] = Math.min(dp[1][i - 1], dp[2][i - 1]);
            } else {
                dp[0][i] = dp[0][i - 1] + 1;
                dp[1][i] = Math.min(dp[0][i - 1], dp[1][i - 1]);
                dp[2][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + 1;
            }
            if (i == 1) {
                dp[2][i] = dp[1][i];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return dp[2][n - 1];
    }
}
