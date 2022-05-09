package _每日一题._2022年._5月;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 * @Description
 */
public class _739_每日温度 {

    public static void main(String[] args) {
        int[] temp = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        _739_每日温度 instance = new _739_每日温度();
        instance.new Solution().dailyTemperatures(temp);
    }

    /**
     * 解法1：单调栈 时间O(N) 空间O(N)
     */
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            //特判
            if (temperatures == null || temperatures.length == 0) return new int[]{};
            //单调栈，单调递增
            Deque<Integer> stack = new ArrayDeque<>();
            int len = temperatures.length;
            int[] res = new int[len];
            //从后往前遍历
            for (int i = len - 1; i >= 0; i--) {
                //保持单调栈递增
                while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peekLast()]) {
                    stack.removeLast();
                }
                //如果栈为空，表明后面没有比它更大的元素，填0
                if (stack.isEmpty()) {
                    res[i] = 0;
                }
                //否则，栈顶元素的下标和当前下标差，表示隔了多少天
                else {
                    res[i] = stack.peekLast() - i;
                }
                //将当前元素的下标入栈
                stack.addLast(i);
            }
            return res;
        }
    }
}
