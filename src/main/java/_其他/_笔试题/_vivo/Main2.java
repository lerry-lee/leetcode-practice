package _其他._笔试题._vivo;

import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Author: lerry_li
 * @CreateTime: 2021/06/17
 * @Description
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        String[] str_w = sc.next().split(",");
        int n = str_w.length;
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(str_w[i]);
        }
        String[] str_v = sc.next().split(",");
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(str_v[i]);
        }
        //dp
        int[][] dp = new int[n + 1][c + 1];
        for (int i = 1; i <= n; i++) {
            int wi = w[i - 1];
            int vi = v[i - 1];
            for (int j = 0; j <= c; j++) {

            }
        }
    }
}
