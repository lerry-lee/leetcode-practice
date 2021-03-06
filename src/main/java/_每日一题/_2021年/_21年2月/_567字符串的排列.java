package _每日一题._2021年._21年2月;

/**
 * @ClassName: _567字符串的排列
 * @Author: lerry_li
 * @CreateDate: 2021/02/10
 * @Description
 */
public class _567字符串的排列 {
    /**
     * 解法1：计数数组+滑动窗口 时间O(M+N*S) 空间O(S) S为字符集的大小
     * 思路：
     * 1.用一个计数数组维护窗口的元素及个数，初始化为s1
     * 2.在遍历s2的过程中，每次判断窗口是否满足要求
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0||s1.length()>s2.length()) {
            return false;
        }
        int[] freq = new int[26];
        int left = 0, right = s1.length() - 1;
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        while (right < s2.length()) {
            boolean flag = true;
            //判断窗口是否满足要求
            //每次遍历计数数组
            for (int i = 0; i < 26; i++) {
                if (freq[i] != 0) {
                    flag = false;
                    break;
                }
            }
            //满足则返回true
            if (flag) {
                return true;
            }
            //不满足则右移一位
            freq[s2.charAt(left)-'a']++;
            left++;
            right++;
            if (right < s2.length()) {
                freq[s2.charAt(right)-'a']--;
            }
        }
        return false;
    }

    /**
     * 解法2：解法1时间优化 时间O(N+M+S) 空间O(S)
     */
    public boolean checkInclusion2(String s1, String s2) {
        int n1=s1.length(),n2=s2.length();
        if(n1>n2){
            return false;
        }
        int[] freq=new int[26];
        for (int i = 0; i < n1; i++) {
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }
        int dif=0;
        for (int i = 0; i < 26; i++) {
            if(freq[i]!=0){
                dif++;
            }
        }
        if(dif==0){
            return true;
        }
        //滑动窗口移动中左边移出一个字符，右边移入一个字符
        int left=0,right=n1;
        while(right<n2){

            int c1=s2.charAt(left),c2=s2.charAt(right);

            left++;
            right++;

            //如果left出去的字符和right要进入的字符相同，那么跳过
            if(c1==c2){
                continue;
            }
            //否则
            //如果left出去的字符已经平衡了，即窗口和s1中该字符个数相等，
            //那么该字符出去后，不相同的字符个数必定+1
            if(freq[c1-'a']==0){
                dif++;
            }
            freq[c1-'a']++;
            //如果left字符出去后，达到平衡，则不相同的字符个数-1
            if(freq[c1-'a']==0){
                dif--;
            }

            //right进入字符同理
            if(freq[c2-'a']==0){
                dif++;
            }
            freq[c2-'a']--;
            if(freq[c2-'a']==0){
                dif--;
            }

            //如果dif=0，则退出
            if(dif==0){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        _567字符串的排列 instance=new _567字符串的排列();
        System.out.println(instance.checkInclusion2("ab","eidbaooo"));
        System.out.println(instance.checkInclusion2("ab","eidboaoo"));
    }
}
