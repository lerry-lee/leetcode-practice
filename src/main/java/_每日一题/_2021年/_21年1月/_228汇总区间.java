package _每日一题._2021年._21年1月;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _228汇总区间
 * @Author: lerry_li
 * @CreateDate: 2021/01/10
 * @Description
 */
public class _228汇总区间 {
    /**
     * solution1: ne traversal
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int start_idx = 0, end_idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                end_idx++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(nums[start_idx]);
                if (start_idx != end_idx) {
                    stringBuilder.append("->").append(nums[end_idx]);
                }
                res.add(stringBuilder.toString());
                start_idx = i;
                end_idx = i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nums[start_idx]);
        if (start_idx != end_idx) {
            stringBuilder.append("->").append(nums[end_idx]);
        }
        res.add(stringBuilder.toString());
        return res;
    }

    public String concat(List<Integer> list, String sep) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : list) {
            stringBuilder.append(i).append(sep);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        _228汇总区间 instance = new _228汇总区间();
        int[] nums = {0, 1, 2, 4, 5, 7};
        int[] nums1 = {0, 2, 3, 4, 6, 8, 9};
        int[] nums2 = {0};
        System.out.println(instance.summaryRanges(nums));
        System.out.println(instance.summaryRanges(nums1));
        System.out.println(instance.summaryRanges(nums2));
    }
}
