package _每日一题._2021年._21年8月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/19
 */
public class _345反转字符串中的元音字母 {

    public static void main(String[] args) {
        _345反转字符串中的元音字母 instance=new _345反转字符串中的元音字母();
        System.out.println(instance.reverseVowels("hello"));
        System.out.println(instance.reverseVowels("leetcode"));
    }

    /**
     * 解法1：双指针 时间O(N) 空间O(1)
     */
    public String reverseVowels(String s) {
        if(s==null||s.length()==0) return "";
        List<Character> vowels= Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        char[] arr=s.toCharArray();
        int left=0,right=arr.length-1;
        while(left<right){
            while(left<right&&!vowels.contains(arr[left])) left++;
            while(left<right&&!vowels.contains(arr[right])) right--;
            if(left<right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    private void swap(char[] arr, int left, int right) {
        char temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
}
