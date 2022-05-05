package _每日一题._2022年._5月;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/05
 * @Description
 */
public class _946_验证栈序列 {
    /**
     * 解法1：用栈
     */
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            // 特判
            if (pushed == null && popped == null) return true;
            if (pushed == null || popped == null) return false;
            if (pushed.length == 0 && popped.length == 0) return true;
            if (pushed.length == 0 || popped.length == 0) return true;
            // 栈
            Deque<Integer> stack = new ArrayDeque<>();
            // 遍历pushed，每次考虑push当前元素或pop掉popped中相同的元素，直到pushed为空，检查popped
            int end = 0;
            for (int pushEm : pushed) {
                stack.addLast(pushEm);
                while (!stack.isEmpty()&&stack.peekLast() == popped[end]) {
                    stack.pollLast();
                    end++;
                }
            }
            return stack.isEmpty();
        }
    }
}
