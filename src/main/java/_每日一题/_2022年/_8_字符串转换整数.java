package _每日一题._2022年;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/27
 * @Description
 */
public class _8_字符串转换整数 {

    public static void main(String[] args) {
        _8_字符串转换整数 instance=new _8_字符串转换整数();
        instance.new Solution().myAtoi("2147483648");
    }

    /**
     * 解法1：直接模拟
     */
    class Solution {
        public int myAtoi(String s) {
            if(s==null||s.length()==0) return 0;
            int sign=1;
            char[] arr=s.toCharArray();
            boolean isNum=false;
            boolean hasSign=false;
            int res=0;
            for(char c:arr){
                if(Character.isDigit(c)){
                    if(sign==1){
                        if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&c>='7')){
                            res=Integer.MAX_VALUE;
                            break;
                        }
                    }else{
                        if(-res<Integer.MIN_VALUE/10||(-res==Integer.MIN_VALUE/10&&c>='8')){
                            res=Integer.MIN_VALUE;
                            break;
                        }
                    }
                    res=res*10+(c-'0');
                    isNum=true;
                }else{
                    if(isNum||hasSign){
                        break;
                    }
                    if(c=='+'&&!hasSign){
                        sign=1;
                        hasSign=true;
                    }
                    else if(c=='-'&&!hasSign){
                        sign=-1;
                        hasSign=true;
                    }
                    else if(c==' '){
                        continue;
                    }else{
                        break;
                    }
                }
            }
            return sign*res;
        }
    }
}
