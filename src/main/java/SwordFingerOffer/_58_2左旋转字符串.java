package SwordFingerOffer;

import DataStructure.CustomMethod;

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

    public static void main(String[] args) {
        _58_2左旋转字符串 instance = new _58_2左旋转字符串();
        Scanner sc = CustomMethod.getScanner();
        while (true) {
            String s = sc.next();
            int n = sc.nextInt();
            System.out.println(instance.reverseLeftWords(s, n));
        }
    }
}
