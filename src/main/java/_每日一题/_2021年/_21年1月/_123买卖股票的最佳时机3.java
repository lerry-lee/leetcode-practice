package _每日一题._2021年._21年1月;

/**
 * @ClassName: _123买卖股票的最佳时机3
 * @Author: lerry_li
 * @CreateDate: 2021/01/09
 * @Description
 */
public class _123买卖股票的最佳时机3 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        return 0;
    }

    public static void main(String[] args) {
        _123买卖股票的最佳时机3 instance = new _123买卖股票的最佳时机3();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices1 = {1, 2, 3, 4, 5};
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(instance.maxProfit(prices));
        System.out.println(instance.maxProfit(prices1));
        System.out.println(instance.maxProfit(prices2));
    }
}
