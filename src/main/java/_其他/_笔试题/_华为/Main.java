package _其他._笔试题._华为;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        avgScore = sc.nextInt();
        n = sc.nextInt();
        scores = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            scores[i] = sc.nextInt();
        }
        int sum = Arrays.stream(scores).sum();
        if (sum % avgScore != 0) {
            System.out.println(0);
            return;
        }
        res = new int[n][2];
        used = new boolean[2 * n];
        Arrays.sort(scores);
        swap(scores);
        func();
    }

    private static void swap(int[] scores) {
        int l = 0, r = scores.length - 1;
        while (l < r) {
            int temp = scores[l];
            scores[l] = scores[r];
            scores[r] = temp;
            l++;
            r--;
        }
    }

    static int n;
    static int avgScore;
    static int[] scores;
    static boolean[] used;
    static int[][] res;

    private static void func() {
        int idx = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (used[i]) continue;
            for (int j = i + 1; j < 2 * n; j++) {
                if (used[j]) continue;
                int sum = scores[i] + scores[j];
                if (sum % avgScore != 0) {
                    Arrays.fill(used, false);
                    continue;
                }
                res[idx][0] = scores[i];
                res[idx][1] = scores[j];
                idx++;
                used[i] = true;
                used[j] = true;
                break;
            }
        }
        if (idx < n) {
            System.out.println(0);
        } else {
            Arrays.sort(res, ((o1, o2) -> {
                int sum1 = o1[0] + o1[1];
                int sum2 = o2[0] + o2[1];
                if (sum1 == sum2) {
                    return Integer.compare(o2[0], o1[0]);
                }
                return Integer.compare(sum2, sum1);
            }));
            for (int i = 0; i < n; i++) {
                System.out.print(res[i][0] + " " + res[i][1]+" ");
            }
            System.out.println();
        }
    }
}

/*
5 5
1 10 5 4 3 2 7 6 8 -1

1 3
2 4 6 8 10 12

10 3
2 3 5 7 8 9
 */