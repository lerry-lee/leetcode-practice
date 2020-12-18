package _每日一题._20年12月;

/**
 * @ClassName: _389找不同
 * @Author: lerry_li
 * @CreateDate: 2020/12/18
 * @Description
 */
public class _389找不同 {
    /**
     * 解法1：计数
     */
    public char findTheDifference(String s, String t) {
        if(s==null||t==null){
            return ' ';
        }
        int[] helper=new int[26];
        for (int i = 0; i < s.length(); i++) {
            helper[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int idx=t.charAt(i)-'a';
            helper[idx]--;
            if(helper[idx]<0){
                return t.charAt(i);
            }
        }
        return ' ';
    }
}
