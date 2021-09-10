package _每日一题._2021年._21年9月;


/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/01
 */
public class _165比较版本号 {

    public static void main(String[] args) {
        _165比较版本号 instance = new _165比较版本号();
        System.out.println(instance.compareVersion("1.01", "1.001"));//0
        System.out.println(instance.compareVersion("1.0", "1.0.0"));//0
        System.out.println(instance.compareVersion("0.1", "1.1"));//-1
        System.out.println(instance.compareVersion("1.0.1", "1"));//1
        System.out.println(instance.compareVersion("7.5.2.4", "7.5.3"));//-1
        System.out.println(instance.compareVersion("1.10", "1.1"));//1
    }

    /**
     * 解法1：字符串分割 时间O(N+M) 空间O(N+M)
     */
    public int compareVersion(String version1, String version2) {
        //特判
        if (version1 == null || version1.length() == 0 || version2 == null || version2.length() == 0) return 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int maxLen = Math.max(v1.length, v2.length);
        for (int i = 0; i < maxLen; i++) {
            String str1 = "0", str2 = "0";
            if (v1.length > i) str1 = v1[i];
            if (v2.length > i) str2 = v2[i];
            int checkRes = compare(str1, str2);
            if (checkRes == 1) return 1;
            if (checkRes == -1) return -1;
        }
        return 0;
    }

    private int compare(String str1, String str2) {
        int i = 0, j = 0;
        //去掉前导0
        while (i < str1.length() && str1.charAt(i) == '0') i++;
        while (j < str2.length() && str2.charAt(j) == '0') j++;
        //特判
        if (i == str1.length()) return j == str2.length() ? 0 : -1;
        if (j == str2.length()) return 1;
        //先比较长度
        int len1 = str1.length() - i, len2 = str2.length() - j;
        if (len1 > len2) return 1;
        else if (len2 > len1) return -1;
        //长度相等，挨个字符比较
        while (i < str1.length()) {
            if (str1.charAt(i) > str2.charAt(j)) return 1;
            else if (str1.charAt(i) < str2.charAt(j)) return -1;
            i++;
            j++;
        }
        return 0;
    }
}
