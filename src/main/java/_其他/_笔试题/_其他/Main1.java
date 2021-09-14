package _其他._笔试题._其他;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/14
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] games = new int[n][2];
        for (int i = 0; i < n; i++) {
            games[i][0] = in.nextInt();
            games[i][1] = in.nextInt();
        }
        in.close();
        Arrays.sort(games, (o1, o2) -> o2[1] - o1[1]);
        int res = games[0][1];
        int time = 10;

        System.out.println(res);
    }
}

/*
5
20 5
30 10
25 8
15 15
10 6
 */