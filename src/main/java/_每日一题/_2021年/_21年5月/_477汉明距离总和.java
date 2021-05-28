package _每日一题._2021年._21年5月;

/**
 * @ClassName: _477汉明距离总和
 * @Author: lerry_li
 * @CreateDate: 2021/05/28
 * @Description
 * 解法1：按位统计
 */
public class _477汉明距离总和 {

    public static void main(String[] args) {
        _477汉明距离总和 instance = new _477汉明距离总和();
        System.out.println(instance.totalHammingDistance(new int[]{4, 14, 2}));//6
    }

    /**
     * 解法1：按位统计 时间O(N) 空间O(N)
     * 思路：
     *      对于二进制的每一位，统计该位上的1和0的个数，然后二者相乘，即是该位上的汉明距离总和。
     *      只需遍历32位即可。
     */
    public int totalHammingDistance1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int dist = 0;
        int n = nums.length;
        int[][] digit = new int[n][32];
        for (int k = 0; k < n; k++) {
            int num = nums[k];
            for (int i = 0; i < 32; i++) {
                digit[k][i] = num & 1;
                num >>= 1;
            }
        }
        //遍历位数组
        for (int j = 0; j < 32; j++) {
            int count_1 = 0;
            for (int i = 0; i < n; i++) {
                if (digit[i][j] == 1) count_1++;
            }
            dist += count_1 * (n - count_1);
        }
        return dist;
    }

    /**
     * 解法2：按位统计 时间O(N) 空间O(1)
     */
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int dist = 0;
        int n = nums.length;
        for (int i = 0; i < 32; i++) {
            int count1=0;
            for (int num : nums) {
                num >>= i;
                if((num&1)==1) count1++;
            }
            dist+=count1*(n-count1);
        }
        return dist;
    }
}
