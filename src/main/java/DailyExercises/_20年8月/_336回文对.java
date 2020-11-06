package DailyExercises._20年8月;

import java.util.*;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/08/06 16:31
 * @description 回文对
 * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["abcd","dcba","lls","s","sssll"]
 * 输出：[[0,1],[1,0],[3,2],[2,4]]
 * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2：
 * <p>
 * 输入：["bat","tab","cat"]
 * 输出：[[0,1],[1,0]]
 * 解释：可拼接成的回文串为 ["battab","tabbat"]
 */
public class _336回文对 {
    /**
     * 解法1：暴力法(超时) 时间复杂度O(n*n*m) n为数组长度,m为平均字符串长度
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String temp = words[i] + words[j];
                if (isHuiWen(temp)) res.add(Arrays.asList(i, j));
                temp = words[j] + words[i];
                if (isHuiWen(temp)) res.add(Arrays.asList(j, i));
            }
        }
        return res;
    }

    /**
     * 解法2：使用hashMap优化
     * 要组成回文对的情况有三种：
     * 第一，"abc" "cba"，这两个字符串组合起来必然是回文。
     * 第二，"abc(xxxx)" "cba"，这种情况下，只要xxxx为回文，那么组合起来也肯定是回文。
     * 第三，"(xxxx)abc"，"cba" ，这种请你看下，只要xxxx为回文，那么组合起来肯定也是回文。
     * 注意：空串也是回文串
     */
    public List<List<Integer>> palindromePairs_hashMap(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) hashMap.put(words[i], i);

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            for (int j = 0; j < word.length(); j++) {
                String sub_word = word.substring(0, j);
                if (isHuiWen(sub_word)) {
                    String left_word = word.substring(j, word.length());
                    String temp = getReverse(left_word);
                    if (hashMap.containsKey(temp)) {
                        int idx = hashMap.get(temp);
                        if (i != idx) res.add(Arrays.asList(idx, i));
                    }
                }
            }
            for (int j = word.length() - 1; j >= 0; j--) {
                String sub_word = word.substring(j, word.length());
                if (isHuiWen(sub_word)) {
                    String left_word = word.substring(0, j);
                    String temp = getReverse(left_word);
                    if (hashMap.containsKey(temp)) {
                        int idx = hashMap.get(temp);
                        if (i != idx) res.add(Arrays.asList(i, idx));
                    }
                }
            }

            if (word.length() == 0) {
                for (int j = 0; j < words.length; j++) {
                    if (j == i) continue;
                    if (isHuiWen(words[j])) res.add(Arrays.asList(i, j));
                }
            }

        }

        return res;

    }

    public boolean isHuiWen(String s) {
        if (s.length() <= 1) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public String getReverse(String s) {
        StringBuilder s_r = new StringBuilder(s);
        return s_r.reverse().toString();
    }

}
