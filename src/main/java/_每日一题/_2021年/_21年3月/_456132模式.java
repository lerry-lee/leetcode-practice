package _每日一题._2021年._21年3月;

import java.util.Stack;

/**
 * @ClassName: _456132模式
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description
 */
public class _456132模式 {
    /**
     * 解法1：暴力枚举 时间O(N^3) 空间O(1)
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int len = nums.length;
        boolean[] markJ = new boolean[len];
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 1; j++) {
                if (nums[j] == nums[j - 1] || nums[j] <= nums[i] || markJ[j]) {
                    continue;
                }
                for (int k = j + 1; k < len; k++) {
                    if (nums[k] == nums[k - 1] || nums[k] >= nums[j] || nums[k] <= nums[i]) {
                        continue;
                    }
                    return true;
                }
                markJ[j] = false;
            }
        }
        return false;
    }

    /**
     * 解法2：单调栈 时间O(N) 空间O(N)
     * 思路：
     *      132模式中，3是最大值，1是最小值，2是次小值
     *      →用一个min[]数组维护左边元素的最小值，用一个单调栈维护右边元素的单调性
     *      →枚举中间的元素，如果min[]小于中间元素，则满足13模式，然后看单调栈的元素是否满足12模式和32模式即可
     */
    public boolean find132pattern2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int len = nums.length;
        //minLeft记录从数组下标0到当前下标i的所有元素的最小值
        //minLeft维护的是132模式中的元素1，即最小值
        int[] minLeft = new int[len];
        minLeft[0] = nums[0];
        for (int i = 1; i < len; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], nums[i]);
        }
        //单调栈，记录从当前下标i到数组最后一个下标len-1的元素（维护单调性，栈顶为最小元素）
        //单调栈维护的是132模式中的元素2，即次小值
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[len - 1]);
        //枚举132模式的中间元素，即3个数中的最大值
        for (int i = len - 2; i >= 1; i--) {
            //是否满足132模式
            //首先判断的是元素1小于元素3
            if (minLeft[i] < nums[i]) {
                //若元素2小于等于元素1，则弹出栈顶元素
                //循环结束后，单调栈要么为空，要么栈顶元素（元素2）满足了132模式
                while (!stack.isEmpty() && stack.peek() <= minLeft[i]) {
                    stack.pop();
                }
                //如果栈不为空且满足132模式，返回true
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                //否则，继续枚举元素3，将当前元素入栈
                stack.push(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _456132模式 instance = new _456132模式();
        System.out.println(instance.find132pattern2(new int[]{1, 2, 3, 4}));
        System.out.println(instance.find132pattern2(new int[]{3, 1, 4, 2}));
        System.out.println(instance.find132pattern2(new int[]{-1, 3, 2, 0}));
    }
}
