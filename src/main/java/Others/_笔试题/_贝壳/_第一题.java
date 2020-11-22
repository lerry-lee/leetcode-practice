package Others._笔试题._贝壳;

import java.util.Scanner;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/07 15:08
 * @description
 */
public class _第一题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[][] array = new String[t][4];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = sc.next();
            }
        }
        caiQuan(t, array);
    }

    public static void caiQuan(int t, String[][] array) {
        for (int i = 0; i < t; i++) {
            String l1 = array[i][0], r1 = array[i][1], l2 = array[i][2], r2 = array[i][3];
            int l1_rate = winRate(l1, l2, r2);
            int r1_rate = winRate(r1, l2, r2);
            if (l1_rate > r1_rate) System.out.println("left");
            else if (l1_rate < r1_rate) System.out.println("right");
            else System.out.println("same");
        }
    }

    public static int winRate(String c, String l, String r) {
        if (c.equals("J")) {
            if (l.equals("B") && r.equals("B")) return 100;
            else if (l.equals("B") || r.equals("B")) return 50;
            else return 0;
        } else if (c.equals("S")) {
            if (l.equals("J") && r.equals("J")) return 100;
            else if (l.equals("J") || r.equals("J")) return 50;
            else return 0;
        } else {
            if (l.equals("S") && r.equals("S")) return 100;
            else if (l.equals("S") || r.equals("S")) return 50;
            else return 0;
        }
    }
}
