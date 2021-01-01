package _每日一题._2020年._20年11月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _242有效的字母异位词
 * @Author: lerry_li
 * @CreateTime: 2020/11/22
 */
public class _242有效的字母异位词 {
    /**
     * 解法1：哈希表 时间O(N) 空间O(S) N为字符串长度，S为字符集大小（26个字母）
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return s == null && t == null;
        }
        if (s.length() == 0) {
            return t.length() == 0;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!hashMap.containsKey(c)) {
                return false;
            }
            int count = hashMap.get(c);
            if (count == 1) {
                hashMap.remove(c);
            } else {
                hashMap.put(c, count - 1);
            }
        }
        return true;
    }

    /**
     * 解法2：用计数数组代替哈希表 时间O(N) 空间O(S)
     * 由于字符集的大小只有26，可声明长度26的数组，然后统计每个字符的出现次数
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null) {
            return s == null && t == null;
        }
        if (s.length() == 0) {
            return t.length() == 0;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] helper=new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx=s.charAt(i)-'a';
            helper[idx]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int idx=t.charAt(i)-'a';
            helper[idx]--;
            //由于两个字符串中的字符和其个数是相等的，因此抵消的时候，有小于0的就退出
            if(helper[idx]<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _242有效的字母异位词 instance = new _242有效的字母异位词();
        String s = "aaa", t = "aaa";
        System.out.println(instance.isAnagram(s, t));
    }
}
