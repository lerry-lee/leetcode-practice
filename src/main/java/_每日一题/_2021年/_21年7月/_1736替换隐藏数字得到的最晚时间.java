package _每日一题._2021年._21年7月;

import java.util.Arrays;

/**
 * @ClassName: _1736替换隐藏数字得到的最晚时间
 * @Author: lerry_li
 * @CreateDate: 2021/07/24
 * @Description
 */
public class _1736替换隐藏数字得到的最晚时间 {
    public String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            if (arr[1] == '?') {
                arr[0] = '2';
                arr[1] = '3';
            } else {
                if (arr[1] <= '3') {
                    arr[0] = '2';
                } else {
                    arr[0] = '1';
                }
            }
        } else {
            if (arr[1] == '?') {
                if (arr[0] == '2') {
                    arr[1] = '3';
                } else {
                    arr[1] = '9';
                }
            }
        }
        if (arr[3] == '?') {

            arr[3] = '5';

        }

        if (arr[4] == '?') {
            arr[4] = '9';
        }

        return new String(arr);
    }
}
