package _每日一题._2021年._21年5月;

import java.util.HashMap;

/**
 * @ClassName: _12整数转罗马数字
 * @Author: lerry_li
 * @CreateDate: 2021/05/14
 * @Description 解法1：递归
 * 解法2：迭代
 */
public class _12整数转罗马数字 {

    public static void main(String[] args) {
        _12整数转罗马数字 instance = new _12整数转罗马数字();
        System.out.println(instance.intToRoman(3));//III
        System.out.println(instance.intToRoman(4));//IV
        System.out.println(instance.intToRoman(9));//IX
        System.out.println(instance.intToRoman(58));//LVIII
        System.out.println(instance.intToRoman(1994));//MCMXCIV
    }

    /**
     * 解法1：递归
     */
    public String intToRoman1(int num) {
        StringBuilder sb = new StringBuilder();
        int digit = 1;
        while (num > 0) {
            sb.insert(0, helper(num % 10 * digit));
            num /= 10;
            digit *= 10;
        }
        return sb.toString();
    }

    int[] key = {1000, 500, 100, 50, 10, 5, 1};
    String[] val = {"M", "D", "C", "L", "X", "V", "I"};

    private String helper(int num) {
        //base case
        if (num == 0) return "";
        else if (num == 4) return "IV";
        else if (num == 9) return "IX";
        else if (num == 40) return "XL";
        else if (num == 90) return "XC";
        else if (num == 400) return "CD";
        else if (num == 900) return "CM";
        //递归求解
        for (int i = 0; i < 7; i++) {
            if (key[i] <= num) {
                return val[i] + helper(num - key[i]);
            }
        }
        return "";
    }

    /**
     * 解法1优化
     */
    public String intToRoman(int num) {
        int[] key1 = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] val1 = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < 13; i++) {
                if (key1[i] <= num) {
                    sb.append(val1[i]);
                    num -= key1[i];
                    break;
                }
            }
        }
        return sb.toString();
    }

    /**
     * 解法2：迭代 时间O(1) 空间O(1)
     */
    public String intToRoman2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

}
