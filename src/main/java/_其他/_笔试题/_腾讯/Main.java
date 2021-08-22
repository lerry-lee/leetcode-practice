package _其他._笔试题._腾讯;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/22
 */

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            Arrays.sort(nums);
            System.out.println(func(nums));
        }
    }

    private static int func(int[] nums) {
        String mod = "1000000007";
        BigInteger res = new BigInteger("0");
        for (int i = 0; i < nums.length; i++) {
            BigInteger digit = new BigInteger("2");
            res = res.add(digit.pow(i).multiply(new BigInteger(String.valueOf(nums[i]))));
        }
        return res.mod(new BigInteger(mod)).intValue();
    }

}
