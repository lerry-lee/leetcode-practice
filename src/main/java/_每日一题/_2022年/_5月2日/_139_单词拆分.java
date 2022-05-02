package _每日一题._2022年._5月2日;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _139_单词拆分 {
    /**
     * 解法1：带备忘录的递归+哈希索引单词（前缀枚举）
     */
    class Solution {
        Set<String> wordSet;
        int maxWordLen;
        Boolean[] memo;

        public boolean wordBreak(String s, List<String> wordDict) {
            //特判
            if (s == null || s.length() == 0) return true;
            if (wordDict == null || wordDict.size() == 0) return false;
            wordSet = new HashSet<>();
            maxWordLen = Integer.MIN_VALUE;
            memo = new Boolean[s.length()];
            for (String word : wordDict) {
                wordSet.add(word);
                maxWordLen = Math.max(maxWordLen, word.length());
            }
            return dfs(s, 0);
        }

        private boolean dfs(String s, int t) {
            if (t == s.length()) return true;
            if (memo[t] != null) return memo[t];
            memo[t] = false;
            for (int i = t; i < s.length(); i++) {
                if (i - t + 1 > maxWordLen) break;
                if (wordSet.contains(s.substring(t, i + 1))) {
                    if (dfs(s, i + 1)) {
                        memo[t] = true;
                        break;
                    }
                }
            }
            return memo[t];
        }
    }
}
