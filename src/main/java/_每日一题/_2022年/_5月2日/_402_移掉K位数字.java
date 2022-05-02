package _每日一题._2022年._5月2日;

import java.util.Stack;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _402_移掉K位数字 {

    public static void main(String[] args) {
        _402_移掉K位数字 instance = new _402_移掉K位数字();
        instance.new Solution().removeKdigits("10200", 1);
    }

    /**
     * 解法1：单调栈
     * 思路：
     *      遍历数字，维护一个单调递增的栈，如果k>0，那么可以考虑弹出栈顶元素（栈顶元素比当前数字大的话）
     */
    class Solution2 {

        public String removeKdigits(String num, int k) {
            //特判
            if (k >= num.length()) return "0";
            Stack<Integer> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for (char c : num.toCharArray()) {
                while (k > 0 && !stack.isEmpty() && (c - '0') < stack.peek()) {
                    stack.pop();
                    k--;
                }
                stack.push(c - '0');
            }
            while (!stack.isEmpty()) {
                if(k-->0) stack.pop();
                else sb.insert(0, stack.pop());
            }
            int i = 0;
            for (; i < sb.length(); i++) {
                if (sb.charAt(i) != '0') break;
            }
            String res = sb.substring(i, sb.length());
            return res.length() == 0 ? "0" : res;
        }

    }

    /**
     * 解法1：递归 超时
     */
    class Solution {
        StringBuilder sb;

        public String removeKdigits(String num, int k) {
            //特判
            if (k >= num.length()) return "0";
            sb = new StringBuilder(num);
            //递归求解
            dfs(k);
            return sb.length() == 0 ? "0" : sb.toString();
        }

        private void dfs(int k) {
            if (k == 0) return;
            if (sb.length() <= k) {
                sb = new StringBuilder("0");
                return;
            }
            int i = 0;
            for (; i < sb.length() - 1; i++) {
                if (sb.charAt(i) > sb.charAt(i + 1)) {
                    break;
                }
            }
            //是否为第一个数字
            if (i == 0) {
                int j = i + 1;
                for (; j < sb.length(); j++) {
                    if (sb.charAt(j) != '0') break;
                }
                sb.delete(i, j);
            } else {
                sb.deleteCharAt(i);
            }
            dfs(k - 1);
        }
    }
}
