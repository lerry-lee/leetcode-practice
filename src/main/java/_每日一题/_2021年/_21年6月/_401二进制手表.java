package _每日一题._2021年._21年6月;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _401二进制手表
 * @Author: lerry_li
 * @CreateDate: 2021/06/27
 * @Description
 * 解法1：枚举时分
 */
public class _401二进制手表 {
    /**
     * 解法1：枚举时分 时间O(1) 空间O(1)
     */
    public List<String> readBinaryWatch(int turnedOn) {

        List<String> res = new ArrayList<>();
        //枚举小时[0,11]
        for (int hour = 0; hour < 12; hour++) {
            //枚举分钟[0,59]
            for (int minute = 0; minute < 60; minute++) {
                //若hour二进制数的1的个数+minute二进制数的1的个数==点亮的灯的个数
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    res.add(hour + ":" + (minute < 10 ? "0" : "") + minute);
                }
            }
        }
        return res;
    }


}
