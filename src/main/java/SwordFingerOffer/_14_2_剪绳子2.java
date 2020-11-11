package SwordFingerOffer;

/**
 * @ClassName: _14_2_剪绳子2
 * @Signature: Created by lerry_li on 2020/11/11
 * @Description:
 */
public class _14_2_剪绳子2 {
    /**
     * 解法1：数学推导
     * 解题思路：
     *      设将长度为n的绳子切为a段:n=n1+n2+...+na
     *      本题等价于求解：max(n1*n2*...*na)
     * 数学推导：见题解
     *      推论1：将绳子以相等的长度等分为多段，得到的乘积最大
     *      推论2：尽可能将绳子以长度3等分为多段时，乘积最大
     * 切分规则：
     *      1.最优：3。把绳子尽可能切分为多个长度为3的片段，余下的最后一段的长度可能为0、1、2三种情况；
     *      2.次优：2。若最后一段绳子长度为2，则保留；
     *      3.最差：1。若最后一段绳子长度为1，则应该把一份3+1替换为2+2，因为2*2>3*1；
     * 算法流程：
     *      一、
     *      1.当n<=3时，返回n-1;
     *      2.当n>3时，求n=3a+b:
     *          ①当b=0时，直接返回3^a；
     *          ②当b=2时，直接返回3^a*2；
     *          ③当b=1时，直接返回3^(a-1)*4;
     *      二、
     *      1.当n>4时，n=n-3，res=res*3，重复步骤1
     *      2.循环结束时，n的值可能为2、3、4，返回res*n
     *          n不可能为1或0，因为n+3<=4，上一步就会在while条件判断时停止
     *
     *      注意：结果要对1000000007取模。
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int constant = 1000000007;
        long res = 1;
        while (n > 4) {
            //如果n大于4，我们不停的让他减去3
            n = n - 3;
            //计算每段的乘积
            res = res * 3 % constant;
        }
        return (int) ((res * n) % constant);

    }

    public static void main(String[] args) {
        _14_2_剪绳子2 instance = new _14_2_剪绳子2();
        System.out.println(instance.cuttingRope(120));
//        System.out.println(  (Math.pow(3, 40) )% 1000000007);
    }
}
