package _数组与排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * 暴力解法：找出所有的三元组，判断是否满足和为0；时间复杂度C(3,N)，指数级？
 * 解法1：先排序？ 不剪枝会超时,剪枝也会超时= =
 * 解法2:双指针
 * Arrays.asList():将数组转化为list 示例：Arrays.asList(nums)或者Arrays.asList(-1,0,1,2,0,-4,-4)
 */

public class _三数之和 {

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
//        display(nums);
        List<Integer> temp = new ArrayList<>();
        int L, R;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            L = i + 1;
            R = nums.length - 1;
            while (L<R) {
                if (nums[i] + nums[L] + nums[R] == 0) {
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L<R&&nums[L]==nums[L+1]) {
                        L++;
                    }
                    while(L<R&&nums[R]==nums[R-1]) {
                        R--;
                    }
                    L++;
                    R--;

                }
                else if(nums[i] + nums[L] + nums[R] < 0) L++;
                else if(nums[i] + nums[L] + nums[R] > 0) R--;

            }
        }
        return res;
    }

    protected List<Integer> temp;
    protected List<List<Integer>> res;
    protected int[] nums_;

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        display(nums);
        temp = new ArrayList<>();
        res = new ArrayList<>();
        nums_ = nums;
        backTrack(0, nums.length, 0, 0);
        return res;
    }

    public void backTrack(int l, int h, int k, int sum) {
        if (k == 3) {
            if (sum == 0) res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = l; i < h + k - 2; i++) {
            if (i != l && nums_[i] == nums_[i - 1]) {
                continue;
            }
            if (k == 0 && nums_[i] > 0) {
                break;
            }
            if (k == 1 && (sum + nums_[i] + nums_[h - 1] < 0)) break;
            if (k == 2) {
                if (nums_[i] < 0) continue;
//                if(sum+nums_[i]!=0) break;
            }
            temp.add(nums_[i]);
            sum += nums_[i];
            backTrack(i + 1, h, k + 1, sum);
            temp.remove(temp.size() - 1);
            sum -= nums_[i];

        }

    }

    public void display(int[] nums) {
        for (int n : nums) System.out.print(n + " ");
        System.out.println();
    }
}
