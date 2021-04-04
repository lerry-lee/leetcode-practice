package _其他._笔试题._美团;

/**
 * 2 0 180 1 180
 * 3 0 90 0 270 1 180
 * 4 0 90 0 270 1 90 1 1 1 2
 * 5 0 1 0 2 0 3 1 1 1 2
 * 4 0 1 0 2 1 90 1 270
 */

import java.util.Scanner;

public class Main2 {
    static int rows = 0, cols = 0;
    static boolean longitude90_270 = false, longitude0_180 = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            func(t, x);
        }
        System.out.println((rows + 1) * (Math.max(cols * 2, 1)));
    }

    private static void func(int t, int x) {
        if (t == 0) {
            rows++;
        } else if (t == 1) {
            if (longitude0_180 && (x == 0 || x == 180)) {
                return;
            }
            if (longitude90_270 && (x == 90 || x == 270)) {
                return;
            }
            cols++;
            if (x == 90 || x == 270) {
                longitude90_270 = true;
            } else if (x == 0 || x == 180) {
                longitude0_180 = true;
            }
        }
    }
}
