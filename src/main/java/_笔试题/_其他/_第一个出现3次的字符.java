package _笔试题._其他;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Signature: Created by lerry_li on 2020/10/28
 * @Description: 给定一个数组，找到第一个出现3次的字符
 */
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
