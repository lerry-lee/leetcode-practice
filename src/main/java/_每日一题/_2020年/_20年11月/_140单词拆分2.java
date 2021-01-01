package _每日一题._2020年._20年11月;

import java.util.*;

/**
 * @ClassName: _140单词拆分2
 * @Signature: Created by lerry_li on 2020/11/01
 * @Description: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 */
public class _140单词拆分2 {
    /**
     * 解法1：哈希表存词典+回溯（超时）
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        Set<String> wordSet = new HashSet<>();
        int minWordLength = Integer.MAX_VALUE;
        int maxWordLength = 0;
        for (String word : wordDict) {
            wordSet.add(word);
            minWordLength = Math.min(minWordLength, word.length());
            maxWordLength = Math.max(maxWordLength, word.length());
        }
        dfs(res, wordSet, maxWordLength, minWordLength, new ArrayList<>(), s, 0);
        return res;
    }

    public void dfs(List<String> res, Set<String> wordSet, int maxWordLength, int minWordLength, List<String> temp,
                    String s,
                    int start) {
        if (start >= s.length()) {
            res.add(String.join(" ", temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            //如果截取的字符串长度超过词典中最长的单词的长度，直接返回
            if (i - start + 1 > maxWordLength) {
                return;
            }
            //如果后面剩下的未被截取的字符串长度小于词典中最短的单词的长度，直接返回
            if (s.length() - start < minWordLength) {
                return;
            }
            String str = s.substring(start, i + 1);
            if (wordSet.contains(str)) {
//                System.out.println(str);
                temp.add(str);
                dfs(res, wordSet, maxWordLength, minWordLength, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    /**
     * 解法2：记忆化递归（官方题解）
     */
    public List<String> wordBreak2(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            if (index == length) {
                wordBreaks.add(new LinkedList<String>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        String s = "catsandog";

        System.out.println(new _140单词拆分2().wordBreak(s, wordDict));

    }

}
