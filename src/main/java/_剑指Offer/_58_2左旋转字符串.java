package _剑指Offer;


import java.util.Scanner;

/**
 * @ClassName: _58_2左旋转字符串
 * @Author: lerry_li
 * @CreateDate: 2020/12/03
 * @Description
 */
public class _58_2左旋转字符串 {
    /**
     * 解法1：字符串切片
     */
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (n < 1 || n >= s.length()) {
            return s;
        }
        return s.substring(n) + s.substring(0, n);
    }


}
