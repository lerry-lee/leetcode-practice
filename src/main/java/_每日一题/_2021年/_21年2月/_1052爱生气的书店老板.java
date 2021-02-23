package _每日一题._2021年._21年2月;

/**
 * @ClassName: _1052爱生气的书店老板
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description
 */
public class _1052爱生气的书店老板 {
    /**
     * 解法1：暴力 时间O(N^2) 空间O(1)
     * 思路：枚举连续 X位变换为0，计算对应customers值，取最大
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if (customers == null || customers.length == 0) {
            return 0;
        }
        int len = customers.length;

        //首先计算一定得到满意的值
        int satisfaction = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                satisfaction += customers[i];
            }
        }
        //然后枚举连续X位变换
        int maxIncrement = 0;
        for (int i = 0; i <= len - X; i++) {
            int temp = 0;
            for (int j = i; j < i + X; j++) {
                if (grumpy[j] == 1) {
                    temp += customers[j];
                }
            }
            maxIncrement = Math.max(maxIncrement, temp);
        }
        return satisfaction + maxIncrement;
    }

    /**
     * 解法2：滑动窗口 时间O(N) 空间O(1)
     */
    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        if (customers == null || customers.length == 0) {
            return 0;
        }
        int len = customers.length;

        //首先计算一定得到满意的值
        int satisfaction = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                satisfaction += customers[i];
            }
        }

        //然后将grumpy[i]=1的值变换成customers[i]的值
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 1) {
                grumpy[i] = customers[i];
            }
        }

        //使用长度为X的滑动窗口计算在数组grumpy的最大值
        int left = 0, right = 0;
        int maxWindVal = 0;
        int windVal = 0;

        while (right < len) {
            if (right - left == X) {
                windVal -= grumpy[left];
                left++;
            }
            windVal += grumpy[right];
            maxWindVal = Math.max(maxWindVal, windVal);
            right++;
        }
        return satisfaction + maxWindVal;
    }

    public static void main(String[] args) {
        _1052爱生气的书店老板 instance = new _1052爱生气的书店老板();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(instance.maxSatisfied2(customers, grumpy, 3));
    }
}
