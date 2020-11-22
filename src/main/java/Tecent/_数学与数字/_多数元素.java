package Tecent._数学与数字;

import java.util.Arrays;

/**
 * Created by lerry_li on 2020/10/15
 */
public class _多数元素 {
    /**
     * 解法1：排序+双指针 时间O(nlogn) 空间O(1)
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = 0;
        int maxNums = 0;
        int maxNum = nums[0];
        while (r < n) {
            if (nums[r] == nums[l]) {
                r++;
            } else {
                l = r;
                r++;
            }
            if (maxNums < r - l) {
                maxNums = r - l;
                maxNum = nums[l];
            }
        }
        return maxNum;
    }

    /**
     * 解法2：排序+直接返回n/2下标的元素
     * 因为出现次数最多的元素次数大于n/2，所以超过一半的数都是该元素，那么最中间下标一定是该元素
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 解法3：Boyer-Moore投票算法 时间O(n) 空间O(1)
     * 如果我们把众数记为 +1+1，把其他数记为 -1−1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
     * <p>
     * 算法
     * <p>
     * Boyer-Moore 算法的本质和方法四中的分治十分类似。我们首先给出 Boyer-Moore 算法的详细步骤：
     * <p>
     * 我们维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；
     * <p>
     * 我们遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予 candidate，随后我们判断 x：
     * <p>
     * 如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
     * <p>
     * 如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
     * <p>
     * 在遍历完成后，candidate 即为整个数组的众数。
     */
    public int majorityElement3(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }

        }

        return candidate;
    }

}
