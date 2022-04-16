package _其他._笔试题._外企;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/16
 * @Description
 */
public class Task2 {
    public static void main(String[] args) {
        Task2 task2=new Task2();
        int[] A=new int[]{3,2,4,3};
        System.out.println(Arrays.toString(task2.solution(A, 2, 4)));
        A=new int[]{1,5,6};
        System.out.println(Arrays.toString(task2.solution(A, 4, 3)));
        A=new int[]{1,2,3,4};
        System.out.println(Arrays.toString(task2.solution(A, 4, 6)));
        A=new int[]{6,1};
        System.out.println(Arrays.toString(task2.solution(A, 1, 1)));
    }

    public int[] solution(int[] A, int F, int M) {
        int[] result = new int[F];
        int N = A.length + F;
        int sum = N * M;
        if (sum < N || sum > 6 * N) {
            return new int[]{0};
        }
        for (int j : A) {
            sum -= j;
            if (sum <= 0) {
                return new int[]{0};
            }
        }
        if (sum > 6 * F) {
            return new int[]{0};
        }
        int avg = sum / F;
        for (int i = 0; i < F - 1; i++) {
            result[i] = avg;
            sum -= avg;
        }
        result[F - 1] = sum;
        return result;
    }
}
