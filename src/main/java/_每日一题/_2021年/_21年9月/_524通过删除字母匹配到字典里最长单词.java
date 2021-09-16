package _每日一题._2021年._21年9月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/14
 */
public class _524通过删除字母匹配到字典里最长单词 {

    public static void main(String[] args) {
        _524通过删除字母匹配到字典里最长单词 instance = new _524通过删除字母匹配到字典里最长单词();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");
        System.out.println(instance.findLongestWord2("abpcplea", dictionary));
    }

    /**
     * 解法1：暴力模拟 时间O(N*(len1+len2)) 空间O(1)
     *      len1为s的长度，len2为字典里单词的平均长度
     *
     *  优化思路：对字典按单词长度降序排列，若长度相同则按字典序排列，这样可以优化遍历次数
     */
    public String findLongestWord(String s, List<String> dictionary) {
        if (s == null || s.length() == 0 || dictionary == null || dictionary.size() == 0) {
            return "";
        }
        //统计s字母频数
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int bestI = -1;
        for (int i = 0; i < dictionary.size(); i++) {
            String word = dictionary.get(i);
            int maxLength = bestI == -1 ? 0 : dictionary.get(bestI).length();
            if (word.length() < maxLength) {
                continue;
            }
            int length = isValid(s, word);
            if (length > maxLength) {
                bestI = i;
            } else if (length == maxLength) {
                if (word.compareTo(dictionary.get(bestI)) < 0) {
                    bestI = i;
                }
            }
        }
        return bestI == -1 ? "" : dictionary.get(bestI);
    }

    int[] freq = new int[26];

    private int isValid(String s, String word) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            //字母s都没有，直接退出
            if (freq[word.charAt(i) - 'a'] == 0) {
                return -1;
            }
            while (j < s.length() && s.charAt(j) != word.charAt(i)) j++;
            //找不到s中
            if (j == s.length()) {
                return -1;
            }
            i++;
            j++;
        }
        return i == word.length() ? word.length() : -1;
    }

    /**
     * 解法2：动态规划 时间O(sLen * 26 + n * wordLen ) 空间 O(sLen * 26)
     */
    public String findLongestWord2(String s, List<String> dictionary) {
        if (s == null || s.length() == 0 || dictionary == null || dictionary.size() == 0) {
            return "";
        }
        int len = s.length();
        //dp[i][j]表示从s[i]开始，第一次出现字符{j+'a'}的下标位置
        //这样遍历单词和s时，可以加速查找
        int[][] dp = new int[len + 1][26];
        //初始化，最后一行为不可达
        Arrays.fill(dp[len], -1);
        //状态转移：从后往前
        for (int i = len - 1; i >= 0; i--) {
            //枚举所有选择
            for (int j = 0; j < 26; j++) {
                //若当前字符s[i]为{j+'a'}，则dp[][]=i;
                if (s.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                }
                //否则，为dp[i+1][j]
                else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        String bestWord = "";
        //遍历字典
        for (String word : dictionary) {
            int i = 0, j = 0;
            while (j < word.length()) {
                //s中word[j]该字符都没有，那word就不用看了，不可能匹配
                if (dp[i][word.charAt(j) - 'a'] == -1) {
                    break;
                }
                //找到匹配的位置，并跳转到该位置+1继续
                i = dp[i][word.charAt(j) - 'a']+1;
                j++;
            }
            if(j<word.length()){
                continue;
            }
            if (bestWord.length() < word.length() || (bestWord.length() == word.length() && bestWord.compareTo(word) > 0)) {
                bestWord = word;
            }
        }
        return bestWord;
    }
}
