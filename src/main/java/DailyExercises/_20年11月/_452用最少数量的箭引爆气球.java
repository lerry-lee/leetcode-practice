package DailyExercises._20年11月;

import DataStructure.CommonMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: _452用最少数量的箭引爆气球
 * @Signature: Created by lerry_li on 2020/11/23
 * @Description:
 */
public class _452用最少数量的箭引爆气球 {
    /**
     * 解法1：排序+合并区间（取交集）
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (o1[1] == o2[1]) {
                        return 0;
                    }
                    return o1[1] > o2[1] ? 1 : -1;
                }
                return o1[0] > o2[0] ? 1 : -1;
            }
        });
//        CommonMethod.display(points, "a");
        for (int i = 0; i < points.length; i++) {
            int[] curr = points[i];
            if (i == 0) {
                list.add(curr);
            } else {
                int[] last = list.get(list.size() - 1);
                if (last[1] < curr[0]) {
                    list.add(curr);
                } else {
                    last[0] = curr[0];
                    if (last[1] > curr[1]) {
                        last[1] = curr[1];
                    }
                }
            }
        }
//        for (int[] em : list) {
//            System.out.print("[" + em[0] + " " + em[1] + "]");
//        }
//        System.out.println();
        return list.size();
    }

    public static void main(String[] args) {
        _452用最少数量的箭引爆气球 instance = new _452用最少数量的箭引爆气球();
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int[][] points2 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points3 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] points4 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] points5 = {{1, 2}};
        int[][] points6 = {{1, 2}, {1, 2}};
        CommonMethod.display(points, "a");
        System.out.println(instance.findMinArrowShots(points6));
    }
}

