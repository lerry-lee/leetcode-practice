package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/08
 * @Description
 */
public class _剑指Offer66_构建乘积数组 {
    /**
     * 解法1：二维dp
     */
    class Solution {
        public int[] constructArr(int[] a) {
            if (a == null || a.length == 0) return new int[]{};
            int len = a.length;
            int[] leftProduct = new int[len + 1];
            int[] rightProduct = new int[len + 1];
            leftProduct[0] = 1;
            rightProduct[len] = 1;
            for (int i = 1; i <= len; i++) {
                leftProduct[i] = leftProduct[i - 1] * a[i - 1];
            }
            for (int i = len - 1; i >= 0; i--) {
                rightProduct[i] = rightProduct[i + 1] * a[i];
            }
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                res[i] = leftProduct[i] * rightProduct[i+1];
            }
            return res;
        }
    }

    /**
     * 解法2：表格法，比解法1省去了保存[前缀和]和[后缀和]的空间
     */
    class Solution2 {
        public int[] constructArr(int[] a) {
            int len = a.length;
            if(len == 0) return new int[0];
            int[] b = new int[len];
            b[0] = 1;
            int tmp = 1;
            // 计算b：b[i]表示a[0...i-1]的乘积
            for(int i = 1; i < len; i++) {
                b[i] = b[i - 1] * a[i - 1];
            }
            // temp 表示a[i...n-1]的乘积
            for(int i = len - 2; i >= 0; i--) {
                tmp *= a[i + 1];
                b[i] *= tmp;
            }
            return b;
        }
    }
}
