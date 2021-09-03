package _其他._笔试题._中金所;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/09/03
 */
public class _数字转英文单词 {

    static String[] one = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String[] twoLessThan20 = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] ten=new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String two(int num) {
        if (num == 0)
            return "";
        else if (num < 10)
            return one[num];
        else if (num < 20)
            return twoLessThan20[num-10];
        else {
            int rest=num%10;
            int tenner = num / 10;
            if (rest != 0)
                return ten[tenner] + " " + one[rest];
            else
                return ten[tenner];
        }
    }

    public String three(int num) {
        int rest=num%100;
        int hundred = num / 100;
        String res = "";
        if (hundred * rest != 0)
            res = one[hundred] + " Hundred " + two(rest);
        else if ((hundred == 0) && (rest != 0))
            res = two(rest);
        else if ((hundred != 0) && (rest == 0))
            res = one[hundred] + " Hundred";
        return res;
    }

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        String result = "";
        if (billion != 0)
            result = three(billion) + " Billion";
        if (million != 0) {
            if (!result.isEmpty())
                result += " ";
            result += three(million) + " Million";
        }
        if (thousand != 0) {
            if (!result.isEmpty())
                result += " ";
            result += three(thousand) + " Thousand";
        }
        if (rest != 0) {
            if (!result.isEmpty())
                result += " ";
            result += three(rest);
        }
        return result;
    }
}
