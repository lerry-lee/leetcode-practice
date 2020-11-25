package SwordFingerOffer;

/**
 * @ClassName: _14_1剪绳子
 * @Author: lerry_li
 * @CreateDate: 2020/11/25
 * @Description
 */
public class _14_1剪绳子 {
    /**
     * 解法1：数学推导
     * 思路：分成三种情况
     *      1.长度不够4：直接返回
     *      2.长度大于4，不停地剪长度为3的小段，剩下的：
     *          1）若为4，不剪了，4比3*1的剪法好；
     *          2）若为3，不剪了
     *          3）若为2，不剪了
     *          4）若为1，不可能为1
     *          因为每次剪去3,3+1=4，所以最后剩余的长度在[2,4]
     */
    public int cuttingRope(int n) {
        if(n<0){
            return 0;
        }
        if(n<4){
            return n;
        }
        int res=1;
        while(n>4){
            res*=3;
            n-=3;
        }
        return res*n;
    }

    public static void main(String[] args) {
        System.out.println(new _14_1剪绳子().cuttingRope(10));
    }
}
