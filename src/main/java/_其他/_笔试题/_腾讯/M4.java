package _其他._笔试题._腾讯;


/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/05
 */


import java.util.*;

public class M4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(f(str.toCharArray(), n));
    }

    private static int f(char[] arr, int n) {
        int[][] dp = new int[n + 1][4];
        for (int i = 0; i < 4; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            if (arr[i - 1] == 'S') {
                dp[i][0] += 1;
            } else if (arr[i - 1] == 'T') {
                if (i - 2 >= 0) dp[i][1] = dp[i - 1][1] + dp[i - 2][0];
            } else if (arr[i - 1] == 'A') {
                if (i - 4 >= 0) dp[i][2] = dp[i - 1][2] + dp[i - 2][1];
            } else {
                if (i - 6 >= 0) dp[i][3] = dp[i - 1][3] + dp[i - 2][2];
            }
        }
        return dp[n][3];
    }
}