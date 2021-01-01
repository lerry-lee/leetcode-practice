package _每日一题._2020年._20年10月;

/**
 * Created by lerry_li on 2020/10/21
 */
public class _925长按键入 {
    /**
     * 解法1：遍历 时间O(M+N) 空间O(1)
     * 实现上，我们使用两个下标i,j追踪name 和typed 的位置。
     * 当name[i]==typed[j]时，i++,j++;
     * 否则，如果typed[j]==typed[j-1]，说明存在一次长按键入，此时只将j++;
     * 否则，不匹配；
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || name.length() == 0) return false;
        int i = 0, j = 0;
        int n1 = name.length(), n2 = typed.length();
        while (i < n1) {
            if (j == n2) return false;
            char c1 = name.charAt(i), c2 = typed.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else if (j > 0 && c2 == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        while (j < n2) {
            if (typed.charAt(j) != typed.charAt(j - 1)) return false;
            j++;
        }
        return true;
    }
}
