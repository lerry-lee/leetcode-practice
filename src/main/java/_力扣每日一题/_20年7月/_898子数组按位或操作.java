package _力扣每日一题._20年7月;

import java.util.HashSet;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/04 10:13
 * @description 子数组按位或操作
 * 我们有一个非负整数数组 A。
 * <p>
 * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
 * <p>
 * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 */
public class _898子数组按位或操作 {
    /**
     * TODO:暴力法+简单优化，竟然通过了？
     */
    public int subarrayBitwiseORs(int[] A) {
        if (A == null || A.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : A) max |= num;
        set.add(max);
        for (int i = 0; i < A.length; i++) {
            int temp = 0;
            for (int j = i; j < A.length; j++) {
                temp |= A[j];
                if (temp == max) break;
                set.add(temp);
            }
        }
        return set.size();
    }
}
