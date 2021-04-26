package _每日一题._2021年._21年4月;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName: _1011在D天内送达包裹的能力
 * @Author: lerry_li
 * @CreateDate: 2021/04/26
 * @Description
 * 解法1：二分搜索
 */
public class _1011在D天内送达包裹的能力 {

    public static void main(String[] args) {
        _1011在D天内送达包裹的能力 instance = new _1011在D天内送达包裹的能力();
        System.out.println(instance.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(instance.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
    }

    /**
     * 解法1：二分搜索 时间O(NlogW) 空间O(1) W为数组元素和，N为数组长度
     * 思路：
     *      计算运载能力capacity的边界[left,right]，然后枚举运载能力capacity。（只不过是用二分搜索）
     */
    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0 || D <= 0) {
            return 0;
        }
        // 确定二分查找左右边界
        // left表示数组元素最大值，即每个货物单独使用运送，船的运载能力至少需要承受最重货物的重量
        // right表示数组元素和，即所有货物一次运送，船的运载能力至多需要承受所有货物的总重量
        int leftCapacity = Arrays.stream(weights).max().getAsInt(), rightCapacity = Arrays.stream(weights).sum();
        // 二分搜索[leftCapacity,rightCapacity]，找到运载能力的最小值（抛开二分，就是枚举left~right的所有值，当有一个值满足要求时就是最小值）
        while (leftCapacity < rightCapacity) {
            //mid为运载能力的中值
            int midCapacity = (leftCapacity + rightCapacity) / 2;
            // days 为需要运送的天数
            // curCapacity 为当前这一天已经运送的包裹重量之和
            int days = 1, curCapacity = 0;
            //遍历所有包裹
            for (int weight : weights) {
                //若当前运送的包裹重量超过了mid，则需要加1天，并更新cur为weight
                if (curCapacity + weight > midCapacity) {
                    ++days;
                    curCapacity = 0;
                }
                curCapacity += weight;
            }
            //若need小于等于约束天数D，则说明在mid运载能力下可以完成D天内的约束，则在[leftCapacity,midCapacity]这个区间内继续二分搜索
            if (days <= D) {
                //右边界right更新为mid
                rightCapacity = midCapacity;
            }
            //否则，need超过D，左边界left更新为mid+1，则在[midCapacity+1,rightCapacity]这个区间内继续二分搜索
            else {
                leftCapacity = midCapacity + 1;
            }
        }
        //最终返回left
        return leftCapacity;
    }

}
