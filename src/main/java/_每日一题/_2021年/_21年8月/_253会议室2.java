package _每日一题._2021年._21年8月;

import java.util.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/21
 */
public class _253会议室2 {

    public static void main(String[] args) {
        _253会议室2 instance = new _253会议室2();
        System.out.println(instance.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));//2
        System.out.println(instance.minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));//1
        System.out.println(instance.minMeetingRooms(new int[][]{{1,5}, {8,9},{8,9}}));//2
    }

    /**
     * 解法1：排序+优先队列 时间O(NlongN) 空间O(N)
     */
    public int minMeetingRooms(int[][] intervals) {
        //特判
        if (intervals == null || intervals.length == 0) return 0;
        //按开始时间升序排序，如果开始时间相同，按结束时间升序排序
        Arrays.sort(intervals, (o1, o2) -> {
            {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });
        //存放会议室的优先队列，按会议室的结束时间升序排序
        PriorityQueue<int[]> meetings = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        //第一个会议必须开一间会议室
        meetings.offer(intervals[0]);
        //遍历所有会议（从第2个会议开始）
        for (int i = 1; i < intervals.length; i++) {
            //从优先队列里面取出最早结束的会议室，看看能不能接着用
            int[] meeting=meetings.peek();
            //如果能接着用，就更新该会议室的起止时间，否则需要新开一个会议室
            if(meeting[1]<=intervals[i][0]){
                //因为这个会议室已经被后面的接着用了，相当于之前的起止时间失效了
                meetings.poll();
            }
            // 以当前会议的起止时间添加一个会议室
            //（如果复用前面的会议室，需要更新前面的会议室；如果需要新开，那么新建。因此操作都是一样的）
            meetings.offer(intervals[i]);
        }
        //返回会议室的长度
        return meetings.size();
    }
}
