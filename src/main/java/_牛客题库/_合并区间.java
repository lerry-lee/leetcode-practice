package _牛客题库;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: _合并区间
 * @Author: lerry_li
 * @CreateDate: 2021/05/31
 * @Description
 * 解法1：自定义排序+遍历判断
 */
public class _合并区间 {

    public static void main(String[] args) {
        _合并区间 instance = new _合并区间();
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(instance.new Interval(150, 180));
        intervals.add(instance.new Interval(20, 60));
        intervals.add(instance.new Interval(10, 30));
        intervals.add(instance.new Interval(80, 100));
        intervals.add(instance.new Interval(80, 90));
        System.out.println(instance.merge(intervals));
    }

    /**
     * 解法1：自定义排序+遍历判断 时间O(NlogN) 空间O(N)
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return new ArrayList<>();
        int n = intervals.size();
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = intervals.get(i).start;
            array[i][1] = intervals.get(i).end;
        }
        Arrays.sort(array, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });
        for (int[] arr : array) System.out.println(Arrays.toString(arr));

        ArrayList<Interval> res = new ArrayList<>();
        int cnt = -1;
        for (int[] arr : array) {
            //1.res为空或者res最后一个interval的end比当前的start小
            //将当前interval直接添加到res末尾
            if (res.size() == 0 || res.get(cnt).end < arr[0]) {
                res.add(new Interval(arr[0], arr[1]));
                cnt++;
            }
            //2.res最后一个interval的end比当前的end大
            //则当前interval被内含了，跳过
//            else if (res.get(cnt).end > arr[1]) continue;
            //3.res最后一个interval的end比当前的start大，但是比当前的end小
            //则使用当前的end覆盖之前的end
            else if (res.get(cnt).end >= arr[0] && res.get(cnt).end < arr[1]) {
                res.get(cnt).end = arr[1];
            }
        }
        for (Interval interval : res) System.out.println(interval.start + " " + interval.end);
        return res;
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
