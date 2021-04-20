package _每日一题._2021年._21年4月;

/**
 * @ClassName: _28实现strStr
 * @Author: lerry_li
 * @CreateDate: 2021/04/20
 * @Description
 * 解法1：枚举
 * 解法2：KMP算法 TODO
 */
public class _28实现strStr {

    public static void main(String[] args) {
        _28实现strStr instance = new _28实现strStr();
        System.out.println(instance.strStr("hello", "ll"));//2
        System.out.println(instance.strStr("aaaaa", "bba"));//-1
        System.out.println(instance.strStr("hello", ""));//0
    }

    /**
     * 解法1：枚举 时间O((N-M)*M) 空间O(1) N-M为枚举的时间 M为比较的时间
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int len1 = haystack.length(), len2 = needle.length();
        if (len1 < len2) {
            return -1;
        }
        if (len2 == 0) {
            return 0;
        }
        int left = 0, right = len2;
        while (right <= len1) {
            if (haystack.substring(left, right).equals(needle)) {
                return left;
            }
            left++;
            right++;
        }

        return -1;
    }
}
