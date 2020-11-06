package Tecent._数组与字符串;

/**
 * @ClassName : _反转字符串
 * @CreateTime : 2020/09/22 10
 * @Author : lerry_li
 * @Descrpition : 空间复杂度要求O(1)
 */
public class _反转字符串 {
    public void reverseString(char[] s) {
        if(s==null||s.length==0) return;
        int l=0,r=s.length-1;
        while(l<r){
            swap(s,l,r);
            l++;
            r--;
        }
    }
    public void swap(char[] s,int l,int r){
        char temp=s[l];
        s[l]=s[r];
        s[r]=temp;
    }
}
