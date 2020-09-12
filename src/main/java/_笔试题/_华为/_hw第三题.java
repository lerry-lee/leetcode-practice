package _笔试题._华为;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/08/26 20:39
 * @description TODO
 */
public class _hw第三题 {
    public static void main(String[] args) {
        int n=5;
        String[] matches={"cloxy","cxmnu","kcotd","apqud","bldwz"};
        int[][] yn={{3,0},{1,1},{2,1},{2,0},{1,1}};
        for(int j=0;j<n;j++){
            for(int i=0;i<26;i++){

            }
        }

    }
    public static boolean check(String word,String match,int y,int n){
        int count=0,yes=0;
        HashSet<Character> map=new HashSet<>();
        for(int i=0;i<match.length();i++){
            map.add(word.charAt(i));
            if(word.charAt(i)==match.charAt(i)){
                yes++;
            }
            if(map.contains(match.charAt(i))) count++;
        }
        return count==(y+n)&&yes==y;
    }
}
