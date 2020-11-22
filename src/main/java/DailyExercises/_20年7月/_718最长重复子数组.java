package DailyExercises._20年7月;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/04 11:13
 * @description 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 */
public class _718最长重复子数组 {
    /**
     * 思路一：滑动两个数组（已解决），时间复杂度：O(M+N)*min(O(M),O(N))外层循环为数组长度，内层循环为数组中较小的长度
     * 思路二：TODO动态规划
     */
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) return 0;
        int res = 0;
        //从数组B的末端开始依次对齐数组A起点，最终数组B的起点对齐数组A的起点
        for (int i = B.length - 1; i >= 0; i--) {
            int pB = i, pA = 0;
            int temp = 0;
            while (pB < B.length && pA < A.length) {
                if (B[pB] == A[pA]) {
                    temp++;
                    res = Math.max(res, temp);
                } else temp = 0;
                pB++;
                pA++;
            }

        }
        //从数组A的末端开始依次对齐数组B起点，最终数组A的起点对齐数组B的起点
        for (int i = A.length - 1; i >= 0; i--) {
            int pA = i, pB = 0;
            int temp = 0;
            while (pA < A.length && pB < B.length) {
                if (B[pB] == A[pA]) {
                    temp++;
                    res = Math.max(res, temp);
                } else temp = 0;
                pB++;
                pA++;
            }

        }
        return res;
    }
}
