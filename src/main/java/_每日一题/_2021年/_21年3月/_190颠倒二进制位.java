package _每日一题._2021年._21年3月;

/**
 * @ClassName: _190颠倒二进制位
 * @Author: lerry_li
 * @CreateTime: 2021/03/29
 * @Description
 */
public class _190颠倒二进制位 {
    public int reverseBits(int n) {
        int sign=1;
        if(n<0){
            sign=-1;
        }
        int res=0;
        for (int i = 0; i < 32; i++) {
            res<<=1;
            res+=n&1;
            n>>>=1;
        }
        return sign*res;
    }

    public static void main(String[] args) {
        _190颠倒二进制位 instance=new _190颠倒二进制位();
        System.out.println(instance.reverseBits(43261596));
    }
}
