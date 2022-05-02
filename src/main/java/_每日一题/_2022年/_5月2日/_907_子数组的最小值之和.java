package _每日一题._2022年._5月2日;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _907_子数组的最小值之和 {

    public static void main(String[] args) {
        _907_子数组的最小值之和 instance=new _907_子数组的最小值之和();
        instance.new Solution2().sumSubarrayMins(new int[]{3,1,2,4});
    }

    /**
     * 解法1：暴力枚举 时间O(N^2) 空间O(1)
     */
    class Solution1 {
        public int sumSubarrayMins(int[] arr) {
            if(arr==null||arr.length==0) return 0;
            int res=0;
            for (int i = 0; i < arr.length; i++) {
                int minNum=Integer.MAX_VALUE;
                for (int j = i; j < arr.length; j++) {
                    minNum=Math.min(minNum,arr[j]);
                    res=(res+minNum)%1000000007;
                }
            }
            return res;
        }
    }

    /**
     * 解法2：单调栈
     */
    class Solution2 {
        private static final int MOD = 1000000007;
        public int sumSubarrayMins(int[] arr) {
            // 处理边界情况
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int n = arr.length;
            // 每个元素辐射范围的左边界
            int[] left = new int[n];
            // 每个元素辐射范围的右边界
            int[] right = new int[n];
            Deque<Integer> stack = new LinkedList<>();

            // 第一次循环先找到所有元素的左边界
            for (int i = 0; i < n; i++) {
                // 向左找第一个小于等于E的元素
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                // 设立一个最左边界-1
                if (stack.isEmpty()) {
                    left[i] = -1;
                } else {
                    left[i] = stack.peek();
                }
                // 下标入栈，方便同时得到i和A[i]
                stack.push(i);
            }

            // 第二次循环找到所有元素的右边界
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                // 向右找第一个小于E的元素
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                // 设立一个最右边界n
                if (stack.isEmpty()) {
                    right[i] = n;
                } else {
                    right[i] = stack.peek();
                }
                // 下标入栈，方便同时得到i和A[i]
                stack.push(i);
            }

            // 按照贡献度计算即可
            // 注意此处left[i]和right[i]实际上记录的是左边界-1和右边界+1，和上面思路中有些区别，便于计算
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans = (ans + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
            }
            return (int)ans;
        }
    }

    /**
     * 解法3:解法2优化，，1次遍历
     */
    class Solution3 {
        private static final int MOD = 1000000007;

        // 重写根据下标取值方法，-1和n返回MIN_VALUE
        private int getElement(int[] arr, int n, int i) {
            if (i == -1 || i == n) {
                return Integer.MIN_VALUE;
            }
            return arr[i];
        }

        public int sumSubarrayMins(int[] arr) {
            // 处理边界情况
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int n = arr.length;
            long ans = 0;
            Deque<Integer> stack = new LinkedList<>();
            // 将下标-1和n作为两个哨兵元素，它们对应的元素为MIN_VALUE
            // -1作为最左边界，n作为最右边界
            for (int i = -1; i <= n; i++) {
                // 向左寻找第一个小于等于A[i]的元素
                while (!stack.isEmpty() && getElement(arr, n, stack.peek()) > getElement(arr, n, i)) {
                    // A[cur]就是之前思路中的A[i]，注意区分和上面代码的区别
                    // 对于每个出栈元素来说，i就是它们的右边界，而栈顶元素就是左边界
                    int cur = stack.pop();
                    // 计算贡献值
                    ans = (ans + (long)(cur - stack.peek()) * (i - cur) * arr[cur]) % MOD;
                }
                stack.push(i);
            }

            return (int)ans;
        }
    }
}
