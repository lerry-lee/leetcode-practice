package _其他._笔试题._中金所;

import java.util.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/03
 */
public class _连续非降交易日数 {

    public static void main(String[] args) {
        int[] prices = new int[]{100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(func(prices)));
    }

    /**
     * 解法1：单调栈 时间O(N~N^2) 空间O(N)
     */
    public static int[] func(int[] prices) {
        int len = prices.length;
        int[] res = new int[len];
        //单调栈
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int price = prices[i];
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = i + 1;
            } else {
                res[i] = i - stack.peek()[1];
            }
            stack.push(new int[]{price, i});
        }
        return res;
    }
}
