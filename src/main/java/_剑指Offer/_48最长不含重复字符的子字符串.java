package _剑指Offer;

import java.util.HashSet;

/**
 * @ClassName: _48最长不含重复字符的子字符串
 * @Author: lerry_li
 * @CreateDate: 2021/04/28
 * @Description
 * 解法1：滑动窗口
 * 解法2：动态规划
 */
public class _48最长不含重复字符的子字符串 {

    public static void main(String[] args) {
        _48最长不含重复字符的子字符串 instance = new _48最长不含重复字符的子字符串();
        System.out.println(instance.lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(instance.lengthOfLongestSubstring("bbbbb"));//1
        System.out.println(instance.lengthOfLongestSubstring("pwwkew"));//3
    }

    /**
     * 解法1：滑动窗口 时间O(NS) 空间O(S) S为无重复字符的字符串长度，即字符集的大小
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        //滑动窗口字符统计
        HashSet<Character> hashSet = new HashSet<>();
        //[left,right)
        int left = 0, right = 0;
        int res = 0;
        //开始滑
        while (right < arr.length) {
            if (hashSet.contains(arr[right])) {
                while (arr[left] != arr[right]) {
                    hashSet.remove(arr[left]);
                    left++;
                }
                if (arr[left] == arr[right]) {
                    left++;
                }
            }
            hashSet.add(arr[right]);
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }

    /**
     * 解法2：动态规划 时间O(NS) 空间O(n) S为字符集大小
     * 状态定义：
     *      dp[i]表示以字符s[i]结尾的无重复字符的最长字符串的长度
     * 状态转移：
     *      遍历到s[i]时，枚举dp[i-1]长度内的所有字符j，当s[j]==s[i]时，表示s[j+1]到s[i]可为无重复字符的字符串
     *      dp[i]=i-j
     *  初始化：
     *      dp[0]=1
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            int size = dp[i - 1];
            int j = i - 1;
            for (; j >= i - size; j--) {
                if (arr[i] == arr[j]) {
                    break;
                }
            }
            dp[i] = i - j;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
