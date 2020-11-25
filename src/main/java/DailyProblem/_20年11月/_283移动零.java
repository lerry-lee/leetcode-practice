package DailyProblem._20年11月;

import DataStructure.CustomMethod;

/**
 * @ClassName: _283移动零
 * @Signature: Created by lerry_li on 2020/11/19
 * @Description:
 */
public class _283移动零 {
    /**
     * 解法1：双指针 时间O(N) 空间O(1)
     * 定义：
     * p1指针：第一个0的下标
     * p2指针：若干个0后的第一个非0元素
     * 算法：
     * 1.遍历数组，p1找到第一个0，p2找到0后的第一个非0，然后交换
     * 2.p1+1，p2+1
     * 3.直到p2或者p1到达数组末尾
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int p1 = 0, p2 = 0;
        while (p2 < nums.length) {
            while (p1 < nums.length && nums[p1] != 0) {
                p1++;
            }
            if (p1 == nums.length - 1) {
                return;
            }

            p2 = p1 + 1;

            while (p2 < nums.length && nums[p2] == 0) {
                p2++;
            }
            if (p2 < nums.length) {
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
                p1++;
                p2++;
            }
        }
    }

    public static void main(String[] args) {
        _283移动零 instance = new _283移动零();
        int[] nums = {0};
        CustomMethod.display(nums);
        instance.moveZeroes(nums);
        CustomMethod.display(nums);
    }
}
