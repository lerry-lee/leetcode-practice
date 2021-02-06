package _每日一题._2021年._21年2月;

/**
 * @ClassName: _1423可获得的最大点数
 * @Author: lerry_li
 * @CreateTime: 2021/02/06
 * @Description
 */
public class _1423可获得的最大点数 {
    /**
     * 解法1：先全拿左边的，然后依次左边-1，右边+1的拿 时间O(N) 空间O(1)
     */
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints == null || cardPoints.length == 0 || k < 1) {
            return 0;
        }
        int len = cardPoints.length;
        k = Math.min(k, len);

        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp += cardPoints[i];
        }
        int res = temp;
        for (int i = k - 1; i >= 0; i--) {
            temp += cardPoints[(len - 1) - (k - 1 - i)] - cardPoints[i];
            res = Math.max(res, temp);
        }

        return res;
    }

    /**
     * 解法2：滑动窗口 时间O(N) 空间O(1)
     * 思路：
     * 两边拿走K个和最大，剩下中间连续和最小，维护一个n-k的滑动窗口使和最小
     */
    public int maxScore2(int[] cardPoints, int k) {
        if (cardPoints == null || cardPoints.length == 0 || k < 1) {
            return 0;
        }
        int len = cardPoints.length;
        int sum = 0;
        int totalSum = 0;
        for (int i = 0; i < len - k; i++) {
            sum += cardPoints[i];
        }
        for (int i = 0; i < len; i++) {
            totalSum += cardPoints[i];
        }
        //[left,right)左闭右开区间
        int left = 0, right = len - k;
        int res = sum;
        while (right < len) {
            sum -= cardPoints[left];
            sum += cardPoints[right];
            res = Math.min(res, sum);
            left++;
            right++;
        }
        return totalSum - res;
    }

    public static void main(String[] args) {
        _1423可获得的最大点数 instance = new _1423可获得的最大点数();
        System.out.println(instance.maxScore2(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(instance.maxScore2(new int[]{2, 2, 2}, 2));

        System.out.println(instance.maxScore2(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));

        System.out.println(instance.maxScore2(new int[]{1, 1000, 1}, 1));

        System.out.println(instance.maxScore2(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));

    }
}
