package DailyProblem._20年7月;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/29 11:17
 * @description 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * <p>
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 */
public class _594最长和谐子序列 {
    /**
     * 解法一：排序+遍历 时间复杂度 O(n^2) 空间复杂度 O(1)
     */
    public int findLHS_sort(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length - i < res) break;
            int count = 1;
            int j = i + 1;
            while (j < nums.length) {
                if (nums[j] - nums[i] <= 1) count++;
                else break;
                j++;
            }
            if (nums[j - 1] - nums[i] == 1) res = Math.max(res, count);
        }
        return res;
    }

    /**
     * 解法二：直接枚举 时间复杂度 O(n^2) 空间复杂度 O(1)
     */
    public int findLHS_enumerate(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i])
                    count++;
                else if (nums[j] + 1 == nums[i]) {
                    count++;
                    flag = true;
                }
            }
            if (flag)
                res = Math.max(count, res);
        }
        return res;
    }

    /**
     * 解法三：哈希映射 时间复杂度 O(n) 空间复杂度 O(n)
     */
    public int findLHS_hash(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }

}
