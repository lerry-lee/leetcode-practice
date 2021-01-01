package _每日一题._2020年._20年11月;

/**
 * @ClassName: _941有效的山脉数组
 * @Signature: Created by lerry_li on 2020/11/03
 * @Description:
 */
public class _941有效的山脉数组 {
    /**
     * 解法1：简单遍历 时间O(N) 空间O(1)
     * 必须包含上升和下降，不能有平地
     */
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        boolean up = false, down = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (down) {
                    return false;
                }
                up = true;
            } else if (A[i] == A[i - 1]) {
                return false;
            } else {
                if (up) {
                    down = true;
                } else {
                    return false;
                }
            }
        }
        return up && down;
    }

    /**
     * 解法2：递增扫描+递减扫描 时间O(N) 空间O(1)
     * 最高点不能是数组的第一个位置或最后一个位置
     */
    public boolean validMountainArray2(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }

        int N = A.length;

        int i = 0;

        // 递增扫描
        while (i < N - 1 && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i < N - 1 && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;
    }


    public static void main(String[] args) {
        int[] A = {2, 1};
        int[] A1 = {3, 5, 5};
        int[] A2 = {0, 3, 2, 1};
        int[] A3 = {0, 2, 3, 3, 5, 2, 1, 0};
        System.out.println(new _941有效的山脉数组().validMountainArray(A));
        System.out.println(new _941有效的山脉数组().validMountainArray(A1));
        System.out.println(new _941有效的山脉数组().validMountainArray(A2));
        System.out.println(new _941有效的山脉数组().validMountainArray(A3));
    }
}
