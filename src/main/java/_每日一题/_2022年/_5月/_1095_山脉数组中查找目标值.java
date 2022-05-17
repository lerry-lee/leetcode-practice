package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/17
 */
public class _1095_山脉数组中查找目标值 {
    /**
     * solution：3 times binary search 时间O(logN) 空间O(1)
     */
    class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            // check null
            if (mountainArr == null) return -1;
            // find the peek
            int peekIdx = binarySearchPeek(mountainArr);
            // search in increasing part
            int targetIdx = binarySearchInIncreasingPart(mountainArr, 0, peekIdx, target);
            if (targetIdx != -1) return targetIdx;
            // search in decreasing part
            return binarySearchIndecreasingPart(mountainArr, peekIdx + 1, mountainArr.length() - 1, target);
        }

        private int binarySearchIndecreasingPart(MountainArray mountainArr, int l, int r, int target) {
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (mountainArr.get(mid) == target) {
                    r = mid;
                } else if (target < mountainArr.get(mid)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (mountainArr.get(l) == target) return l;
            return -1;
        }

        private int binarySearchInIncreasingPart(MountainArray mountainArr, int l, int r, int target) {
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (mountainArr.get(mid) == target) {
                    r = mid;
                } else if (target < mountainArr.get(mid)) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (mountainArr.get(l) == target) return l;
            return -1;
        }

        private int binarySearchPeek(MountainArray mountainArr) {
            int l = 0, r = mountainArr.length() - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

    interface MountainArray {
        public int get(int index);

        public int length();
    }
}
