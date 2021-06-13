package _每日一题._2021年._21年6月;

/**
 * @ClassName: _278第一个错误的版本
 * @Author: lerry_li
 * @CreateDate: 2021/06/13
 * @Description
 * 解法1：二分
 */
public class _278第一个错误的版本 {
    /**
     * 解法1：二分 时间O(logN) 空间O(1)
     */
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private boolean isBadVersion(int mid) {
        return mid == 4;
    }
}
