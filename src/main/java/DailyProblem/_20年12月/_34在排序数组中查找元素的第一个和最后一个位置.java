package DailyProblem._20年12月;

import DataStructure.CustomMethod;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: _34在排序数组中查找元素的第一个和最后一个位置
 * @Author: lerry_li
 * @CreateDate: 2020/12/01
 * @Description
 */
public class _34在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * 解法1：二分查找+中心扩展
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0, r = nums.length - 1;
        int idx = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                idx = mid;
                break;
            }
            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (idx == -1) {
            return new int[]{-1, -1};
        }
        int i = idx, j = idx;
        while (i >= 0 && nums[i] == target) {
            i--;
        }
        while (j < nums.length && nums[j] == target) {
            j++;
        }
        return new int[]{i + 1, j - 1};
    }

    public static void main(String[] args) {
        Logger log=CustomMethod.getLogger("TRACE_ALL");
        int[] nums={5,7,7,8,8,10};
        log.info("start");
        CustomMethod.display(new _34在排序数组中查找元素的第一个和最后一个位置().searchRange(nums,6));
        log.info("end");
    }
}
