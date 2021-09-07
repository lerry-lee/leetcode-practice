package _每日一题._2021年._21年9月;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/07
 */
public class _1221分割平衡字符串 {
    public static void main(String[] args) {
        _1221分割平衡字符串 instance = new _1221分割平衡字符串();
        System.out.println(instance.balancedStringSplit("RLRRLLRLRL"));
    }

    /**
     * 解法：简单模拟 时间O(n) 空间O(1)
     */
    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int res = 0;
        int balance = 0;
        for (char c : arr) {
            balance += c == 'L' ? -1 : 1;
            if (balance == 0) {
                res++;
            }
        }
        return res;
    }
}
