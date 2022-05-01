package _每日一题._2022年._5moth1day;

import java.util.Stack;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _394_字符串解码 {

    public static void main(String[] args) {
        _394_字符串解码 instance=new _394_字符串解码();
        instance.new Solution().decodeString("3[a]2[bc]");
    }

    /**
     * 解法1：借助两个栈，一个存括号和字母，一个存数字 时间O(N) 空间O(N)
     */
    class Solution {
        public String decodeString(String s) {
            if (s == null || s.length() == 0) return "";
            Stack<String> vals = new Stack<>();
            Stack<Integer> nums = new Stack<>();
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (Character.isDigit(arr[i])) {
                    int j = i;
                    int res = 0;
                    for (; j < arr.length; j++) {
                        if (!Character.isDigit(arr[j])) break;
                        res = res * 10 + (arr[j] - '0');
                    }
                    i = j - 1;
                    nums.push(res);
                } else if (arr[i] == '[') {
                    vals.push("[");
                } else if (arr[i] == ']') {
                    StringBuilder sb = new StringBuilder();
                    //组合【】中的字符串
                    while (!vals.peek().equals("[")) {
                        sb.insert(0,vals.pop());
                    }
                    //弹出“[”
                    vals.pop();
                    //组合后的字符串*倍数，入栈
                    String str = sb.toString();
                    sb = new StringBuilder();
                    int times = nums.pop();
                    for (int j = 0; j < times; j++) {
                        sb.append(str);
                    }
                    vals.push(sb.toString());
                } else {
                    //找出连续的字母，入栈
                    int j = i;
                    StringBuilder sb = new StringBuilder();
                    for (; j < arr.length; j++) {
                        if (!Character.isLetter(arr[j])) break;
                        sb.append(arr[j]);
                    }
                    i = j - 1;
                    vals.push(sb.toString());
                }
            }
            //返回vals累积
            StringBuilder res=new StringBuilder();
            while(!vals.isEmpty()) res.insert(0,vals.pop());
            return res.toString();
        }
    }
}
