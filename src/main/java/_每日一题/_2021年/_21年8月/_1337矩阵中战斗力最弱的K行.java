package _每日一题._2021年._21年8月;

import java.util.Arrays;

/**
 * @ClassName: _1337矩阵中战斗力最弱的K行
 * @Author: lerry_li
 * @CreateDate: 2021/08/01
 * @Description
 */
public class _1337矩阵中战斗力最弱的K行 {
    /**
     * 解法1：排序 时间O(MlogM) 空间O(M)
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        //特判
        if (mat == null || mat.length == 0 || mat[0].length == 0) return new int[]{};
        int m = mat.length;
        int[][] help = new int[m][2];
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int num : mat[i]) {
                cnt += num;
                if (num == 0) break;
            }
            help[i][0] = cnt;
            help[i][1] = i;
        }
        Arrays.sort(help, ((o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        }));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = help[i][1];
        }
        return res;
    }
}
