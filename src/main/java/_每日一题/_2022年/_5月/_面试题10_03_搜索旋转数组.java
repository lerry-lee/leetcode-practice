package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/08
 * @Description
 */
public class _面试题10_03_搜索旋转数组 {
    /**
     * 解法1：二分
     */
    class Solution {
        public int search(int[] arr, int target) {
            //特判
            if (arr == null || arr.length == 0) return -1;
            int l = 0, r = arr.length - 1;
            while (l < r) {
                if(arr[l]==target) break;
                int mid = l + (r - l) / 2;
                if (arr[mid] == arr[r]) r--;
                else if (arr[mid] == target) r = mid;
                else if (arr[mid] < arr[r]) {
                    if (arr[mid] < target && target <= arr[r]) {
                        l = mid + 1;
                    } else {
                        r = mid-1;
                    }
                } else {
                    if (arr[l] <= target && target < arr[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid+1;
                    }
                }
            }
            return arr[l] == target ? l : -1;
        }
    }
}
