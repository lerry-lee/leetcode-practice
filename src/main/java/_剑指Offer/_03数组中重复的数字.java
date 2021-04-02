package _剑指Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _03数组中重复的数字
 * @Author: lerry_li
 * @CreateDate: 2021/04/02
 * @Description
 */
public class _03数组中重复的数字 {
    /**
     * 解法1：哈希表 时间O(N) 空间O(N)
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return num;
            }
            hashSet.add(num);
        }
        return 0;
    }

    /**
     * 解法2：原地置换 时间O(N) 空间O(1)
     * 思路：
     *      由于数组长度为n，数组元素为[0,n-1]，因此排序后元素i一定在下标i处
     *      可以通过一次遍历，遇到元素i的下标不是i时，将元素i置换到属于它的位置，若此过程出现重复元素，则返回该元素
     * tips：此过程通过while来做
     */
    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                int cur = nums[i];
                int origin = nums[cur];
                if (cur == origin) {
                    return cur;
                }
                nums[i] = origin;
                nums[cur] = cur;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        _03数组中重复的数字 instance=new _03数组中重复的数字();
        System.out.println(instance.findRepeatNumber2(new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
    }
}
