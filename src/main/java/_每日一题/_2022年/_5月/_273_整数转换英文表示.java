package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/15
 * @Description
 */
public class _273_整数转换英文表示 {
    /**
     * 解法1：字符串解析
     */
    class Solution {
        // 0到20的单词数组，下标和单词一一对应
        String[] Zero_Nineteen = {
                "Zero",
                "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        // 20到90的十位单词数组，下标和单词一一对应
        String[] Twenty_Ninety = {
                "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        // 大数单词数组，十亿、百万、千、空[千以内直接解析就行了，没有大数单词了]
        String[] Billion_Million_Thousand = {
                "Billion", "Million", "Thousand", "",
        };

        // 将小于等于3位的数字表示出来，例如123表示为one hundred twenty three
        String numberWith3digitsToEnglishWords(int x) {
            StringBuilder res = new StringBuilder();
            if (x >= 100) {
                // x/100表示取百位的数字
                res.append(Zero_Nineteen[x / 100]).append(" Hundred ");
                x %= 100;
            }
            if (x >= 20) {
                // x/10表示取十位的数字
                res.append(Twenty_Ninety[x / 10]).append(" ");
                x %= 10;
            }
            if (x != 0) {
                // x表示取个位的数字
                res.append(Zero_Nineteen[x]).append(" ");
            }
            return res.toString();
        }

        // 解析整数转化为英文单词的主函数
        public String numberToWords(int num) {
            // 特判
            if (num == 0) return Zero_Nineteen[0];
            StringBuilder sb = new StringBuilder();
            // 每3位处理一次，从十亿开始，十亿=1e9
            for (int i = (int) 1e9, j = 0; i >= 1; i /= 1000, j++) {
                // num比解析的位小时，跳过，位/1000，相当于跳过3位
                if (num < i) continue;
                // num/i表示提取i这个位上的3位以内的数字，进行表示，然后后面接上对应的大数单词
                sb.append(numberWith3digitsToEnglishWords(num / i)).append(Billion_Million_Thousand[j]).append(" ");
                // 处理完num/i，num%i继续做
                num %= i;
            }
            // 去掉最后的空格
            while (sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }

}
