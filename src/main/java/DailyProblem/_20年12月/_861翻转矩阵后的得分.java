package DailyProblem._20年12月;

import DataStructure.CustomMethod;

/**
 * @ClassName: _861翻转矩阵后的得分
 * @Author: lerry_li
 * @CreateDate: 2020/12/07
 * @Description
 */
public class _861翻转矩阵后的得分 {
    /**
     * 解法1：时间O(MN) 空间O(1)
     * 思路：
     *      翻转行：矩阵的每一行的最左边的数都必须为 1。
     *      翻转列：让每个列中 1 的数目尽可能多。
     *
     */
    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        //使第一列都为1
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                reverse(A, i, 0);
            }
        }
        //使其它列的1比0多
        for (int j = 1; j < A[0].length; j++) {
            int count_0 = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 0) {
                    count_0++;
                }
            }
            if (count_0 > A.length - count_0) {
                reverse(A, j, 1);
            }
        }

        //求和
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int num = 0;
            for (int j = 0; j < A[i].length; j++) {
                num += A[i][j] * Math.pow(2, A[i].length - 1 - j);
            }
            sum += num;
        }

        return sum;

    }

    /**
     * 解法2：解法1优化（只需计算结果，无须真的翻转） 时间O(MN) 空间O(1)
     */
    public int matrixScore2(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        //第0列全是1
        int sum = (int) (A.length * Math.pow(2, A[0].length - 1));
        //第1列开始，每一列的1比0要多，然后加上该列的值
        for (int j = 1; j < A[0].length; j++) {
            int count_1 = 0;
            for (int i = 0; i < A.length; i++) {
                //若未翻转(第0列是1)，则统计该列是1的；否则统计该列是0的
                if ((A[i][0] == 1 && A[i][j] == 1) || (A[i][0] == 0 && A[i][j] == 0)) {
                    count_1++;
                }
            }
            //比较该列0和1的个数
            int count_0 = A.length - count_1;
            if (count_1 > count_0) {
                sum += count_1 * Math.pow(2, A[0].length - 1 - j);
            } else {
                sum += count_0 * Math.pow(2, A[0].length - 1 - j);
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        _861翻转矩阵后的得分 instance = new _861翻转矩阵后的得分();
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(instance.matrixScore2(A));
        CustomMethod.display(A);
    }

    public void reverse(int[][] A, int k, int axis) {
        if (axis == 0) {
            for (int i = 0; i < A[k].length; i++) {
                if (A[k][i] == 0) {
                    A[k][i] = 1;
                } else {
                    A[k][i] = 0;
                }
            }
        } else {
            for (int i = 0; i < A.length; i++) {
                if (A[i][k] == 0) {
                    A[i][k] = 1;
                } else {
                    A[i][k] = 0;
                }
            }
        }
    }
}
