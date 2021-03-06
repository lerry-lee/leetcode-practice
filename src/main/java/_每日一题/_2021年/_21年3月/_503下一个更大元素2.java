package _每日一题._2021年._21年3月;

import _工具类.CommonMethod;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName: _503下一个更大元素2
 * @Author: lerry_li
 * @CreateTime: 2021/03/06
 * @Description
 */
public class _503下一个更大元素2 {
    /**
     * 解法1：暴力 时间O(N^2) 空间O(N)
     */
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int len = nums.length;

        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            int j = i + 1;
            while (j != i) {
                j = j % len;
                if (j == i || nums[j] > cur) {
                    break;
                }
                j++;
            }
            if (j == i) {
                res[i] = -1;
            } else {
                res[i] = nums[j];
            }
        }

        return res;

    }

    /**
     * 解法2：单调栈 时间O(N) 空间O(N)
     * 思路：
     *      1.栈保存数组下标，维护一个单调栈
     *      2.遍历数组（遍历一圈，2*len-1），当前元素cur和栈顶元素比较
     *          1）若当前元素更小，则入栈
     *          2）否则，不断弹出栈顶元素，直到栈顶元素更大（每一个被弹出的栈顶元素所指向的数组元素，其下一个更大的元素记为当前元素cur）
     *
     */
    public int[] nextGreaterElements2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        int idx = 0;

        while (idx < 2 * len - 1) {
            int cur = nums[idx % len];

            while (!stack.isEmpty() && nums[stack.peek()] < cur) {
                int i = stack.pop();
                res[i] = cur;
            }
            stack.push(idx % len);
            idx++;
        }
        return res;
    }


    public static void main(String[] args) {
        _503下一个更大元素2 instance = new _503下一个更大元素2();
        int[] nums = {1, 2, 1};
        int[] res = instance.nextGreaterElements2(nums);
        CommonMethod.display(res);
    }
}
