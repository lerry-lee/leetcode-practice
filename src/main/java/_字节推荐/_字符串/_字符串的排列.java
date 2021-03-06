package _字节推荐._字符串;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/06/30 11:02
 * @description 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 */
public class _字符串的排列 {

    //hashmap
    public boolean mtd(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() == 0 || s2.length() == 0) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char tempC = s1.charAt(i);
            if (map.containsKey(tempC)) {
                map.put(tempC, map.get(tempC) + 1);
            } else map.put(tempC, 1);
        }
        System.out.println(map);
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            HashMap<Character, Integer> tempMap = new HashMap<>(map);
            for (int j = i; j < i + s1.length(); j++) {
                char tempC = s2.charAt(j);
                System.out.println("i: " + i + " tempC:" + tempC);
                if (tempMap.containsKey(tempC)) {
                    if (tempMap.get(tempC) <= 1) tempMap.remove(tempC);
                    else tempMap.put(tempC, tempMap.get(tempC) - 1);
                } else break;
            }
            if (tempMap.isEmpty()) return true;
        }
        return false;
    }


    //滑动窗口+排序
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        char[] s1_arr = s1.toCharArray();
        Arrays.sort(s1_arr);
        // s1=Arrays.toString(s1_arr);
        for (int i = 0; i < len2 - len1 + 1; i++) {
            char[] s2_arr = s2.substring(i, i + len1).toCharArray();
            Arrays.sort(s2_arr);
            // String win=Arrays.toString(s2_arr);
            //如果win里面的字符和s1的字符一样，也就是说s1有的win都有
            // System.out.print(s1+" "+win);
            if (Arrays.equals(s1_arr, s2_arr)) return true;
        }
        return false;
    }
}
