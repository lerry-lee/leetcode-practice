package _其他._TODO;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/02 16:59
 * @description 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2
 * .3"、"+-5"及"12e+5.4"都不是。
 */
public class _20表示数值的字符串 {
    /**
     * 解法1：逐个遍历
     * 1）‘.’出现正确情况：只出现一次，且在e的前面
     * 2）‘e’出现正确情况：只出现一次，且出现前有数字
     * 3）‘+’‘-’出现正确情况：只能在开头和e后一位
     */
    public boolean isNumber(String s) {
        if(s==null||s.length()==0) return false;
        //去掉首尾空格
        s=s.trim();
        boolean numFlag=false,dotFlag=false,eFlag=false;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            //遇到数字，标记numFlag
            if(c>='0'&&c<='9') numFlag=true;
                //遇到小数点，1）只能出现1次，前面不能有. 2）前面不能有e
            else if(c=='.'&&!dotFlag&&!eFlag) dotFlag=true;
                //遇到e，1）只能出现1次，前面不能有e 2）前面有数字
            else if((c=='e'||c=='E')&&!eFlag&&numFlag){
                eFlag=true;
                numFlag=false;//避免e之后没有数字的情况
            }
            //遇到+或-，只能出现在首位或者紧跟e后面
            else if((c=='+'||c=='-')&&(i==0||(s.charAt(i-1)=='e'||s.charAt(i-1)=='E'))){}
            //其他情况都是不合法的
            else return false;
        }
        return numFlag;
    }
    /**
     * 解法2：有限状态机
     * TODO
     */
}
