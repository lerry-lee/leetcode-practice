package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/12
 * @Description
 */
public class _剑指Offer_20_表示数值的字符串 {

    public static void main(String[] args) {
        _剑指Offer_20_表示数值的字符串 instance = new _剑指Offer_20_表示数值的字符串();
        String[] trueCases = new String[]{"+100", "5e2", "-123", "3.1416", "-1E-16", "0123", "3.", "46.e3"};
        String[] falseCases = new String[]{"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4", ".-4"};
        System.out.println("true cases:");
        for (String trueCase : trueCases) System.out.println(instance.new Solution().isNumber(trueCase));
        System.out.println("------------------------------------");
        System.out.println("false cases:");
        for (String falseCase : falseCases) System.out.println(instance.new Solution().isNumber(falseCase));
    }

    /**
     * 解法1：按e拆分成左右2部分，分别解析，时间O(N) 空间O(1)
     * 思路：
     *      e的左边可以是整数/小数，e的右边只能是整数
     */
    class Solution {
        public boolean isNumber(String s) {
            //特判
            if (s == null || s.length() == 0) return false;
            //遍历，找e/E
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                //e左边为整数/小数，右边为整数
                if (arr[i] == 'e' || arr[i] == 'E') {
                    return checkNumeric(arr, 0, i - 1, true) && checkInteger(arr, i + 1, arr.length - 1);
                }
            }
            return checkNumeric(arr, 0, arr.length - 1, false);
        }

        //检查是否是整数
        private boolean checkInteger(char[] arr, int l, int r) {
            if (l > r) return false;
            //是否出现正负号
            boolean hasSign = false;
            //是否出现数字
            boolean hasNum = false;
            //跳过末尾的空格
            while (l <= r) {
                if (arr[r] == ' ') {
                    r--;
                } else {
                    break;
                }
            }
            for (int i = l; i <= r; i++) {
                //如果是数字
                if (Character.isDigit(arr[i])) {
                    hasNum = true;
                }
                //如果是正负号
                else if (arr[i] == '+' || arr[i] == '-') {
                    if (hasNum || hasSign) return false;
                    hasSign = true;
                }
                //如果是其他，字母/空格
                else {
                    return false;
                }
            }
            return hasNum;
        }

        //检查是否是数值（整数/小数）
        private boolean checkNumeric(char[] arr, int l, int r, boolean hasE) {
            if (l > r) return false;
            //是否出现正负号
            boolean hasSign = false;
            //是否出现小数点
            boolean hasPoint = false;
            //是否已有数字了
            boolean hasNum = false;
            //跳过开头的空格
            while (l <= r) {
                //空格跳过，空格只能存在于开头
                if (arr[l] == ' ') l++;
                else break;
            }
            //如果有e，末尾不能有空格，否则，末尾可以有空格
            if (!hasE) {
                while (r >= l) {
                    if (arr[r] == ' ') r--;
                    else break;
                }
            }
            for (int i = l; i <= r; i++) {
                //为数字
                if (Character.isDigit(arr[i])) {
                    hasNum = true;
                }
                //为正负号
                else if (arr[i] == '+' || arr[i] == '-') {
                    if (hasNum || hasSign || hasPoint) return false;
                    hasSign = true;
                }
                //为小数点
                else if (arr[i] == '.') {
                    //小数点不能在前面出现过
                    if (hasPoint) return false;
                    hasPoint = true;
                }
                //否则，出现字母、空格直接返回false
                else {
                    return false;
                }
            }
            return hasNum;
        }
    }
}
