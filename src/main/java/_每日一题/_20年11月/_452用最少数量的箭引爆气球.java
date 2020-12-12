package _每日一题._20年11月;

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
     * 解法1：排序+合并区间（取交集） 时间O(NlogN) 空间O(N)
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

    /**
     * 解法2：解法1的空间优化 时间O(NlogN) 空间O(1)
     */
    public int findMinArrowShots2(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return 0;
                }
                return o1[1] > o2[1] ? 1 : -1;
            }
            return o1[0] > o2[0] ? 1 : -1;
        });
        int res = 1;
        int[] last = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            if (last[1] < curr[0]) {
                res++;
                last[0] = curr[0];
                last[1] = curr[1];
            } else {
                last[0] = curr[0];
                if (last[1] > curr[1]) {
                    last[1] = curr[1];
                }
            }
        }

        return res;
    }

    /**
     * 解法3：贪心+排序 参考题解 时间O(NlogN) 空间O(NlogN)
     * 思路：
     *      按右边界升序排序，贪心求交集
     */
    public int findMinArrowShots3(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //按右边界升序排序
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                //相等返回0，左边大于右边返回1，左边小于右边返回-1
                return Integer.compare(point1[1], point2[1]);
            }
        });
        //pos为交集的右边界
        int pos = points[0][1];
        int res = 1;
        //遍历所有区间
        for (int[] curr : points) {
            //若当前区间的左边界>交集的右边界，交集的右边界更新为当前区间的
            if (curr[0] > pos) {
                pos = curr[1];
                res++;
            }
            //否则，说明当前区间的左边界在交集中，右边界>交集的右边界，交集不变
        }
        return res;
    }

    public static void main(String[] args) {
        _452用最少数量的箭引爆气球 instance = new _452用最少数量的箭引爆气球();
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int[][] points2 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points3 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] points4 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] points5 = {{1, 2}};
        int[][] points6 = {{1, 2}, {1, 2}};
        List<int[][]> list = Arrays.asList(points, points2, points3, points4, points5, points6);
        for (int[][] pointsi : list) {
            System.out.println(instance.findMinArrowShots3(pointsi));
        }
    }
}

