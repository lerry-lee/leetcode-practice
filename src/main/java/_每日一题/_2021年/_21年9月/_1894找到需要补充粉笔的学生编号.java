package _每日一题._2021年._21年9月;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/10
 */
public class _1894找到需要补充粉笔的学生编号 {
    /**
     * 解法1：暴力模拟 时间O(K) 空间O(1)
     */
    public int chalkReplacer(int[] chalk, int k) {
        int number = 0;
        int n = chalk.length;
        while (k > 0) {
            if (k >= chalk[number]) {
                k -= chalk[number];
                number++;
                number %= n;
            } else {
                break;
            }
        }
        return number;
    }

    /**
     * 解法2：取模 时间O(n) 空间O(1)
     */
    public int chalkReplacer2(int[] chalk, int k) {
        int n = chalk.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += chalk[i];
            if (k >= chalk[i]) {
                k -= chalk[i];
            } else {
                return i;
            }
        }
        k %= sum;
        for (int i = 0; i < n; i++) {
            if (k >= chalk[i]) {
                k -= chalk[i];
            } else {
                return i;
            }
        }
        return -1;
    }

    /**
     * 解法3：前缀和+二分 时间O(n) 空间O(n)
     */
    public int chalkReplacer3(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = chalk[0];
        if (prefixSum[0] > k) return 0;//特判
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + chalk[i];
            //若到某一个i的前缀和超过了k，说明到这粉笔数量不够用了，返回该下标i
            if (prefixSum[i] > k) {
                return i;
            }
        }
        k %= prefixSum[n - 1];
        //二分搜索
        //tips：可以通过遍历，找到第一个满足prefixSum[i]>k的i，也可以通过二分加速搜索
        return binarySearch(prefixSum, k);
    }

    /**
     * 二分搜索，找到第一个比k大的元素，返回其下标
     */
    private int binarySearch(long[] prefixSum, int k) {
        int l = 0, r = prefixSum.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (prefixSum[mid] <= k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        _1894找到需要补充粉笔的学生编号 instance = new _1894找到需要补充粉笔的学生编号();
        System.out.println(instance.chalkReplacer3(new int[]{2, 2, 3}, 1));
    }
}
