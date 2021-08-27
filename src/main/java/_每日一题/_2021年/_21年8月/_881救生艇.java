package _每日一题._2021年._21年8月;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/27
 */
public class _881救生艇 {
    /**
     * 解法1：贪心 时间O(NlogN) 空间O(1)
     */
    public int numRescueBoats(int[] people, int limit) {
        //结果：最少船数
        int boatNums = 0;
        //排序
        Arrays.sort(people);
        //light每次选择剩余人员里面最轻的那个
        //heavy每次选择剩余人员里面最重的那个
        int light = 0, heavy = people.length - 1;
        //若剩余人员数量>0，当light==heavy，表示只有1个人了
        while (light <= heavy) {
            //如果最轻的+最重的<=limit，那么将他俩放一个船上
            if (people[light] + people[heavy] <= limit) {
                //表示light已经坐上船了
                light++;
                //表示heavy已经坐上船了
                heavy--;
                //船数+1
                boatNums++;
            }
            //否则，最重的heavy不能和任何人同坐一个船，因此最重的heavy必须单独坐一个船
            else{
                //表示heavy已经坐上船了
                heavy--;
                //船数+1
                boatNums++;
            }
        }
        return boatNums;

    }
}
