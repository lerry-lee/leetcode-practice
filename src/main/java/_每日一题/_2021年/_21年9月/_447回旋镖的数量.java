package _每日一题._2021年._21年9月;

import java.util.HashMap;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/13
 */
public class _447回旋镖的数量 {

    public static void main(String[] args) {
        _447回旋镖的数量 instance=new _447回旋镖的数量();
        int[][] points=new int[][]{{0,0},{1,0},{2,0}};
        System.out.println(instance.numberOfBoomerangs(points));
    }

    /**
     * 解法1：哈希+枚举(+排列数) 时间O(n^2) 空间O(n)
     */
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int n = points.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Double, Integer> pointI_Map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                double distance = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
                pointI_Map.put(distance, pointI_Map.getOrDefault(distance, 0) + 1);
            }
            for (double distance : pointI_Map.keySet()) {
                int nums = pointI_Map.get(distance);
                res += nums * (nums - 1);
            }
        }
        return res;
    }
}
