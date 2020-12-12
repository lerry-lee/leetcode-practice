package _字节推荐._动态或贪心;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/19 17:49
 * @description 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 */
public class _最大正方形 {
    /**
     * 动态规划：时间复杂度O(m*n)，空间复杂度O(m*n)
     * 动态规划优化：只存最优值，空间复杂度降为O(1)
     */


    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int max_l = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = getInt(matrix[i][0]);
            if (dp[i][0] == 1) max_l = 1;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = getInt(matrix[0][i]);
            if (dp[0][i] == 1) max_l = 1;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    int temp = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
                    if (temp >= 1) dp[i][j] = temp + 1;
                    else dp[i][j] = 1;
                }
                max_l = Math.max(max_l, dp[i][j]);
            }
        }
        display(dp);
        return max_l * max_l;
    }

    public int min(int a, int b, int c) {
        if (a < b) return Math.min(a, c);
        return Math.min(b, c);
    }

    public int min(char a, char b, char c) {
        int a1 = Character.getNumericValue(a);
        int b1 = Character.getNumericValue(b);
        int c1 = Character.getNumericValue(c);
        if (a1 > b1) {
            return Math.max(a1, c1);
        } else {
            return Math.max(b1, c1);
        }
    }

    public int getInt(char a) {
        return a == '1' ? 1 : 0;
    }

    public void display(int[][] dp) {
        for (int[] dp_i : dp) {
            for (int i : dp_i) System.out.print(i + " ");
            System.out.println();
        }
        System.out.println();
    }
}
