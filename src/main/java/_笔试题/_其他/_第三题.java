package _笔试题._其他;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/08/23 20:45
 * @description 一个整数拆分为2个非负整数，求两个整数的数位和最大值
 * 35=9+26
 * 9的数位和：9
 * 26的数位和：2+6=8
 * 最大值：9+8=17
 * 输入：35 输出：17
 */
public class _第三题 {
    /**
     * 暴力法
     */
    public static void main(String[] args) {
        int maxVal=t3(35);
        System.out.println(maxVal);
    }
    public static int t3(int a){
        int maxVal=0;
        for(int m=1;m<=a/2;m++){
            int n=a-m;
            maxVal=Math.max(maxVal,calVal(m)+calVal(n));
        }
        return maxVal;
    }
    public static int calVal(int num){
        int res=0,wei;
        while(num>0){
            wei=num%10;
            res+=wei;
            num/=10;
        }
        return res;
    }
}
