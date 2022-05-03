package _每日一题._2022年._5月3日;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/03
 * @Description
 */
public class _1095_山脉数组中查找目标值 {
    /**
     * 解法1：二分
     * 思路：
     *         第 1 步：先找到山顶元素 mountaintop 所在的下标；
     *         第 2 步：在前有序且升序数组中找 target 所在的下标，如果找到了，就返回，如果没有找到，才执行第 3 步；
     *         第 3 步：如果步骤 2 找不到，就在后有序且降序数组中找 target 所在的下标。
     *
     */
     class Solution {

        public int findInMountainArray(int target, MountainArray mountainArr) {
            int len = mountainArr.length();
            // 查找山顶元素下标
            int peakIndex = findMountainTop(mountainArr, 0, len - 1);
            // 在升序段搜索
            int res = findSortedArray(mountainArr, 0, peakIndex, target);
            if (res != -1) {
                return res;
            }
            // 在降序段搜索
            return findReverseArray(mountainArr, peakIndex + 1, len - 1, target);
        }

        /**
         * 在 降序数组[left..right] 查找 target 的下标
         */
        private int findReverseArray(MountainArray mountainArr, int left, int right, int target) {
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (mountainArr.get(mid) < target) {
                    // 下一轮搜索区间 [left..mid - 1]
                    right = mid - 1;
                } else {
                    // 下一轮搜索区间 [mid..right]
                    // [left..right(mid)]
                    left = mid;
                }
            }

            if (mountainArr.get(left) == target) {
                return left;
            }
            return -1;
        }

        /**
         * 在 升序数组[left..right] 查找 target 的下标
         */
        private int findSortedArray(MountainArray mountainArr, int left, int right, int target) {
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (mountainArr.get(mid) < target) {
                    // 下一轮搜索区间 [mid + 1..right]
                    left = mid + 1;
                } else {
                    // 下一轮搜索区间 [left..mid]
                    right = mid;
                }
            }

            if (mountainArr.get(left) == target) {
                return left;
            }
            return -1;
        }

        /**
         * 在 [left..right] 查找山顶元素的下标
         */
        private int findMountainTop(MountainArray mountainArr, int left, int right) {
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    // 下一轮搜索区间 [mid + 1..right]
                    left = mid + 1;
                } else {
                    // 下一轮搜索区间 [left..mid]
                    right = mid;
                }
            }
            // left == right
            return left;
        }
    }

    class MountainArray{

        public int length() {
            return 0;
        }

        public int get(int mid) {
            return 0;
        }
    }
}
