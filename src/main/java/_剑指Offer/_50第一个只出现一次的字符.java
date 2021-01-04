package _剑指Offer;

/**
 * @ClassName: _50第一个只出现一次的字符
 * @Author: lerry_li
 * @CreateDate: 2021/01/04
 * @Description
 */
public class _50第一个只出现一次的字符 {
    /**
     * 解法1：两次遍历+计数数组 时间O(N) 空间O(S) S为字符集的大小
     */
    public char firstUniqChar(String s) {
        if(s==null||s.length()==0){
            return ' ';
        }
        int[] chars=new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(chars[c-'a']==1){
                return c;
            }
        }
        return ' ';
    }
}
