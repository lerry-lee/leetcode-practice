package _每日一题._2021年._21年6月;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: _149直线上最多的点数
 * @Author: lerry_li
 * @CreateDate: 2021/06/27
 * @Description
 */
public class _149直线上最多的点数 {
    /**
     * 解法1：暴力
     */
    public int maxPoints(int[][] points) {
        //特判
        if (points == null || points.length == 0 || points[0].length == 0) return 0;
        if (points.length == 1) return 1;
        //保存任意2点之间的斜率<斜率k，点的下标>
        Map<Double, HashSet<Integer>> hashMap = new HashMap<>();
        //单独统计斜率为0和斜率不存在的情况
        Map<Integer, HashSet<Integer>> k0Map = new HashMap<>();
        Map<Integer, HashSet<Integer>> kNoneMap = new HashMap<>();
        //算过的点记录下来
        Set<Integer> visited = new HashSet<>();
        //遍历
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (visited.contains(i) && visited.contains(j)) continue;
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                //斜率为0的情况，此时y相同，保存y的信息
                if (y1 == y2) {
                    if (k0Map.containsKey(y1)) {
                        k0Map.get(y1).add(i);
                        k0Map.get(y1).add(j);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(i);
                        set.add(j);
                        k0Map.put(y1, set);
                    }
                }
                //斜率不存在的情况，此时x相同，保存x的信息
                else if (x1 == x2) {
                    if (kNoneMap.containsKey(x1)) {
                        kNoneMap.get(x1).add(i);
                        kNoneMap.get(x1).add(j);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(i);
                        set.add(j);
                        kNoneMap.put(x1, set);
                    }
                }
                //斜率存在的情况，假设斜率为k
                else {
                    double k = (y1 - y2) * 1.0 / (x1 - x2);
                    HashSet<Integer> pointsSet;
                    //若之前有斜率为k的线，则判断是否加入
                    if (hashMap.containsKey(k)) {
                        pointsSet = hashMap.get(k);
                    } else pointsSet = new HashSet<>();
                    pointsSet.add(i);
                    pointsSet.add(j);
                    hashMap.put(k, pointsSet);
                }
                visited.add(i);
                visited.add(j);
            }
        }
//        System.out.println(hashMap);
        //遍历map，找最大
        int count = 0;
        for (double k : hashMap.keySet()) {
            count = Math.max(count, hashMap.get(k).size());
        }
        for (double k : k0Map.keySet()) {
            count = Math.max(count, k0Map.get(k).size());
        }
        for (double k : kNoneMap.keySet()) {
            count = Math.max(count, kNoneMap.get(k).size());
        }
        return count;
    }

    /**
     * 官解
     */
    class Solution {
        public int maxPoints(int[][] points) {
            int n = points.length;
            if (n <= 2) {
                return n;
            }
            int ret = 0;
            for (int i = 0; i < n; i++) {
                if (ret >= n - i || ret > n / 2) {
                    break;
                }
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int j = i + 1; j < n; j++) {
                    int x = points[i][0] - points[j][0];
                    int y = points[i][1] - points[j][1];
                    if (x == 0) {
                        y = 1;
                    } else if (y == 0) {
                        x = 1;
                    } else {
                        if (y < 0) {
                            x = -x;
                            y = -y;
                        }
                        int gcdXY = gcd(Math.abs(x), Math.abs(y));
                        x /= gcdXY;
                        y /= gcdXY;
                    }
                    int key = y + x * 20001;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
                int maxn = 0;
                for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                    int num = entry.getValue();
                    maxn = Math.max(maxn, num + 1);
                }
                ret = Math.max(ret, maxn);
            }
            return ret;
        }

        public int gcd(int a, int b) {
            return b != 0 ? gcd(b, a % b) : a;
        }
    }

}
