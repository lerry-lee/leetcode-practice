package _每日一题._2021年._21年8月;

/**
 * @ClassName: _457环形数组是否存在循环
 * @Author: lerry_li
 * @CreateDate: 2021/08/07
 * @Description todo 没看懂
 */
public class _457环形数组是否存在循环 {
    /**
     * 解法1：快慢指针 时间O(N) 空间O(1)
     */
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = next(nums, i);
            // 判断非零且方向相同
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            //访问过的置0
            int add = i;
            while (nums[add] * nums[next(nums, add)] > 0) {
                int tmp = add;
                add = next(nums, add);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    public int next(int[] nums, int cur) {
        int n = nums.length;
        return ((cur + nums[cur]) % n + n) % n; // 因为可能有负数，保证返回值在 [0,n) 中
    }

}
