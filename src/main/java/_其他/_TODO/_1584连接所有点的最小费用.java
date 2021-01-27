package _其他._TODO;

/**
 * @ClassName: _1584连接所有点的最小费用
 * @Author: lerry_li
 * @CreateDate: 2021/01/27
 * @Description
 */
public class _1584连接所有点的最小费用 {
    /**
     * 解法1：最短路径算法（暴力）
     */
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length < 2 || points[0].length == 0) {
            return 0;
        }
        int minCost = 0;
        int n = points.length;
        int[][] visitedPoints = new int[n][2];
        boolean[] visited = new boolean[n];
        visitedPoints[0] = points[0];
        int visitIdx = 1;
        visited[0] = true;
        while (visitIdx < n) {
            int minVal = Integer.MAX_VALUE;
            int minPointIdx = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                int[] point = points[i];
                int val = Integer.MAX_VALUE;
                for (int j = 0; j < visitIdx; j++) {
                    int[] visitedPoint = visitedPoints[j];
                    val = Math.min(val, Math.abs(point[0] - visitedPoint[0]) + Math.abs(point[1] - visitedPoint[1]));
                }
                if (minVal > val) {
                    minPointIdx = i;
                    minVal = val;
                }
            }

            minCost += minVal;
            visitedPoints[visitIdx] = points[minPointIdx];
            visitIdx++;
            visited[minPointIdx] = true;
        }

        return minCost;
    }

    /**
     * 解法2：prim算法 todo
     */

    public static void main(String[] args) {
        _1584连接所有点的最小费用 instance = new _1584连接所有点的最小费用();
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int[][] points1 = {{3, 12}, {-2, 5}, {-4, 1}};
        int[][] points2 = {{0, 0}, {1, 1}, {1, 0}, {-1, 1}};
        int[][] points3 = {{-1000000, -1000000}, {1000000, 1000000}};
        int[][] points4 = {{0, 0}};
        System.out.println(instance.minCostConnectPoints(points));
        System.out.println(instance.minCostConnectPoints(points1));
        System.out.println(instance.minCostConnectPoints(points2));
        System.out.println(instance.minCostConnectPoints(points3));
        System.out.println(instance.minCostConnectPoints(points4));
    }
}
