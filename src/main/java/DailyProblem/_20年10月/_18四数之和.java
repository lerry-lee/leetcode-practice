package DailyProblem._20年10月;

import java.util.*;

/**
 * Created by lerry_li on 2020/10/05
 */

/**
 * 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class _18四数之和 {
    /**
     * 解法1：回溯
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> res=new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);

        dfs(nums, 0, 4, target, new ArrayList<>());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void dfs(int[] nums, int t, int count, int target, List<Integer> temp) {
        if (count == 0) {
            if (target == 0) res.add(new ArrayList<>(temp));
            System.out.println(temp + " " + target);
            return;
        }
        for (int i = t; i < nums.length; i++) {
            if (nums[i] * count > target) return;
            if (i > t && nums[i] == nums[t]) continue;
            ;
            temp.add(nums[i]);
            dfs(nums, i + 1, count - 1, target - nums[i], temp);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 解法2：排序+双指针
     */
    public List<List<Integer>> fourSum_2pointer(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int l, r;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                l = j + 1;
                r = nums.length - 1;
                while (l < r) {
                    while (l < r && l > j + 1 && nums[l] == nums[l - 1]) l++;
                    while (l < r && r < nums.length - 1 && nums[r] == nums[r + 1]) r--;
                    int temp = nums[i] + nums[j] + nums[l] + nums[r];
                    if (l < r && temp == target) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r])));
                        l++;
                        r--;
                    } else if (temp < target) l++;
                    else r--;
                }
            }
        }
        return res;
    }
}
