package _每日一题._2021年._21年5月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _13罗马数字转整数
 * @Author: lerry_li
 * @CreateDate: 2021/05/15
 * @Description
 * 解法1：贪心
 * 解法2：贪心
 */
public class _13罗马数字转整数 {

    public static void main(String[] args) {
        _13罗马数字转整数 instance = new _13罗马数字转整数();
        System.out.println(instance.romanToInt("III"));//3
        System.out.println(instance.romanToInt("IV"));//4
        System.out.println(instance.romanToInt("IX"));//9
        System.out.println(instance.romanToInt("LVIII"));//58
        System.out.println(instance.romanToInt("MCMXCIV"));//1994
    }

    /**
     * 解法1：暴力贪心
     */
    public int romanToInt(String s) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < 13; j++) {
                if (i < chars.length - 1 && romans[j].equals(chars[i] + "" + chars[i + 1])) {
                    res += numbers[j];
                    i++;
                } else if (romans[j].equals(chars[i] + "")) {
                    res += numbers[j];
                }
            }
        }
        return res;
    }

    /**
     * 解法2：贪心 时间O(N) 空间O(N)
     */
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt2(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

}
