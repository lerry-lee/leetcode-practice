package _每日一题._2021年._21年5月;

import java.util.Stack;

/**
 * @ClassName: _1190反转每对括号间的子串
 * @Author: lerry_li
 * @CreateDate: 2021/05/26
 * @Description
 * 解法1：朴素用栈
 */
public class _1190反转每对括号间的子串 {

    public static void main(String[] args) {
        _1190反转每对括号间的子串 instance=new _1190反转每对括号间的子串();
        System.out.println(instance.reverseParentheses("(abcd)"));
        System.out.println(instance.reverseParentheses("(u(love)i)"));
        System.out.println(instance.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(instance.reverseParentheses("a(bcdefghijkl(mno)p)q"));

    }

    /**
     * 解法1：朴素用栈 时间O(N^2) 空间O(N)
     */
    public String reverseParentheses(String s) {
        //特判
        if (s == null || s.length() == 0) return "";
        //栈
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        //保存结果
        StringBuilder sb = new StringBuilder();
        //遍历
        for (char value : arr) {
            //若为")"，则到匹配到的第一个"("为止的子串需要反转
            if (value == ')') {
                sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    char c = stack.pop();
                    if (c == '(') break;
                    sb.append(c);
                }
                //反转后的子串再次入栈
                for (int j = 0; j < sb.length(); j++) {
                    stack.push(sb.charAt(j));
                }
            }
            //否则，字母或"("直接入栈
            else {
                stack.push(value);
            }
        }
        //最终栈内的元素即为最终字符串，只是需从栈底到栈顶遍历
        sb=new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
