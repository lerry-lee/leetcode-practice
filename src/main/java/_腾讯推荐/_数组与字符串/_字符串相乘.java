package _腾讯推荐._数组与字符串;

/**
 * @ClassName : _字符串相乘
 * @CreateTime : 2020/09/21 10
 * @Author : lerry_li
 * @Descrpition : 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class _字符串相乘 {
    /**
     * 解法1：模拟列竖式，硬解
     */
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        String res="0";
        int k=0;
        for (int i = num2.length()-1; i >=0; i--) {
            String pro=calProduct(num1,num2.charAt(i),k);
//            System.out.printf("pro:%s res:%s\n",pro,res);
            res=calSum(pro,res);
            k++;
        }
        return res;
    }
    public String calSum(String num1,String num2){
        if(num1.equals("0")) return num2;
        if(num2.equals("0")) return num1;
        StringBuilder stringBuilder=new StringBuilder("");
        int sum=0,jin=0;
        int i=num1.length()-1,j=num2.length()-1;
        while(i>=0&&j>=0){
            sum=(num1.charAt(i)-'0')+(num2.charAt(j)-'0')+jin;
            jin=sum/10;
            sum=sum%10;
            stringBuilder.append(sum);
            i--;
            j--;
        }
        while(i>=0){
            sum=(num1.charAt(i)-'0')+jin;
            jin=sum/10;
            sum=sum%10;
            stringBuilder.append(sum);
            i--;
        }
        while(j>=0){
            sum=(num2.charAt(j)-'0')+jin;
            jin=sum/10;
            sum=sum%10;
            stringBuilder.append(sum);
            j--;
        }
        if(jin>0) stringBuilder.append(jin);
        return stringBuilder.reverse().toString();
    }
    public String calProduct(String num,char c,int k){
        if(c=='0') return "0";

        StringBuilder stringBuilder=new StringBuilder("");
        for (int i = 0; i < k; i++) {
            stringBuilder.append("0");
        }

        int pro=0,jin=0;
        int num2=c-'0';
        for (int i = num.length()-1; i >=0; i--) {
            int num1=num.charAt(i)-'0';
            pro=num1*num2+jin;
            jin=pro/10;
            pro=pro%10;
            stringBuilder.append(pro);
        }
        if(jin>0) stringBuilder.append(jin);
        return stringBuilder.reverse().toString();
    }
}
