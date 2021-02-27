package _每日一题._2021年._21年2月;

/**
 * @ClassName: _395至少有K个重复字符的最长子串
 * @Author: lerry_li
 * @CreateDate: 2021/02/27
 * @Description
 */
public class _395至少有K个重复字符的最长子串 {
    /**
     * 解法1：分治
     * 思路：如果一个字符c的频数小于k，那么任何包含c的子字符串都不可能满足条件
     * 1. 使用计数数组统计字符频数
     * 2. 遍历计数数组，若
     *       1）若字符c的频数小于k，则将当前字符串按c分割（如果多个c连续，则按连续的c），然后递归执行本方法
     *       2）当前字符串只要有满足条件1）的，则返回求解的最大长度（递归求子串的结果）
     * 3. 若遍历完计数数组，当前字符串中的所有字符的频数都>=k了，那么返回当前字符串的长度即可
     *
     */
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        return dfs(s, k);
    }

    public int dfs(String str, int k) {
        if (str.length() < k) {
            return 0;
        }
        //计数数组
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            //若有字符的频数小于k，则按该字符分割原字符串
            if (freq[i] > 0 && freq[i] < k) {
                char c = (char) (i + 'a');
                int maxLen = 0;
                for (String s : str.split(String.valueOf(c))) {
                    maxLen = Math.max(maxLen, dfs(s, k));
                }
                //这里有return语句，也就是说，当 当前字符串 中有字符的频数小于k时会返回该maxLen
                return maxLen;
            }
        }
        //若字符串中的所有字符的频数都大于等于k，则返回该字符串的长度
        return str.length();
    }

    public static void main(String[] args) {
        _395至少有K个重复字符的最长子串 instance = new _395至少有K个重复字符的最长子串();
//        System.out.println(instance.longestSubstring("aaabb", 3));
//        System.out.println(instance.longestSubstring("ababbc", 2));
        System.out.println(instance.longestSubstring("bbaaa", 3));
        System.out.println(instance.longestSubstring("bbaaacbd", 3));
    }
}
