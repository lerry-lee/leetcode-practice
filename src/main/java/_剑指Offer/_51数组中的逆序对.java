package _剑指Offer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @ClassName: _51数组中的逆序对
 * @Author: lerry_li
 * @CreateDate: 2021/05/07
 * @Description
 */
public class _51数组中的逆序对 {

    public static void main(String[] args) {
        _51数组中的逆序对 instance = new _51数组中的逆序对();
        System.out.println(instance.reversePairs2(new int[]{7, 5, 6, 4}));//5
        System.out.println(instance.reversePairs2(new int[]{7, 7, 5, 6, 4}));//10
        //[233,2000000001,234,2000000006,235,2000000003,236,2000000007,237,2000000002,2000000005,233,233,233,233,233,2000000004]
        System.out.println(instance.reversePairs2(new int[]{233, 2000000001, 234, 2000000006, 235, 2000000003, 236, 2000000007, 237, 2000000002, 2000000005, 233, 233, 233, 233, 233, 2000000004}));//69
    }

    /**
     * 解法1：朴素暴力 时间O(N^2) 空间O(1)
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res += 1;
                }
            }
        }
        return res;
    }

    /**
     * 解法2：todo 时间O(NlogN) 空间O(N)
     */
    public int reversePairs2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;

        return res;
    }

}
