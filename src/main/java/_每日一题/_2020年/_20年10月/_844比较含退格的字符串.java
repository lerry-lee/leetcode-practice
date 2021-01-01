package _每日一题._2020年._20年10月;

import java.util.Stack;

/**
 * Created by lerry_li on 2020/10/19
 */

/**
 * 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 */
public class _844比较含退格的字符串 {
    /**
     * 解法1：用栈 时间O(m+n) 空间O(m+n)
     */
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return S == null && T == null;
        if (S.length() == 0) return T.length() == 0;

        return helper(S).equals(helper(T));

    }

    public String helper(String S) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(c);
            }
        }
        StringBuilder newS = new StringBuilder();
        while (!s.isEmpty()) {
            newS.append(s.pop());
        }
        return newS.toString();
    }

    /**
     * 解法2：逆序遍历
     * 一个字符是否会被删掉，只取决于该字符后面的退格符，
     * 而与该字符前面的退格符无关。因此当我们逆序地遍历字符串，
     * 就可以立即确定当前字符是否会被删掉。
     */
    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

}
