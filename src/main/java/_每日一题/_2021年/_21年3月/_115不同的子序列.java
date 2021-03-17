package _每日一题._2021年._21年3月;

/**
 * @ClassName: _115不同的子序列
 * @Author: lerry_li
 * @CreateDate: 2021/03/17
 * @Description
 */
public class _115不同的子序列 {
    /**
     * 解法1：记忆化回溯（带备忘录的回溯） 不带备忘录就超时。。。
     */
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }
        int lenS = s.length(), lenT = t.length();
        if (lenS < lenT) {
            return 0;
        }
        int[][] memory = new int[lenS + 1][lenT + 1];
        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenT; j++) {
                memory[i][j] = -1;
            }
        }
        return dfs(memory, s, t, 0, 0);
    }

    public int dfs(int[][] memory, String s, String t, int si, int ti) {
        if (ti == t.length()) {
            return 1;
        }
        int sum = 0;
        for (int i = si; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == t.charAt(ti)) {
                //下标检查+备忘录已经记录过，直接使用记录值
                if (i + 1 < s.length() && ti + 1 < t.length() && memory[i + 1][ti + 1] != -1) {
                    sum += memory[i + 1][ti + 1];
                }
                //否则，递归计算
                else {
                    int temp = dfs(memory, s, t, i + 1, ti + 1);
                    //存入备忘录
                    memory[i + 1][ti + 1] = temp;
                    //temp大于0说明后面可以组成，这时才加和
                    if (temp > 0) {
                        sum += temp;
                    } else {
                        break;
                    }
                }
            }
        }
        return sum;
    }

    /**
     * 解法2：动态规划
     * 状态定义：dp[i][j]表示字符串s的[0,i-1]和字符串t的[0,t-1]匹配的次数，最终返回dp[lenS][lenT]即可
     * 状态转移：
     *      题解中的关键：
     *      s[i] == t[j]的时候, s[i] 可以选择自己是否跟 t[j]匹配
     *      如果匹配，那么 dp[i][j] 其中一部分数量就是 dp[i+1][j+1]
     *      如果选择不匹配（这样可以让前面的字符跟t[j]匹配，毕竟t 短的,s 长) dp[i][j] 另外一部分就是 dp[i+1][j]
     *      所以才会有：dp[i][j] = dp[i+1][j+1] + dp[i+1][j]
     * 初始化：
     *      dp[][]=1
     */
    public int numDistinct2(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }
        int lenS = s.length(), lenT = t.length();
        if (lenS < lenT) {
            return 0;
        }
        int[][] dp = new int[lenS + 1][lenT+1];
        for (int j = 0; j <= lenT; j++) {
            dp[0][j] = 0;
        }
        // 第0列，即：s[0...i]变成""的方法数，只有1种方法，一个字符都不要
        for (int i = 0; i <= lenS; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenT; j++) {
                //状态转移，t的字符是一定要匹配上的!
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[lenS][lenT];
    }

    public static void main(String[] args) {
        _115不同的子序列 instance = new _115不同的子序列();
        System.out.println(instance.numDistinct2("rabbbit", "rabbit"));
        System.out.println(instance.numDistinct2("babgbag", "bag"));
    }
}
