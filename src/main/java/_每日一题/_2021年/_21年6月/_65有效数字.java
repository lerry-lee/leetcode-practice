package _每日一题._2021年._21年6月;

/**
 * @ClassName: _65有效数字
 * @Author: lerry_li
 * @CreateDate: 2021/06/17
 * @Description
 */
public class _65有效数字 {
    /**
     * 解法1：有限状态机（不会）
     * 解法2：模拟
     */

    class Solution {
        /**
         * 模拟：将字符串以e/E分隔，左侧可以是整数/小数，右侧必须是整数；如果字符串没有e/E，那么整体必须是整数/小数
         */
        public boolean isNumber(String s) {
            int n = s.length();
            char[] arr = s.toCharArray();
            int idx = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 'e' || arr[i] == 'E') {
                    if (idx == -1) idx = i;
                    else return false;
                }
            }
            boolean ans = true;
            if (idx != -1) {
                ans &= check(arr, 0, idx - 1, false);
                ans &= check(arr, idx + 1, n - 1, true);
            } else {
                ans &= check(arr, 0, n - 1, false);
            }
            return ans;
        }

        /**
         * check一个字符串是否是整数/小数
         */
        boolean check(char[] arr, int start, int end, boolean mustInteger) {
            if (start > end) return false;
            //如果开头字符为+/-，合法情况，下标右移一位
            if (arr[start] == '+' || arr[start] == '-') start++;
            //声明两个布尔值，hasDot表示是否有点，hasNum表示是否有数字
            boolean hasDot = false, hasNum = false;
            //遍历字符串
            for (int i = start; i <= end; i++) {
                //如果当前字符为.
                if (arr[i] == '.') {
                    //如果必须为整数/已经有点了，返回false，不合法
                    if (mustInteger || hasDot) return false;
                    //否则，标记hasDot为true
                    hasDot = true;
                }
                //如果当前字符为数字
                else if (arr[i] >= '0' && arr[i] <= '9') {
                    //标记hasNum为true
                    hasNum = true;
                }
                //非数字和点，返回false
                else {
                    return false;
                }
            }
            //遍历结束后，如果整个字符串合法，那么可以正常遍历完，看是否有数字即可
            return hasNum;
        }
    }


    public int make(char c) {
        switch(c) {
            case ' ': return 0;
            case '+':
            case '-': return 1;
            case '.': return 3;
            case 'e': return 4;
            default:
                if(c >= 48 && c <= 57) return 2;
        }
        return -1;
    }

    public boolean isNumber(String s) {
        int state = 0;
        int finals = 0b101101000;
        int[][] transfer = new int[][]{{ 0, 1, 6, 2,-1},
                {-1,-1, 6, 2,-1},
                {-1,-1, 3,-1,-1},
                { 8,-1, 3,-1, 4},
                {-1, 7, 5,-1,-1},
                { 8,-1, 5,-1,-1},
                { 8,-1, 6, 3, 4},
                {-1,-1, 5,-1,-1},
                { 8,-1,-1,-1,-1}};
        char[] ss = s.toCharArray();
        for(int i=0; i < ss.length; ++i) {
            int id = make(ss[i]);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finals & (1 << state)) > 0;
    }

}
