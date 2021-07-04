package _每日一题._2021年._21年7月;

import java.util.Arrays;

/**
 * @ClassName: _1833雪糕的最大数量
 * @Author: lerry_li
 * @CreateDate: 2021/07/04
 * @Description
 * 解法1：排序
 */
public class _1833雪糕的最大数量 {
    /**
     * 解法1：排序
     */
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i=0;
        for(;i<costs.length;i++){
            coins-=costs[i];
            if(coins<0) break;
        }
        return i;
    }
}
