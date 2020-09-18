package _笔试题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lerrylee
 * @version 1.0.0
 * @className _23
 * @date 下午6:12 20-9-11
 * @description 给定一个字符串，输出该串第一个出现3次的字符
 **/
public class _第一个出现3次的字符 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        Map<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
            if(hashMap.get(c)==3) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("没有出现三次的字符");
    }
}
