package _其他._笔试题._外企;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/24
 */
public class _273_整数转换英文表示 {
    /**
     * 考虑如何实现 num2Str，假设当前需要转换的数字为 xx，我们可以对 xx 的大小进行分情况讨论：
     *
         * x >= 100x>=100：此时首先需要表示成 ??? hundred，表示完后考虑更小的位数；
         * x >= 20x>=20：此时需要表示成 ??? XXX-ty 的形式，表示完后考虑更小的位数；
         * x < 20x<20：直接描述成具体的单词。
     * 实现完 num2Str 后，剩下的只需要考虑如何将入参 numnum 拆分成每三位一组处理即可。
     *
     */
    static String[] num2str_small = {
            "Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    static String[] num2str_medium = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    static String[] num2str_large = {
            "Billion", "Million", "Thousand", "",
    };

    String num2Str(int x) {
        String ans = "";
        if (x >= 100) {
            ans += num2str_small[x / 100] + " Hundred ";
            x %= 100;
        }
        if (x >= 20) {
            ans += num2str_medium[x / 10] + " ";
            x %= 10;
        }
        if (x != 0) ans += num2str_small[x] + " ";
        return ans;
    }

    public String numberToWords(int num) {
        if (num == 0) return num2str_small[0];
        StringBuilder sb = new StringBuilder();
        for (int i = (int) 1e9, j = 0; i >= 1; i /= 1000, j++) {
            if (num < i) continue;
            sb.append(num2Str(num / i) + num2str_large[j] + " ");
            num %= i;
        }
        while (sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
