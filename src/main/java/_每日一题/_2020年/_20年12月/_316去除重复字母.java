package _每日一题._2020年._20年12月;

import java.util.Stack;

/**
 * @ClassName: _316去除重复字母
 * @Author: lerry_li
 * @CreateDate: 2020/12/23
 * @Description
 */
public class _316去除重复字母 {
    /**
     * 解法1：贪心+单调栈
     * 算法：
     *      1.遍历s，记录每个字符最后一次出现的下标
     *      2.遍历s，设当前字符为c
     *          1）若栈中有c，则跳过
     *          2）否则，执行循环
     *              条件①：“c的字典序小于e的”
     *              条件②：“c当前的下标小于e的最后出现下标”
     *              while（栈不为空&&条件①&&条件②）{
     *                  设栈顶元素为e，e出栈；
     *                  栈中元素记录去掉e；
     *              }
     *           循环结束后，将c入栈
     *
     *      3.栈中元素即为最终字符串的元素
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int[] lastIndex = new int[26];
        Stack<Character> stack = new Stack<>();
        boolean[] stackHasIt = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stackHasIt[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && i < lastIndex[stack.peek() - 'a']) {

                char e = stack.peek();
                stack.pop();
                stackHasIt[e - 'a'] = false;

            }
            stack.push(c);
            stackHasIt[c - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : stack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        _316去除重复字母 instance = new _316去除重复字母();
        System.out.println(instance.removeDuplicateLetters("cdadabcc"));
        System.out.println(instance.removeDuplicateLetters("cbacdcbc"));
    }
}
