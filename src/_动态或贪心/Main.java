package _动态或贪心;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/18 11:41
 * @description TODO
 */
public class Main {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println("输出：");
        test_买卖股票的最佳时机2();
        long t2 = System.currentTimeMillis();
        System.out.println("执行耗时：" + (t2 - t1) + "ms");
    }

    public static void test_买卖股票的最佳时机2(){
        int[] a = {7, 1, 5, 3, 6, 4};
        int[] a1={7,6,4,3,1};
        int[] a2={1,2,3,4,5};
        System.out.println(new _买卖股票的最佳时机2().maxProfit(a2));
    }

    public static void test_买卖股票的最佳时机() {
        int[] a = {7, 1, 5, 3, 6, 4};
        int[] a1={7,6,4,3,1};
        System.out.println(new _买卖股票的最佳时机().maxProfit_dp(a1));
    }
}
