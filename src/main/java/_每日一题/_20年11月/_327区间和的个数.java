package _每日一题._20年11月;

/**
 * @ClassName: _327区间和的个数
 * @Signature: Created by lerry_li on 2020/11/07
 * @Description: TODO
 */
public class _327区间和的个数 {
    /**
     * 解法1：暴力法 时间O(N^2) 空间O(1)
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            //防止整数溢出
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 解法2：归并排序
     */

    public int countRangeSum2(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }
        long s = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            sum[i + 1] = s;
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);

    }

    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = (int) sum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = (int) sum[p1++];
                } else {
                    if (sum[p1] < sum[p2]) {
                        sorted[p++] = (int) sum[p1++];
                    } else {
                        sorted[p++] = (int) sum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        _327区间和的个数 instance = new _327区间和的个数();
        int[] nums = {-2, 5, -1};
        System.out.println(instance.countRangeSum(nums, 2, 2));
    }
}
