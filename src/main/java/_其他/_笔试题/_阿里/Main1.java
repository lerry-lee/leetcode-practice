package _其他._笔试题._阿里;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(func(nums));
        }
    }

    private static int func(int[] nums) {
        int totalDifNum = 0;
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j > i + 1) {
                nums[j - 1] += 1;
                i = j - 1;
            } else {
                i++;
            }
            totalDifNum++;
        }
        return totalDifNum;
    }
}
//2 6 1 2 2 2 5 6 2 4 4
//1 8 1 2 2 2 3 4 4 5