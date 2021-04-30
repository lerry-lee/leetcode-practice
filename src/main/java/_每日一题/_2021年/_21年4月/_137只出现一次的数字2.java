package _每日一题._2021年._21年4月;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _137只出现一次的数字2
 * @Author: lerry_li
 * @CreateDate: 2021/04/30
 * @Description
 * 解法1：排序
 * 解法2：hash表
 * 解法3：位数统计
 */
public class _137只出现一次的数字2 {

    public static void main(String[] args) {
        _137只出现一次的数字2 instance = new _137只出现一次的数字2();
        int[] nums = {2, 2, 3, 2};
        int[] nums1 = {0, 1, 0, 1, 0, 1, 99};
        int[] nums2={-2,-2,1,1,4,1,4,4,-4,-2};
        System.out.println(instance.singleNumber(nums));
        System.out.println(instance.singleNumber(nums1));
        System.out.println(instance.singleNumber(nums2));
    }

    /**
     * 解法1：排序 时间O(NlogN) 空间O(1)
     */
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len > 1 && nums[0] < nums[1]) {
            return nums[0];
        }
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[len - 1];
    }

    /**
     * 解法2：hash表 时间O(N) 空间O(N)
     */
    public int singleNumber2(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (int key : hashMap.keySet()) {
            if (hashMap.get(key).equals(1)) {
                return key;
            }
        }
        return 0;
    }

    /**
     * 解法3：位数统计 时间O(N) 空间O(1)
     * 思路：
     *      统计各二进制位1的个数，最后模3，可参考图解
     */
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            int idx = 0;
            while (num != 0) {
                count[idx] += num & 1;
                num >>>= 1;
                idx++;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res += count[i] % 3;
        }
        return res;
    }
}
