package _每日一题._2021年._21年2月;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: _697数组的度
 * @Author: lerry_li
 * @CreateTime: 2021/02/20
 * @Description
 */
public class _697数组的度 {
    /**
     * 解法1：哈希表 时间O(N) 空间O(N)
     */
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //先求出数组的度
        int du = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        //找出频数最大值
        for (int key : hashMap.keySet()) {
            du = Math.max(du, hashMap.get(key));
        }
        //保存du对应的数
        Set<Integer> hashSet = new HashSet<>();
        for (int key : hashMap.keySet()) {
            if (hashMap.get(key) == du) {
                hashSet.add(key);
            }
        }
        //然后遍历数组，找到du对应的数开始和结束的下标
        Map<Integer, int[]> duNumsStartEnd = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                if (duNumsStartEnd.containsKey(nums[i])) {
                    duNumsStartEnd.get(nums[i])[1] = i;
                } else {
                    int[] startEnd = new int[2];
                    startEnd[0] = i;
                    startEnd[1] = i;
                    duNumsStartEnd.put(nums[i], startEnd);
                }
            }
        }
        //求最小差值
        int res = nums.length;
        for (int key : duNumsStartEnd.keySet()) {
            int[] val = duNumsStartEnd.get(key);
            res = Math.min(res, val[1] - val[0]);
        }
        return res+1;
    }

    public static void main(String[] args) {
        _697数组的度 instance=new _697数组的度();
        int[] nums1={1, 2, 2, 3, 1};
        System.out.println(instance.findShortestSubArray(nums1));
        int[] nums2={1,2,2,3,1,4,2};
        System.out.println(instance.findShortestSubArray(nums2));
    }
}
