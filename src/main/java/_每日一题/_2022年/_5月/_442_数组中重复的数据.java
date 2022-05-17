package _每日一题._2022年._5月;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/17
 */
public class _442_数组中重复的数据 {

    public static void main(String[] args) {
        _442_数组中重复的数据 instance = new _442_数组中重复的数据();
        instance.new Solution().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }

    /**
     * 解法1：计数置换+哈希表去重 时间O(N) 空间O(N)
     */
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();
            // check null
            if (nums == null || nums.length == 0) return res;
            Set<Integer> hashSet = new HashSet<>();
            // count permutation
            for (int i = 0; i < nums.length; i++) {
                while (nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
                if (nums[i] - 1 != i && nums[nums[i] - 1] == nums[i]) {
                    if (hashSet.isEmpty() || !hashSet.contains(nums[i])) {
                        res.add(nums[i]);
                        hashSet.add(nums[i]);
                    }
                }
            }
            return res;
        }
    }

    /**
     * 解法2：计数置换+两次遍历 时间O(N) 空间O(1)
     */
    class Solution2 {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();
            // check null
            if (nums == null || nums.length == 0) return res;
            // count permutation
            for (int i = 0; i < nums.length; i++) {
                while (nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
            // iterate over the array, find the num whose index not match num
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    res.add(nums[i]);
                }
            }
            return res;
        }
    }
}
