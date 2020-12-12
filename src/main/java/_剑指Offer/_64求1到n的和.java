package _剑指Offer;

/**
 * @ClassName: _64求1到n的和
 * @Author: lerry_li
 * @CreateDate: 2020/12/03
 * @Description
 */
public class _64求1到n的和 {
    /**
     * 解法1：递归+逻辑运算符
     * 循环用递归代替
     * if用逻辑运算符代替
     */
    public int sumNums(int n) {
        //and运算符，若n<=1后面不会执行，直接返回n
        //若n>1，则判断&&后面的是否成立，结果n=n+subNums(n-1)，n递归更新了
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        _64求1到n的和 instance = new _64求1到n的和();
        System.out.println(instance.sumNums(9));
    }
}
