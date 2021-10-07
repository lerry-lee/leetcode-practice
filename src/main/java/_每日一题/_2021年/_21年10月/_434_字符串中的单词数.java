package _每日一题._2021年._21年10月;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/10/07
 */
public class _434_字符串中的单词数 {

    public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        String[] arr = s.split(" ");
        for (String word : arr) {
            if (word.length() > 0) {
                res++;
            }
        }
        return res;
    }
}
