package _笔试题._华为;

import java.util.Scanner;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/09 19:09
 * @description TODO
 */
public class _第1题完美排列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[][] perfect_array = new int[k][2];
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j < k; j++) {
                perfect_array[i][j]=sc.nextInt();
            }
        }
        int n=sc.nextInt();
        int[][] array=new int[n][2];
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j]=sc.nextInt();
            }
        }
        System.out.println(perfectOrder(perfect_array,k,array,n));
    }

    public static int perfectOrder(int[][] perfect_array, int k, int[][] array, int n) {
        int idx = 0;
        int i = 0, j = 0;
        while (i < n && j < k) {
            if (array[i][0] != perfect_array[j][0] || array[i][1] != perfect_array[j][1]) {
                j = 0;
            } else if (array[i][0] == perfect_array[j][0] && array[i][1] == perfect_array[j][1]) {
                if (j == 0) idx = i;
                j++;
            }
            i++;
        }
        if (j == k) return idx;
        return 0;
    }
}
