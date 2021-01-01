package _每日一题._2020年._20年12月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _659分割数组为连续子序列
 * @Author: lerry_li
 * @CreateDate: 2020/12/04
 * @Description
 */
public class _659分割数组为连续子序列 {
    /**
     * 解法1：贪心 时间O(N) 空间O(N)
     * 算法：
     *      定义：首先使用两个哈希 nc和tail
     *          1）nc[i]：存储原数组中数字i出现的次数
     *          2）tail[i]：存储以数字i结尾的且符合题意的连续子序列个数
     *      流程：
     *      1.先去寻找一个长度为3的连续子序列 i, i+1, i+2，
     *          找到后就将 nc[i], nc[i+1], nc[i+2] 中对应数字消耗1个（即-1），
     *          并将 tail[i+2] 加 1，即以 i+2 结尾的子序列个数 +1。
     *      2.如果后续发现有能够接在这个连续子序列的数字 i+3，
     *          则延长以 i+2 为结尾的连续子序列到 i+3，此时消耗 nc[i+3] 一个，
     *          由于子序列已延长，因此tail[i+2] 减 1，tail[i+3] 加 1
     *      在不满足上面的情况下
     *      3.如果 nc[i] 为 0，说明这个数字已经消耗完，可以不管了
     *      4.如果 nc[i] 不为 0，说明这个数字多出来了，且无法组成连续子序列，所以可以直接返回 false 了
     *
     */
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> tail = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int numCount = counts.get(num);
            if (numCount > 0) {
                int tailN = tail.getOrDefault(num - 1, 0);
                if (tailN > 0) {
                    counts.put(num, numCount - 1);
                    tail.put(num - 1, tailN - 1);
                    tail.put(num, tail.getOrDefault(num, 0) + 1);
                } else {
                    int numCount1 = counts.getOrDefault(num + 1, 0);
                    int numCount2 = counts.getOrDefault(num + 2, 0);
                    if (numCount1 > 0 && numCount2 > 0) {
                        counts.put(num, numCount - 1);
                        counts.put(num + 1, numCount1 - 1);
                        counts.put(num + 2, numCount2 - 1);
                        tail.put(num + 2, tail.getOrDefault(num + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _659分割数组为连续子序列 instance = new _659分割数组为连续子序列();
        int[] nums = {1, 2, 3, 4, 4, 5};
        System.out.println(instance.isPossible(nums));
    }
}
