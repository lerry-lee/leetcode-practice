package _每日一题._2020年._20年12月;

/**
 * @ClassName: _860柠檬水找零
 * @Author: lerry_li
 * @CreateDate: 2020/12/18
 * @Description
 */
public class _860柠檬水找零 {
    /**
     * 解法1：简单模拟
     */
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }
        int count5 = 0;
        int count10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            } else if (bill == 10) {
                count5--;
                count10++;
            } else {
                if (count10 > 0) {
                    count10--;
                    count5--;
                } else {
                    count5 -= 3;
                }
            }
            if (count5 < 0) {
                return false;
            }
        }
        return true;
    }
}
