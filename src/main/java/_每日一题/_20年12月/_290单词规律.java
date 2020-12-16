package _每日一题._20年12月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _290单词规律
 * @Author: lerry_li
 * @CreateTime: 2020/12/16
 * @Description
 */
public class _290单词规律 {
    /**
     * 解法1：哈希表双向映射 时间O(n+m) 空间O(n+m)
     */
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null || pattern.length() == 0 || s.length() == 0) {
            return false;
        }
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        int n = words.length;
        Map<String, Character> hashMap = new HashMap<>();
        Map<Character, String> hashMap2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            if (!hashMap.containsKey(words[i]) && !hashMap2.containsKey(c)) {
                hashMap.put(words[i], c);
                hashMap2.put(c, words[i]);
            } else if (hashMap.containsKey(words[i])) {
                if (!hashMap.get(words[i]).equals(c)) {
                    return false;
                }
            } else {
                if (!hashMap2.get(c).equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _290单词规律 instance = new _290单词规律();
        String pattern1 = "abba", str1 = "dog cat cat dog";
        String pattern2 = "abba", str2 = "dog cat cat fish";
        String pattern3 = "aaaa", str3 = "dog cat cat dog";
        String pattern4 = "abba", str4 = "dog dog dog dog";
        System.out.println(instance.wordPattern(pattern1, str1));
        System.out.println(instance.wordPattern(pattern2, str2));
        System.out.println(instance.wordPattern(pattern3, str3));
        System.out.println(instance.wordPattern(pattern4, str4));

    }
}
