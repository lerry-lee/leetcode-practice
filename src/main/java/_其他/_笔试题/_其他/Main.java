package _其他._笔试题._其他;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }
        System.out.println(func(A, B, N));
    }

    private static int func(int[] A, int[] B, int N) {
        int[][] dp = new int[N][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = N + 1;
            }
        }
        for (int i = 1; i < N; i++) {
            if (Math.max(dp[i][0], dp[i][1]) <= Math.min(dp[i - 1][0], dp[i - 1][1])) {
                return -1;//特判
            }
            if (A[i] > A[i - 1]) {
                dp[i][0] = dp[i - 1][0];
            }
            if (A[i] > B[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
            }
            if (B[i] > A[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
            if (B[i] > B[i - 1]) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + 1);
            }
        }
        int res = Math.min(dp[N - 1][0], dp[N - 1][1]);
        return res == N + 1 ? -1 : res;
    }
}

/*
5
1 2 3 4 5
2 3 4 5 6

6
1 8 3 6 7 5
1 2 3 6 9 7

6
1 8 3 6 7 5
1 2 3 6 9 8

5
10 9 8 7 6
1 2 3 4 5
 */
