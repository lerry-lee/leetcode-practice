package _每日一题._2022年;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _剑指Offer45_把数组排成最小的数 {
    /**
     * 解法1：自定义排序 时间O(NlogN) 空间O(N)
     */
    class Solution {
        public String minNumber(int[] nums) {
            if (nums == null || nums.length == 0) return "";
            String[] arr = new String[nums.length];
            for (int i = 0; i < arr.length; i++) arr[i] = nums[i] + "";
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    long l1 = Long.parseLong(o1 + o2);
                    long l2 = Long.parseLong(o2 + o1);
                    return Long.compare(l1, l2);
                }
            });
            StringBuilder sb = new StringBuilder();
            for (String num : arr) sb.append(num);
            return sb.toString();
        }
    }
}
