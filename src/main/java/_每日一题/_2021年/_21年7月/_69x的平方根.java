package _每日一题._2021年._21年7月;

/**
 * @ClassName: _69x的平方根
 * @Author: lerry_li
 * @CreateDate: 2021/07/21
 * @Description
 * 二分
 */
public class _69x的平方根 {

    public static void main(String[] args) {
        _69x的平方根 instance=new _69x的平方根();
        System.out.println(instance.mySqrt(0));
        System.out.println(instance.mySqrt(1));
        System.out.println(instance.mySqrt(4));
        System.out.println(instance.mySqrt(8));
    }

    /**
     * 二分 时间O(logx) 空间O(1)
     */
    public int mySqrt(int x) {
        int l=0,r=x;
        while(l<=r){
            int mid=l+(r-l)/2;
            long temp= (long) mid *mid;
            if(temp==x) return mid;
            else if(temp<x) l=mid+1;
            else r=mid-1;
        }
        return l-1;
    }
}
