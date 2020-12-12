package _每日一题._20年10月;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lerry_li on 2020/10/28
 */

/**
 * 独一无二的出现次数
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 */
public class _1207独一无二的出现次数 {
    /**
     * 解法1：排序+hashSet计数 时间O(NlogN) 空间O(N)
     */
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) return true;
        Arrays.sort(arr);
        Set<Integer> hashSet = new HashSet<>();
        int cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                continue;
            }
            if (arr[i] == arr[i - 1]) {
                cnt++;
            } else {
                if (hashSet.contains(cnt)) {
                    return false;
                }
                hashSet.add(cnt);
                cnt = 1;
            }
        }
        return !hashSet.contains(cnt);
    }
    /**
     * 解法2：哈希map计数+哈希set判重 时间O(N) 空间O(N)
     */
}
