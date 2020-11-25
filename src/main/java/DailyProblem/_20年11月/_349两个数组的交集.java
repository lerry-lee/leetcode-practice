package DailyProblem._20年11月;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _349两个数组的交集
 * @Signature: Created by lerry_li on 2020/11/02
 * @Description: 给定两个数组，编写一个函数来计算它们的交集。
 */
public class _349两个数组的交集 {
    /**
     * 解法1：2个哈希表 时间O(M+N) 空间O(min(M,N))
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int n1 : nums1) {
            hashSet.add(n1);
        }
        Set<Integer> intersectionSet = new HashSet<>();
        for (int n2 : nums2) {
            if (hashSet.contains(n2)) {
                intersectionSet.add(n2);
            }
        }
        int[] res = new int[intersectionSet.size()];
        int i = 0;
        for (Integer num : intersectionSet) {
            res[i++] = num;
        }

        return res;
    }
}
