package _每日一题._2021年._21年1月;

/**
 * @ClassName: _509斐波那契数
 * @Author: lerry_li
 * @CreateDate: 2021/01/04
 * @Description
 */
public class _509斐波那契数 {
    /**
     * 解法1：递归
     * 解法2：迭代
     */
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    public int fib2(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int prev2=0,prev1=1;
        int res=0;
        for (int i = 2; i <= n; i++) {
            res=prev1+prev2;
            prev2=prev1;
            prev1=res;
        }
        return res;
    }

    public static void main(String[] args) {
        _509斐波那契数 instance =new _509斐波那契数();
        System.out.println(instance.fib2(4));
    }
}
