package ByteDance._字符串;

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
public class _翻转字符串里的单词 {
    //按空格分割字符串，循环时加条件判断
    public String reverseWords(String s) {
        String[] arr=s.split(" ");
        StringBuilder res=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].length()==0) continue;
            res.append(arr[i]+" ");
        }
        return res.toString().trim();
    }
    //正则表达式匹配多个空格
    public String reverseWords_regularExpression(String s) {
        String[] arr=s.split("\\s+");
        StringBuilder res=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            res.append(arr[i]+" ");
        }
        return res.toString().trim();
    }
}
