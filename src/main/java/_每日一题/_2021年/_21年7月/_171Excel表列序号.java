package _每日一题._2021年._21年7月;

/**
 * @ClassName: _171Excel表列序号
 * @Author: lerry_li
 * @CreateDate: 2021/07/30
 * @Description
 */
public class _171Excel表列序号 {
    /**
     * 解法1:26叉树(26进制转10进制) 时间O(n) 空间O(1)
     */
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int char2number = columnTitle.charAt(i) - 'A' + 1;
            res = res * 26 + char2number;
        }
        return res;
    }
}
