package _剑指Offer;

import java.util.Stack;

/**
 * @ClassName: _31栈的压入_弹出序列
 * @Author: lerry_li
 * @CreateTime: 2021/04/11
 * @Description
 */
public class _31栈的压入_弹出序列 {
    /**
     * 解法1：用栈 时间O(N) 空间O(N)
     * 思路：
     *      1.每次把pushed当前元素入栈；
     *      2.判断栈顶元素是否和popped当前元素相等，相等则出栈（循环本操作）；
     *      3.遍历完pushed后，栈为空返回true，否则false
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //特判
        if (pushed == null && popped == null) {
            return true;
        }
        if (pushed == null || popped == null) {
            return false;
        }
        int m = pushed.length, n = popped.length;
        if (m == 0 && n == 0) {
            return true;
        }
        if (m != n) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;

        while (i < m) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
            i++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        _31栈的压入_弹出序列 instance = new _31栈的压入_弹出序列();
        System.out.println(instance.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(instance.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
        System.out.println(instance.validateStackSequences(new int[]{2, 1, 0}, new int[]{1, 2, 0}));
    }
}
