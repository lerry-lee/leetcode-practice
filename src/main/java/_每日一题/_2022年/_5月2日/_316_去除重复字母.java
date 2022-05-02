package _每日一题._2022年._5月2日;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _316_去除重复字母 {

    /**
     * 解法1：单调栈
     * 思路：
     *      遍历字符串，每次遍历到当前字符假设为c，接下来考虑将c入栈：
     *      1. 如果栈里面有c了，那么c不需要入栈，继续遍历下一个字符；
     *      2. 否则，如果栈顶元素的字典序<c，那么直接入栈，（可保证栈的单调性）；
     *      3. 否则，如果栈顶元素的字典序>c，考虑弹出栈顶元素，假设为x：
     *          1）如果x在c后面还会遍历到，那么直接弹出x即可；
     *          2）否则，x后面不会再出现了，不能弹出，c直接入栈
     */
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // 转成字符数组是因为，s.charAt(i) 会检查字符串的下标是否越界，事实上没有必要
        // 遍历字符串之前，先转换成字符数组是常见的做饭
        char[] charArray = s.toCharArray();

        // 第 1 步：记录每个字符出现的最后一个位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        // 第 2 步：使用栈得到题目要求字典序最小的字符串
        Deque<Character> stack = new ArrayDeque<>(len);
        // 栈中有的字符记录在这里
        boolean[] visited = new boolean[26];
        // 遍历
        for (int i = 0; i < len; i++) {
            char currentChar = charArray[i];
            //如果栈里面有当前遍历的字符了，直接跳过
            if (visited[currentChar - 'a']) {
                continue;
            }
            //否则，考虑入栈，需要看栈顶元素需要被弹出吗
            while (!stack.isEmpty() && currentChar < stack.peekLast() && lastIndex[stack.peekLast() - 'a'] > i) {
                char top = stack.removeLast();
                // 在出栈、入栈的时候，都需要维护 visited 数组的定义
                visited[top - 'a'] = false;
            }
            //入栈
            stack.addLast(currentChar);
            //标记栈里面的元素
            visited[currentChar - 'a'] = true;
        }

        // 第 3 步：此时 stack 就是题目要求字典序最小的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : stack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
