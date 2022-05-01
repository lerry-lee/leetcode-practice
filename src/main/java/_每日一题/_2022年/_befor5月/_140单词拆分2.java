package _每日一题._2022年._befor5月;

import java.util.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/25
 */
public class _140单词拆分2 {

    public static void main(String[] args) {
        _140单词拆分2 instance=new _140单词拆分2();
        String s="catsanddog";
        List<String> wordDict=new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        instance.new Solution().wordBreak(s,wordDict);
    }

    /**
     * 解法1：首先动态规划判断是否有解，然后回溯找出所有解
     */
    class Solution {
        Set<String> wordSet;
        boolean[] dp;
        List<String> res;

        public List<String> wordBreak(String s, List<String> wordDict) {
            // 为了快速判断一个单词是否在单词集合中，需要将它们加入哈希表
            wordSet = new HashSet<>(wordDict);
            int len = s.length();

            // 第 1 步：动态规划计算是否有解
            // dp[i] 表示「长度」为 i 的 s 前缀子串可以拆分成 wordDict 中的单词
            // 长度包括 0 ，因此状态数组的长度为 len + 1
            dp = new boolean[len + 1];
            // 0 这个值需要被后面的状态值参考，如果一个单词正好在 wordDict 中，dp[0] 设置成 true 是合理的
            dp[0] = true;

            for (int right = 1; right <= len; right++) {
                // 如果单词集合中的单词长度都不长，从后向前遍历是更快的
                for (int left = right - 1; left >= 0; left--) {
                    // substring 不截取 s[right]，dp[left] 的结果不包含 s[left]
                    if (wordSet.contains(s.substring(left, right)) && dp[left]) {
                        dp[right] = true;
                        // 这个 break 很重要，一旦得到 dp[right] = True ，不必再计算下去
                        break;
                    }
                }
            }

            // 第 2 步：回溯算法搜索所有符合条件的解
            res = new ArrayList<>();
            if (dp[len]) {
                List<String> path = new ArrayList<>();
                dfs(s, len - 1, path);
                return res;
            }
            return res;
        }

        /**
         * s[0:t) 如果可以拆分成 wordSet 中的单词，把递归求解的结果加入 res 中
         *
         * @param s 字符串
         * @param t     索引下标，从右往左移动
         * @param path    从叶子结点到根结点的路径
         */
        private void dfs(String s, int t, List<String> path) {
            if (t == 0) {
                res.add(String.join(" ", path));
                return;
            }

            // 可以拆分的左边界从 t 依次枚举到 0
            for (int i = t; i >= 0; i--) {
                String suffix = s.substring(i, t + 1);
                if (wordSet.contains(suffix) && dp[i]) {
                    path.add(0, suffix);
                    dfs(s, i, path);
                    path.remove(0);
                }
            }
        }
    }
}
