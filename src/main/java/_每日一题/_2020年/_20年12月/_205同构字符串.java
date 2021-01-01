package _每日一题._2020年._20年12月;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: _205同构字符串
 * @Author: lerry_li
 * @CreateTime: 2020/12/27
 * @Description
 */
public class _205同构字符串 {
    /**
     * 解法1：两个哈希表双向映射 时间O(N) 空间O(N)
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        int n = s.length();
        Map<Character, Character> hashMap1 = new HashMap<>();
        Map<Character, Character> hashMap2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (!hashMap1.containsKey(c1)) {
                if (!hashMap2.containsKey(c2)) {
                    hashMap1.put(c1, c2);
                    hashMap2.put(c2, c1);
                } else {
                    return false;
                }
            } else {
                if (hashMap1.get(c1) != c2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _205同构字符串 instance=new _205同构字符串();
        Scanner sc=new Scanner(System.in);
        while (true){
            String s=sc.next();
            String t=sc.next();
            System.out.println(instance.isIsomorphic(s,t));
        }
    }
}
