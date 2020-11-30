package DailyProblem._20年11月;

import java.util.Arrays;

/**
 * @ClassName: _767重构字符串
 * @Author: lerry_li
 * @CreateDate: 2020/11/30
 * @Description
 */
public class _767重构字符串 {
    /**
     * 解法1：基于计数的贪心算法（参考题解）
     * 维护偶数下标 \textit{evenIndex}evenIndex 和奇数下标 \textit{oddIndex}oddIndex，初始值分别为 00 和 11。遍历每个字母，根据每个字母的出现次数判断字母应该放置在偶数下标还是奇数下标。
     *
     * 首先考虑是否可以放置在奇数下标。根据上述分析可知，只要字母的出现次数不超过字符串的长度的一半（即出现次数小于或等于 n/2n/2），就可以放置在奇数下标，只有当字母的出现次数超过字符串的长度的一半时，才必须放置在偶数下标。字母的出现次数超过字符串的长度的一半只可能发生在 nn 是奇数的情况下，且最多只有一个字母的出现次数会超过字符串的长度的一半。
     *
     * 因此通过如下操作在重构的字符串中放置字母。
     *
     * 如果字母的出现次数大于 00 且小于或等于 n/2n/2，且 \textit{oddIndex}oddIndex 没有超出数组下标范围，则将字母放置在 \textit{oddIndex}oddIndex，然后将 \textit{oddIndex}oddIndex 的值加 22。
     *
     * 如果字母的出现次数大于 n/2n/2，或 \textit{oddIndex}oddIndex 超出数组下标范围，则将字母放置在 \textit{evenIndex}evenIndex，然后将 \textit{evenIndex}evenIndex 的值加 22。
     *
     * 如果一个字母出现了多次，则重复上述操作，直到该字母全部放置完毕。
     *
     */
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        int n = S.length();
        if (n == 1) {
            return S;
        }

        int maxCount = 0;

        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            int idx = S.charAt(i) - 'a';
            counts[idx]++;
            maxCount = Math.max(maxCount, counts[idx]);
            if (maxCount > (n + 1) / 2) {
                return "";
            }
        }
        char[] reorganizeArray = new char[n];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = n / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < n) {
                reorganizeArray[oddIndex] = c;
                counts[i]--;
                oddIndex += 2;
            }
            while (counts[i] > 0) {
                reorganizeArray[evenIndex] = c;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return new String(reorganizeArray);

    }

    public static void main(String[] args) {
        _767重构字符串 instance = new _767重构字符串();
        System.out.println(instance.reorganizeString("aaabbcc"));
    }

}
