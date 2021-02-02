package _每日一题._2021年._21年2月;

/**
 * @ClassName: _424替换后的最长重复字符
 * @Author: lerry_li
 * @CreateTime: 2021/02/02
 * @Description
 */
public class _424替换后的最长重复字符 {
    /**
     * 解法1：双指针（滑动窗口） 时间O(N) 空间O(S) S为字符集大小
     */
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        //频数数组
        int[] helper = new int[26];
        //[l,r)左闭右开区间
        int l = 0, r = 0;
        //最多出现的字母的次数（逻辑上是滑动窗口中的字母，实际中更灵活）
        int maxCount = 0;
        while (r < n) {
            //右窗口右移一位
            helper[s.charAt(r) - 'A']++;
            //最大次数判断
            maxCount = Math.max(maxCount, helper[s.charAt(r) - 'A']);
            r++;
            //如果窗口内其他字母不能在k次内被替换
            //窗口内的字母除了出现次数最多的，其他的字母如果在k个及以内，那么都可以被替换成出现次数最多的这个
            if (r - l > maxCount + k) {
                //左窗口右移一位
                helper[s.charAt(l) - 'A']--;
                l++;
            }
        }
        //由于maxCount不减，所以窗口的大小也不减，最终结果窗口的长度为重复字符的最大长度
        return r - l;
    }
}
