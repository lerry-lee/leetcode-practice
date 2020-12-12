package _腾讯推荐._数组与字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lerrylee
 * @version 1.0.0
 * @className _两数之和
 * @date 上午9:50 20-9-11
 * @description 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 **/
public class _两数之和 {

    /**
     * 解法1：暴力法 时间复杂度O(n^2) 空间复杂度O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};
        int i = 0, j = 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] + nums[j] == target) return new int[]{i, j};
            if (nums[i] + nums[j] != target) j++;
            if (j == nums.length) {
                i++;
                j = i + 1;
            }
        }
        return new int[]{};
    }

    /**
     * 解法2：使用哈希表一遍遍历 时间复杂度O(n) 空间复杂度O(1)
     */
    public int[] twoSum_hash(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (hashMap.containsKey(dif)) {
                return new int[]{hashMap.get(dif), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }

}
