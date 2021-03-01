package _每日一题._2021年._21年3月;

/**
 * @ClassName: _303区域和检索_数组不可变
 * @Author: lerry_li
 * @CreateDate: 2021/03/01
 * @Description
 */
public class _303区域和检索_数组不可变 {

    /**
     * 解法1：前缀和 时间O(N) 空间O(N)
     * 初始化sum数组，第i个元素为nums数组从第0个元素到第i个的和
     * tips: sum数组长度+1位，这样可以直接通过sum[]-sum[]得到某一段区间内的和
     */

    public static void main(String[] args) {
        _303区域和检索_数组不可变 instance = new _303区域和检索_数组不可变();
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    static class NumArray {

        private int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }
}
