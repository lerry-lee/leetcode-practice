package _每日一题._2020年._20年8月;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/08/03 12:02
 * @description 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class _415字符串相加 {
    /**
     * 解法：模拟列竖式相加
     */
    public String addStrings(String num1, String num2) {
        int jin = 0, sum;
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int n1, n2;
        while (i >= 0 || j >= 0) {
            n1 = i >= 0 ? Character.getNumericValue(num1.charAt(i)) : 0;
            n2 = j >= 0 ? Character.getNumericValue(num2.charAt(j)) : 0;
            sum = n1 + n2 + jin;
            jin = sum / 10;
            sum %= 10;
            res.insert(0, String.valueOf(sum));
            i--;
            j--;
        }

        if (jin > 0) res.insert(0, String.valueOf(jin));
        return res.toString();
    }

    /**
     * 接法2：
     *      char转int，char-'0'即可
     */
    public String addStrings2(String num1, String num2) {
        char[] arr1=num1.toCharArray();
        char[] arr2=num2.toCharArray();
        StringBuilder sb=new StringBuilder();
        int i=arr1.length-1,j=arr2.length-1;
        int jin=0,val=0;
        while(i>=0&&j>=0){
            val=(arr1[i]-'0')+(arr2[j]-'0')+jin;
            jin=val/10;
            sb.append(val%=10);
            i--;
            j--;
        }
        while(i>=0){
            val=(arr1[i]-'0')+jin;
            jin=val/10;
            sb.append(val%=10);
            i--;
        }
        while(j>=0){
            val=(arr2[j]-'0')+jin;
            jin=val/10;
            sb.append(val%=10);
            j--;
        }
        if(jin>0){
            sb.append(jin);
        }
        return sb.reverse().toString();
    }
}
