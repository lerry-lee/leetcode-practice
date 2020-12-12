package _其他._笔试题._腾讯;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/06 21:24
 * @description
 */
public class _第二题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] res = getMedian(n, nums);
        //打印结果
        for (int em : res) System.out.println(em);
    }

    public static int[] getMedian(int n, int[] nums) {
        int[] res = new int[n];
        int[] nums_cp = new int[n];
        System.arraycopy(nums, 0, nums_cp, 0, n);
        Arrays.sort(nums_cp);
        int mid_idx = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int mid = nums_cp[mid_idx];
        for (int i = 0; i < n; i++) {
            if (nums[i] < mid) res[i] = mid;
            else res[i] = nums_cp[mid_idx - 1];
        }
        return res;
    }

    public static void display(int[] nums) {
        for (int n : nums) System.out.print(n + " ");
        System.out.println();
    }

    public static void display_res(int[] nums) {
        for (int n : nums) System.out.println(n);
    }
}
