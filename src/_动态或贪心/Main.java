package _动态或贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        test_三角形最小路径和();
        long t2 = System.currentTimeMillis();
        System.out.println("执行耗时：" + (t2 - t1) + "ms");
    }

    public static void test_三角形最小路径和(){
        List<List<Integer>> t1=new ArrayList<>();
        List<List<Integer>> t2=new ArrayList<>();

        t1.add(Arrays.asList(2));
        t1.add(Arrays.asList(3,4));
        t1.add(Arrays.asList(6,5,7));
        t1.add(Arrays.asList(4,1,8,3));

        t2.add(Arrays.asList(-1));
        t2.add(Arrays.asList(2,3));
        t2.add(Arrays.asList(1,-1,-3));
        System.out.println(new _三角形最小路径和().minimumTotal_dp2(t1));
    }

    public static void test_最大子序和(){
        int[] a={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new _最大子序和().maxSubArray_divide(a));
    }

    public static void test_最大正方形(){
        char[][] a={{'1','0','1','0' ,'0'},
                {'1','0','1','1' ,'1'},
                {'1','1','1','1' ,'1'},
                {'1','0','0','1' ,'0'}};
        char[][] a1={{'1'}};
        char[][] a3={{'0','1'},{'0','1'}};
        System.out.println(new _最大正方形().maximalSquare(a3));
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
