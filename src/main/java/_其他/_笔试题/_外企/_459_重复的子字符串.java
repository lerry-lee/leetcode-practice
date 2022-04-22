package _其他._笔试题._外企;

/**
 * @author lerrylee
 * @create 2020/08/24 09:49
 */
public class _459_重复的子字符串 {
    /**
     * 解法1：暴力法 时间复杂度O(n^2) 空间复杂度O(1)
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) return false;
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i != 0) continue;
            String temp = s.substring(0, i);
            int js = i;
            for (int je = js + i; je <= s.length(); je += i) {
                if (!s.substring(js, je).equals(temp)) break;
                if (je == s.length()) return true;
                js = je;
            }
        }
        return false;
    }

    /**
     * 解法2：找规律
     * 若某个子串可以通过重复构成该字符串，那么将其移至末尾，得到的字符串一定和原字符串相等
     */
    public boolean repeatedSubstringPattern_law(String s) {
        if (s == null || s.length() < 2) return false;
        for (int i = 1; i <= s.length() / 2; i++) {
            String s2 = s.substring(i, s.length()) + s.substring(0, i);
            if (s2.equals(s)) return true;
        }
        return false;
    }


    /**
     * 解法3：双倍字符串
     * 假设 s 可由 子串 x 重复 n 次构成，即 s = nx
     * 则有 s+s = 2nx
     * 移除 s+s 开头和结尾的字符，变为 (s+s)[1:-1]，则破坏了开头和结尾的子串 x
     * 此时只剩 2n-2 个子串
     * 若 s 在 (s+s)[1:-1] 中，则有 2n-2 >= n，即 n >= 2
     * 即 s 至少可由 x 重复 2 次构成
     * 否则，n < 2，n 为整数，只能取 1，说明 s 不能由其子串重复多次构成
     */
    public boolean repeatedSubstringPattern_double(String s) {
        if (s == null || s.length() < 2) return false;
        //return (s+s).indexOf(s,1)!=s.length();
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
    /**
     * 解法4：KMP算法
     * TODO
     */

}
