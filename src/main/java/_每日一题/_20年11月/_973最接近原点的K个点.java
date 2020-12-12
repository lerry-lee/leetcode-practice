package _每日一题._20年11月;


import java.util.*;

/**
 * @ClassName: _973最接近原点的K个点
 * @Signature: Created by lerry_li on 2020/11/09
 * @Description:
 */
public class _973最接近原点的K个点 {
    /**
     * 解法1：暴力法 时间O(NlogN) 空间O(N)
     */
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || points[0].length == 0 || K <= 0) {
            return new int[][]{};
        }
        double[][] distance_idx = new double[points.length][2];
        for (int i = 0; i < points.length; i++) {
            distance_idx[i][0] = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            distance_idx[i][1] = i;
        }
        Arrays.sort(distance_idx, (o1, o2) -> (int) (100 * (o1[0] - o2[0])));
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[(int) distance_idx[i][1]];
        }
        return res;
    }

    /**
     * 解法1代码优化版：来自官方题解 时间O(NlogN) 空间O(logN)
     */
    public int[][] kClosest1_(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }


    /**
     * 解法2：最小堆 时间O(NlogK) 空间O(K)
     * 最小堆：使用优先队列实现
     */
    public int[][] kClosest2(int[][] points, int K) {
        if (points == null || points.length == 0 || points[0].length == 0 || K <= 0) {
            return new int[][]{};
        }
        PriorityQueue<Double> heap = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                //最小堆,降序
                return (int) (100 * (o2 - o1));
            }
        });
        Map<Double, List<int[]>> hashMap = new HashMap<>();
        for (int[] point : points) {
            double distance = point[0] * point[0] + point[1] * point[1];
            if (hashMap.containsKey(distance)) {
                hashMap.get(distance).add(point);
            } else {
                hashMap.put(distance, new ArrayList<int[]>(Collections.singleton(point)));
            }
            heap.offer(distance);
            if (heap.size() > K) {
                distance = heap.poll();
                List<int[]> temp = hashMap.get(distance);
                if (temp.size() == 1) {
                    hashMap.remove(distance);
                } else {
                    temp.remove(temp.size() - 1);
                }
            }
        }
        int[][] res = new int[K][2];
        int i = 0;
        while (!heap.isEmpty()) {
            double distance = heap.poll();
            List<int[]> temp = hashMap.get(distance);
            res[i++] = temp.get(temp.size() - 1);
            if (temp.size() == 1) {
                hashMap.remove(distance);
            } else {
                temp.remove(temp.size() - 1);
            }
        }
        return res;
    }

    /**
     * 解法2代码优化版：来自官方题解 时间O(NlogK) 空间O(K)
     */
    public int[][] kClosest2_(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                return array2[0] - array1[0];
            }
        });
        for (int i = 0; i < K; ++i) {
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        for (int i = K; i < n; ++i) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < pq.peek()[0]) {
                pq.poll();
                pq.offer(new int[]{dist, i});
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }

}
