package _每日一题._2021年._21年8月;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/21
 */
public class _252会议室 {
    /**
     * 解法1：排序 时间O(NlonN) 空间O(1)
     */
    public boolean canAttendMeetings(int[][] intervals) {
        //特判
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (o1, o2) -> {
            {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }
}
