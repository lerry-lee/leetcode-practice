package _每日一题._2021年._21年5月;

/**
 * @ClassName: _1482制作m束花所需的最少天数
 * @Author: lerry_li
 * @CreateDate: 2021/05/09
 * @Description
 * 解法1：二分查找
 */
public class _1482制作m束花所需的最少天数 {
    /**
     * 解法1：二分查找 时间O(nlog(high−low)) 空间O(1) 其中n是数组bloomDay的长度，high和low分别是数组bloomDay中的最大值和最小值
     * 思路：
     *      若m*k<数组长度，则一定可以制作
     *      考虑极限情况：当天数为数组最大值时，所有花都开了，则一定可以制作，因此从数组最小值到最大值枚举天数，一定有一个临界点刚好可以
     *      然后采用二分搜索加快迭代
     *
     */
    public int minDays(int[] bloomDay, int m, int k) {
        //特判
        if (m > bloomDay.length / k) {
            return -1;
        }
        //最小值、最大值
        int low = Integer.MAX_VALUE, high = 0;
        int length = bloomDay.length;
        for (int j : bloomDay) {
            low = Math.min(low, j);
            high = Math.max(high, j);
        }
        //二分搜索，时间O(canMake*log(high-low))，canMake函数时间O(N)
        while (low < high) {
            int mid = (high - low) / 2 + low;
            //若可以制作，则区间缩小至[low,mid]
            if (canMake(bloomDay, mid, m, k)) {
                high = mid;
            }
            //否则，不可以制作，区间更改为[mid+1,high]
            else {
                low = mid + 1;
            }
        }
        //最后返回low
        return low;
    }

    /**
     * 判断是否可以制作，在days天内，制作m束花，每束k朵
     */
    public boolean canMake(int[] bloomDay, int days, int m, int k) {
        //花束个数
        int bouquets = 0;
        //每束花的花朵个数
        int flowers = 0;
        int length = bloomDay.length;
        //遍历
        for (int i = 0; i < length && bouquets < m; i++) {
            //若当前花朵在days天内能开放
            if (bloomDay[i] <= days) {
                //花朵个数+1
                flowers++;
                //若花朵个数为k，则可以构成一束花
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            }
            //否则，当前花朵开放周期超过days天，花朵个数重新计数
            else {
                flowers = 0;
            }
        }
        //最终判断花束个数超过m了吗
        return bouquets >= m;
    }
}
