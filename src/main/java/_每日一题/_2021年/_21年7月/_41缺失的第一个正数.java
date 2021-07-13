package _每日一题._2021年._21年7月;

/**
 * @ClassName: _41缺失的第一个正数
 * @Author: lerry_li
 * @CreateTime: 2021/07/13
 * @Description
 * 解法1：计数置换
 * 解法2：原地哈希
 */
public class _41缺失的第一个正数 {

    public static void main(String[] args) {
        _41缺失的第一个正数 instance = new _41缺失的第一个正数();
        System.out.println(instance.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    /**
     * 解法1：计数置换
     */
    public int firstMissingPositive1(int[] nums) {
        //特判
        if (nums == null || nums.length == 0) return 1;
        //原地计数置换，每个数num放到下标为num-1的位置
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (nums[i] <= n && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        //遍历找第一个不符合计数的
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    /**
     * 解法2：原地哈希
     */
    public int firstMissingPositive(int[] nums) {
        //特判
        if (nums == null || nums.length == 0) return 1;
        //负数变正
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) nums[i] = n + 1;

        }
        //哈希
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        //遍历找第一个为正数的
        for (int i = 0; i < n; i++) {
            if (nums[i]>0) return i + 1;
        }
        return n + 1;
    }
}
