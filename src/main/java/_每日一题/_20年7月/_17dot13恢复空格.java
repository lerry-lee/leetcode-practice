package _每日一题._20年7月;

import _数据结构.Trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/09 12:11
 * @description 恢复空格
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t
 * boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary
 * ，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * <p>
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * <p>
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 */
public class _17dot13恢复空格 {
    /**
     * 思路1：动态规划，时间复杂度O(m+n^2)，空间复杂度O(m+n)
     * 1、状态定义：
     * dp[i] 表示字符串的前 i 个字符的最少未匹配数。
     * <p>
     * 2、状态转移：
     * 假设当前我们已经考虑完了前 i-1 个字符了，对于前 i  个字符对应的最少未匹配数：
     * 若第 i 个字符未匹配，则 dp[i + 1] = dp[i] + 1，即不匹配数加 1;
     * 遍历前 i-1 个字符，若以其中某一个下标 idx 为开头、以第 i 个字符为结尾的字符串正好在词典里，则 dp[i] = min(dp[i], dp[idx]) 更新 dp[i]。
     */
    public int respace(String[] dictionary, String sentence) {
        if (dictionary == null || dictionary.length == 0 || sentence.equals("")) return 0;
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx = 0; idx < i; idx++) {
                if (dict.contains(sentence.substring(idx, i))) {
                    dp[i] = Math.min(dp[i], dp[idx]);
                }
            }
        }
        return dp[n];
    }

    /**
     * 思路2：字典树+动态规划
     * TODO
     */
    public int respace_tree(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie root = new Trie();
        for (String word : dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }
}



