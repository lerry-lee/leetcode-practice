package ByteDance._数组与排序;

import java.util.*;

/**
 * @author lerry_ang
 * @description 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @create 2020/06/14 08:28
 */
public class _合并区间 {
    //看了题解，lamda表达式+区间遍历，贼强，简洁高效
    public int[][] merge_(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }


    //各种map,但是时间复杂度低，大概在O(n log n)，排序上
    public int[][] merge(int[][] intervals) {
        List<int[]> helper = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> qujian = new HashMap<>();
        int[] sort_left = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            if(hashMap.containsKey(intervals[i][0])){
                if(intervals[i][1]>hashMap.get(intervals[i][0])){
                    hashMap.put(intervals[i][0], intervals[i][1]);
                }
            }
            else {
                hashMap.put(intervals[i][0], intervals[i][1]);
            }
            sort_left[i] = intervals[i][0];
        }
        Arrays.sort(sort_left);

        display(sort_left);
        display(hashMap);
        int[] new_sort=new int[sort_left.length];
        int j=0;
        for (int i = 0; i < sort_left.length; i++) {
            if (i > 0&&j>0 && sort_left[i] <= qujian.get(new_sort[j-1])) {
                if(hashMap.get(sort_left[i])>qujian.get(new_sort[j-1])){
                    qujian.replace(new_sort[j-1],hashMap.get(sort_left[i]));
                }
//                else qujian.replace(sort_left[i - 1], hashMap.get(sort_left[i]));
            } else {
                new_sort[j++]=sort_left[i];
                qujian.put(sort_left[i], hashMap.get(sort_left[i]));
            }

        }

        display(qujian);
        for(Map.Entry<Integer,Integer> entry:qujian.entrySet()){
            int[] temp={entry.getKey(),entry.getValue()};
            helper.add(temp);
        }
        int[][] res=new int[helper.size()][];
        for(int i=0;i<res.length;i++){
            res[i]=helper.get(i);
        }
        return res;
    }

    public void display(Map<Integer, Integer> hashMap) {
        System.out.println(hashMap);
    }

    public void display(int[] a) {
        for (int num : a) {
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
