package _每日一题._2021年._21年2月;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _995K连续位的最小翻转次数
 * @Author: lerry_li
 * @CreateTime: 2021/02/18
 * @Description
 */
public class _995K连续位的最小翻转次数 {
    /**
     * 解法1：暴力 时间O(NK) 空间O(1)
     * 思路：
     *      遇到0就反转K位
     */
    public int minKBitFlips(int[] A, int K) {
        if (A == null || A.length == 0 || K <= 0) {
            return 0;
        }
        int left = 0, right = K - 1;
        int res = 0;
        while (right < A.length) {
            if (A[left] == 1) {
                left++;
                right++;
                continue;
            }
            for (int i = left; i <= right; i++) {
                if (A[i] == 0) {
                    A[i] = 1;
                } else {
                    A[i] = 0;
                }
            }
            res++;
        }
        for (int j : A) {
            if (j == 0) {
                return -1;
            }
        }
        return res;
    }

    /**
     * 解法2：差分数组 时间O(N) 空间O(N)
     */
    public int minKBitFlips2(int[] A, int K) {
        if (A == null || A.length == 0 || K <= 0) {
            return 0;
        }
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        return ans;
    }

    /**
     * 解法3：滑动窗口 时间O(N) 空间O(1)
     */
    public int minKBitFlips3(int[] A, int K) {
        int n = A.length;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= K && A[i - K] > 1) {
                revCnt ^= 1;
                A[i - K] -= 2; // 复原数组元素，若允许修改数组 A，则可以省略
            }
            if (A[i] == revCnt) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                A[i] += 2;
            }
        }
        return ans;
    }

    /**
     * 解法4：滑动窗口 时间O(N) 空间O(K)
     * 思路：
     * 我们使用队列模拟滑动窗口，该滑动窗口的含义是前面 K−1 个元素中，以哪些位置起始的 子区间进行了翻转。
     * 该滑动窗口从左向右滑动，如果当前位置 i 需要翻转，则把该位置存储到队列中。
     * 遍历到新位置 j(j<i+K) 时，队列中元素的个数代表了 i 被前面 K−1 个元素翻转的次数。
     */
    public int minKBitFlips4(int[] A, int K) {
        int n = A.length;
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && i >= queue.peek() + K) {
                queue.poll();
            }
            int size = queue.size();
            //当 i 位置被翻转了偶数次，如果 A[i] 为 0，那么翻转后仍是 0，当前元素需要翻转；
            //当 i 位置被翻转了奇数次，如果 A[i] 为 1，那么翻转后是 0，当前元素需要翻转
            if (size % 2 == A[i]) {
                //当 i + K > Ni+K>N 时，说明需要翻转大小为 K 的子区间，
                //但是后面剩余的元素不到 K 个了，所以返回 -1。
                if (i + K > n) {
                    return -1;
                }
                ans++;
                queue.offer(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _995K连续位的最小翻转次数 instance = new _995K连续位的最小翻转次数();
        int[] A = {0, 1, 0};
        System.out.println(instance.minKBitFlips2(A, 1));
        int[] A1 = {1, 1, 0};
        System.out.println(instance.minKBitFlips2(A1, 2));
        int[] A2 = {0, 0, 0, 1, 0, 1, 1, 0};
        System.out.println(instance.minKBitFlips2(A2, 3));
    }
}
