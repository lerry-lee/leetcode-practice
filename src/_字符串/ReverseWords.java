package _字符串;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例1
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例2
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s="a good   example";
        String[] s_arr=s.split("\\s+");
        StringBuilder res=new StringBuilder();
        for(int i=s_arr.length-1;i>=0;i--){
            if(s_arr[i].equals("")) System.out.println("空格");
            res.append(s_arr[i]+"+");
        }
//        for(String word:s_arr){
//            res.append(new StringBuffer(word).reverse().toString()+" ");
//        }
//        System.out.println(count_space(s));
        System.out.println(res.toString().trim());
    }
    public static int count_space(String s){
        int k=0;
        int i=0;
        for(int c=s.charAt(i);i<s.length();i++){
            if(c==' ') k++;
        }
        return k;
    }
}
