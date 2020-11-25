package DailyProblem._20年11月;

import DataStructure.CustomMethod;

/**
 * @ClassName: _1370上升下降字符串
 * @Author: lerry_li
 * @CreateDate: 2020/11/25
 * @Description
 */
public class _1370上升下降字符串 {
    /**
     * 解法1：计数排序 时间O(∣Σ∣×∣s∣) ∣Σ∣为字符集的大小 ∣s∣为字符串的长度 空间O(∣Σ∣)
     */
    public String sortString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        int[] chars = new int[26];
        for (int i = 0; i < n; i++) {
            chars[s.charAt(i) - 'a']++;
        }
        CustomMethod.display(chars);
        int i = 0;
        StringBuilder res = new StringBuilder();

        while (i < n) {

            for (int j = 0; j < 26; j++) {
                if (chars[j] > 0) {
                    res.append((char) (j + 'a'));
                    i++;
                    chars[j]--;
                }
            }
            for (int k = 25; k >= 0; k--) {
                if (chars[k] > 0) {
                    res.append((char) (k + 'a'));
                    i++;
                    chars[k]--;
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        _1370上升下降字符串 instance = new _1370上升下降字符串();
        while (true) {
            String s = CustomMethod.getScanner().next();
            System.out.println(instance.sortString(s));
        }
    }
}
