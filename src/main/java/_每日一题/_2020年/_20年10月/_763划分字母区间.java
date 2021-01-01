package _每日一题._2020年._20年10月;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lerry_li on 2020/10/22
 */
public class _763划分字母区间 {

    /**
     * 解法1/2：贪心+双指针 时间O(N) 空间O(N)
     * 1.首先遍历一遍S，记录每个字母最后出现的下标
     * 2.然后用start和end指针，记录当前区间，遍历S
     * 3. end=Math.max(end,hashMap.get(S.charAt(i)))：end至少要大于当前元素的最后下标
     * 4. 当i==end遍历到第end个元素时，当前区间已经结束，[start,end]添加到res中
     */

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }

    public List<Integer> partitionLabels2(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            hashMap.put(S.charAt(i), i);
        }
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, hashMap.get(S.charAt(i)));
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
