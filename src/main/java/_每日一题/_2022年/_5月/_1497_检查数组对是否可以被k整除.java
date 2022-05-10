package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/10
 */
public class _1497_检查数组对是否可以被k整除 {
    /**
     * 解法1：取模+哈希 时间O(N) 空间O(N)
     * 思路：
     *      如果两个数字a和b的和a+b可以被k整除，当且仅当a被k整除的余数aR和b被k整除的余数bR之和aR+bR也可以被k整除。
     *      证明：
     *          假设a=k*nA+aR，b=k*nB+bR
     *          已知a+b=k*n，即k*nA+aR+k*nB+bR=k*n
     *          化简，得aR+bR=k*n-k*nA-k*nB
     *                  =k(n-nA-nB)
     *      原假设得证。
     */
    class Solution {
        public boolean canArrange(int[] arr, int k) {
            //由于取模的结果在[0:k-1]因此可以用数组来存
            int[] mod = new int[k];
            //统计余数的频次
            for (int num : arr) {
                //【tips】(num % k + k) % k 这样做可以忽略正负数！！！
                ++mod[(num % k + k) % k];
            }
            //对于当前余数i，只要找到对应的余数k-i即可
            //注意：数量必须配对
            for (int i = 1; i + i < k; ++i) {
                if (mod[i] != mod[k - i]) {
                    return false;
                }
            }
            //最终看模k为0的频次是否是偶数个，因为要两两配对
            return mod[0] % 2 == 0;
        }
    }
}
