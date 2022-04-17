package _字节推荐._字符串;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例：
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 */
public class _字符串相乘 {

    static class Test{

        public static void main(String[] args) {
            Test instance=new Test();
            instance.multiply("3","2");
        }
        public String multiply(String num1, String num2) {
            if(num1.equals("0")||num2.equals("0")){
                return "0";
            }
            String res="0";
            for(int i=num2.length()-1;i>=0;i--){
                String prod=stringMulti(num1,num2.charAt(i),num2.length()-1-i);
                res=stringAdd(res,prod);
            }
            return res;
        }
        public String stringMulti(String num1,char n2,int k){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<k;i++){
                sb.append("0");
            }
            int prod=0,jin=0;
            for(int i=num1.length()-1;i>=0;i--){
                prod=(n2-'0')*(num1.charAt(i)-'0')+jin;
                jin=prod/10;
                sb.append(prod%10);
            }
            if(jin>0){
                sb.append(jin);
            }
            return sb.reverse().toString();
        }
        public String stringAdd(String num1,String num2){
            StringBuilder sb=new StringBuilder();
            int i=num1.length()-1,j=num2.length()-1;
            int sum=0,jin=0;
            while(i>=0&&j>=0){
                sum=(num1.charAt(i)-'0')+(num2.charAt(j)-'0')+jin;
                jin=sum/10;
                sb.append(sum%10);
                i--;
                j--;
            }
            while(i>=0){
                sum=(num1.charAt(i)-'0')+jin;
                jin=sum/10;
                sb.append(sum%10);
                i--;
            }
            while(j>=0){
                sum=(num2.charAt(j)-'0')+jin;
                jin=sum/10;
                sb.append(sum%10);
                j--;
            }
            if(jin>0){
                sb.append(jin);
            }
            return sb.reverse().toString();
        }
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String temp = stringMul(num1, num2.charAt(i), num2.length() - 1 - i);
            res = stringAdd(res, temp);
        }
        return res;
    }

    public String stringAdd(String n1, String n2) {
        StringBuilder res = new StringBuilder();
        int jin = 0, sum = 0;
        int i = n1.length() - 1, j = n2.length() - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            sum = Character.getNumericValue(n1.charAt(i)) + Character.getNumericValue(n2.charAt(j)) + jin;
            jin = sum >= 10 ? sum / 10 : 0;
            sum = sum % 10;
            res.append(sum);
        }
        while (i >= 0) {
            sum = Character.getNumericValue(n1.charAt(i)) + jin;
            jin = sum >= 10 ? sum / 10 : 0;
            sum = sum % 10;
            res.append(sum);
            i--;
        }
        while (j >= 0) {
            sum = Character.getNumericValue(n2.charAt(j)) + jin;
            jin = sum >= 10 ? sum / 10 : 0;
            sum = sum % 10;
            res.append(sum);
            j--;
        }
        if (jin > 0) res.append(jin);
        return res.reverse().toString();
    }

    public String stringMul(String s1, char c, int k) {
        StringBuilder res = new StringBuilder();
        while (k > 0) {
            res.append("0");
            k--;
        }
        int product = 0, jin = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            product = Character.getNumericValue(c) * Character.getNumericValue(s1.charAt(i)) + jin;
            jin = product / 10;
            product = product % 10;
            res.append(product);
        }
        if (jin > 0) res.append(jin);
        return res.reverse().toString();
    }
}
