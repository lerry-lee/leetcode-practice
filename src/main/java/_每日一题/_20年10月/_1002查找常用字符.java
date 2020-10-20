package _每日一题._20年10月;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lerry_li on 2020/10/14
 */

/**
 * 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 */
public class _1002查找常用字符 {
    /**
     * 解法1：暴力+visited数组 时间O(mn) 空间O(mn)
     */
    public List<String> commonChars(String[] A) {
        List<String> res=new ArrayList<>();
        if(A==null||A.length==0) return res;
        int minStrLen=Integer.MAX_VALUE,minStr_idx=0;
        String minStr="";
        boolean[][] visited=new boolean[A.length][];
        for(int i=0;i<A.length;i++){
            String str=A[i];
            visited[i]=new boolean[str.length()];
            if(str.length()<minStrLen){
                minStrLen=str.length();
                minStr=str;
                minStr_idx=i;
            }
        }

        for (int minStr_i = 0; minStr_i < minStr.length(); minStr_i++) {
            char c=minStr.charAt(minStr_i);

            for(int i=0;i<A.length;i++){
                if(i==minStr_idx) continue;
                String str=A[i];
                if(!charIsInStr(str,c,visited,i)) break;
                if(i==A.length-1){
                    res.add(c+"");
                }
            }
        }
        return res;
    }
    public boolean charIsInStr(String str,char c,boolean[][] visited,int i){
        for (int j = 0; j < str.length(); j++) {
            if(visited[i][j]) continue;
            if(c==str.charAt(j)) {
                visited[i][j]=true;
                return true;
            }
        }
        return false;
    }
}
