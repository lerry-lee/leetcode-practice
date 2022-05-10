package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/10
 */
public class _1154_一年中的第几天 {
    /**
     * 解法1：
     *      解析出年year、月month、日day。
     *      预存12个月份的天数，如果是闰年，2月是29天，否则是28天。
     *      把小于month的月，它所对应的天数累加，最后加上day的大小。
     * tips:
     *      闰年判断：①400的倍数或者②4的倍数且不是100的倍数
     */
    class Solution {
        public int dayOfYear(String date) {
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8));

            int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                ++amount[1];
            }

            int ans = 0;
            for (int i = 0; i < month - 1; ++i) {
                ans += amount[i];
            }
            return ans + day;
        }
    }
}
