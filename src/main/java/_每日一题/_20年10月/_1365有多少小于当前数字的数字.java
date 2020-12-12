package _每日一题._20年10月;

/**
 * Created by lerry_li on 2020/10/26
 */

import java.util.Random;

/**
 * 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * <p>
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * <p>
 * 以数组形式返回答案。
 */
public class _1365有多少小于当前数字的数字 {
    /**
     * 解法1：暴力 时间O(N^2) 空间O(N)
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                if (nums[j] < nums[i]) {
                    cnt++;
                }
            }
            res[i] = cnt;
        }
        return res;
    }

    /**
     * 解法2：排序+同时存愿数组下标 时间O(NlogN) 空间O(N)
     */
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] res = new int[nums.length];
        indexes = new int[nums.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[indexes[0]] = 0;
            } else if (nums[i] > nums[i - 1]) {
                res[indexes[i]] = i;
            } else {
                res[indexes[i]] = res[indexes[i - 1]];
            }

        }
        return res;
    }

    int[] indexes;

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int p = partition(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    public int partition(int[] nums, int l, int r) {
        int p = l + new Random().nextInt(r - l);
        swap(nums, l, p);
        swap(indexes, l, p);
        p = l;
        while (l < r) {
            while (l < r && nums[r] >= nums[p]) {
                r--;
            }
            while (l < r && nums[l] <= nums[p]) {
                l++;
            }
            if (l < r) {
                swap(nums, l, r);
                swap(indexes, l, r);
            }
        }
        swap(nums, p, l);
        swap(indexes, p, l);
        return l;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    /**
     * 解法3：计数排序
     * 注意到数组的范围是[0,100]，
     * 因此可以用一个101大小的数组统计每个元素出现的次数
     */
    public int[] smallerNumbersThanCurrent3(int[] nums) {
        int[] res = new int[nums.length];
        int[] countNum = new int[101];
        // 统计每个元素出现的次数，countNum[i]表示元素i出现的次数
        for (int num : nums) {
            countNum[num]++;
        }
        // countNum[i]把前面的数量加起来，表示小于等于i的元素的个数
        // 如果要找比i小的数的个数，countNum[i-1]即是
        for (int i = 1; i < 101; i++) {
            countNum[i] += countNum[i - 1];
        }
        // 最后遍历直接取，这里注意nums[i]为0的情况，放置nums[i]-1下标越界
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[i] = 0;
            } else {
                res[i] = countNum[nums[i] - 1];
            }
        }
        return res;
    }
}
