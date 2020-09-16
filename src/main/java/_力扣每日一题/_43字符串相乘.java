package _力扣每日一题;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/08/13 09:58
 * @description
 */
public class _43字符串相乘 {
    public String multiply(String num1, String num2) {
        if(num1.length()>num2.length()) return mul(num1,num2);
        return mul(num2,num1);
    }
    public String mul(String num1,String num2){
        StringBuilder res=new StringBuilder("0");
        for(int i=num2.length()-1;i>=0;i--){
            StringBuilder product= mul_help(num1, num2.charAt(i));
            for(int j=i;j<num2.length()-1;j++) product.append("0");
            res=sum(res.toString(), product.toString());
        }

        while(res.length()>1){
            if(res.charAt(0)!='0') break;
            res.deleteCharAt(0);
        }
        return res.toString();
    }
    public StringBuilder mul_help(String num1,char c){
        int product=0,jin=0;
        StringBuilder res=new StringBuilder();
        for(int i=num1.length()-1;i>=0;i--){
            product=Character.getNumericValue(c)*Character.getNumericValue(num1.charAt(i))+jin;
            jin=product/10;
            product=product%10;
            res.insert(0,String.valueOf(product));
        }
        if(jin>0) res.insert(0,String.valueOf(jin));
//        for(int k=0;k<res.length();k++){
//            if(res.charAt(k)!='0'||k==res.length()-1) break;
//            res.deleteCharAt(k);
//        }
        return res;
    }
    public StringBuilder sum(String res,String product){
        int i=res.length()-1,j=product.length()-1;
        StringBuilder sum_res=new StringBuilder();
        int sum_add=0,sum_jin=0;
        while(i>=0&&j>=0){
            sum_add=Character.getNumericValue(res.charAt(i))+Character.getNumericValue(product.charAt(j))+sum_jin;
            sum_jin=sum_add/10;
            sum_add=sum_add%10;
            sum_res.insert(0,String.valueOf(sum_add));
            i--;j--;
        }
        while(i>=0){
            sum_add=Character.getNumericValue(res.charAt(i))+sum_jin;
            sum_jin=sum_add/10;
            sum_add=sum_add%10;
            sum_res.insert(0,String.valueOf(sum_add));
            i--;
        }
        while(j>=0){
            sum_add=Character.getNumericValue(product.charAt(j))+sum_jin;
            sum_jin=sum_add/10;
            sum_add=sum_add%10;
            sum_res.insert(0,String.valueOf(sum_add));
            j--;
        }
        if(sum_jin>0) sum_res.insert(0,String.valueOf(sum_jin));
//        for(int k=0;k<sum_res.length();k++){
//            if(sum_res.charAt(k)!='0'||k==sum_res.length()-1) break;
//            sum_res.deleteCharAt(k);
//        }
        return sum_res;
    }
}
