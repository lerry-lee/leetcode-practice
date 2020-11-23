package DailyExercises._20年11月;

import DataStructure.CustomMethod;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _1030距离顺序排列矩阵单元格
 * @Signature: Created by lerry_li on 2020/11/17
 * @Description:
 */
public class _1030距离顺序排列矩阵单元格 {
    /**
     * 解法1：BFS 时间O(R*C) 空间O(R*C)
     * 思路：
     * 从[r0,c0]开始，找其上下左右四个单元格，并用visited数组标记已访问
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        if (R < 1 || C < 1 || r0 < 0 || c0 < 0) {
            return new int[][]{};
        }
        boolean[][] visited = new boolean[R][C];
        visited[r0][c0] = true;
        int[][] res = new int[R * C][2];
        res[0] = new int[]{r0, c0};
        int resIdx = 1;
        Deque<int[]> deque = new LinkedList<>();
        deque.offerLast(res[0]);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] temp = deque.pollFirst();
                int r = temp[0], c = temp[1];
                if (r - 1 >= 0 && !visited[r - 1][c]) {
                    visited[r - 1][c] = true;
                    res[resIdx] = new int[]{r - 1, c};
                    deque.offerLast(res[resIdx]);
                    resIdx++;
                }
                if (r + 1 < R && !visited[r + 1][c]) {
                    visited[r + 1][c] = true;
                    res[resIdx] = new int[]{r + 1, c};
                    deque.offerLast(res[resIdx]);
                    resIdx++;
                }
                if (c - 1 >= 0 && !visited[r][c - 1]) {
                    visited[r][c - 1] = true;
                    res[resIdx] = new int[]{r, c - 1};
                    deque.offerLast(res[resIdx]);
                    resIdx++;
                }
                if (c + 1 < C && !visited[r][c + 1]) {
                    visited[r][c + 1] = true;
                    res[resIdx] = new int[]{r, c + 1};
                    deque.offerLast(res[resIdx]);
                    resIdx++;
                }
            }
        }
        return res;
    }

    /**
     * 解法2：桶排序：每个桶内的距离相等
     * 思路：
     * 1）初始化R+C-2个桶，因为最远距离为R-1+C-1，所以桶的范围是[0,R+C-2]
     * 2）遍历单元格，把距离相等的点放到对应的桶内
     * 3）遍历桶，依次取出
     */
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        if (R < 1 || C < 1 || r0 < 0 || c0 < 0) {
            return new int[][]{};
        }
        List<List<int[]>> bucketList = new ArrayList<>();
        for (int i = 0; i < R + C - 1; i++) {
            bucketList.add(new ArrayList<>());
        }
        bucketList.add(new ArrayList<>());
        bucketList.get(0).add(new int[]{r0, c0});
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == r0 && j == c0) {
                    continue;
                }
                int distance = Math.abs(i - r0) + Math.abs(j - c0);
                bucketList.get(distance).add(new int[]{i, j});
            }
        }
        int[][] res = new int[R * C][2];
        int idx = 0;
        for (List<int[]> temp : bucketList) {
            for (int[] ints : temp) {
                res[idx++] = ints;
            }
        }
        return res;
    }

    /**
     * 解法3：几何法
     */

    public static void main(String[] args) {
        _1030距离顺序排列矩阵单元格 instance = new _1030距离顺序排列矩阵单元格();
        CustomMethod.display(instance.allCellsDistOrder2(1, 2, 0, 0));
        System.out.println();
        CustomMethod.display(instance.allCellsDistOrder2(2, 2, 0, 1));
        System.out.println();
        CustomMethod.display(instance.allCellsDistOrder2(2, 3, 1, 2));
    }
}
