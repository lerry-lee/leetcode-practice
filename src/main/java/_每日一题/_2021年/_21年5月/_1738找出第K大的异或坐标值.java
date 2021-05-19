package _每日一题._2021年._21年5月;

import java.util.PriorityQueue;

/**
 * @ClassName: _1738找出第K大的异或坐标值
 * @Author: lerry_li
 * @CreateDate: 2021/05/19
 * @Description
 * 解法1：二维前缀和+最小堆
 */
public class _1738找出第K大的异或坐标值 {

    public static void main(String[] args) {
        _1738找出第K大的异或坐标值 instance = new _1738找出第K大的异或坐标值();
        System.out.println(instance.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));//7
        System.out.println(instance.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2));//5
        System.out.println(instance.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3));//4
        System.out.println(instance.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 4));//0
        System.out.println(instance.kthLargestValue(new int[][]{{3,10,9,5,5,7},{0,1,7,3,8,1},{9,3,0,6,1,6},{10,2,9,10,10,7}}, 18));//0
    }

    /**
     * 解法1：二维前缀和+最小堆 时间(MNlogK) 空间O(MN)
     */
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        //最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //二维前缀和
        int[][] xor = new int[m][n];
        xor[0][0] = matrix[0][0];
        minHeap.offer(xor[0][0]);
        //首列
        for (int i = 1; i < m; i++) {
            xor[i][0] = xor[i - 1][0] ^ matrix[i][0];
            minHeap.offer(xor[i][0]);
            if (minHeap.size() > k) minHeap.poll();
        }
        //首行
        for (int i = 1; i < n; i++) {
            xor[0][i] = xor[0][i - 1] ^ matrix[0][i];
            minHeap.offer(xor[0][i]);
            if (minHeap.size() > k) minHeap.poll();
        }
        //填充其他行列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                xor[i][j] = xor[i - 1][j] ^ xor[i][j - 1] ^ xor[i - 1][j - 1] ^ matrix[i][j];
                minHeap.offer(xor[i][j]);
                if (minHeap.size() > k) minHeap.poll();
            }
        }

        return minHeap.poll();
    }
}
