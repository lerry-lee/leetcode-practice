package _每日一题._2021年._21年6月;

/**
 * @ClassName: _374猜数字大小
 * @Author: lerry_li
 * @CreateDate: 2021/06/14
 * @Description
 * 解法1：二分
 */
public class _374猜数字大小 {
    /**
     * 解法1：二分 时间O(logN) 空间O(1)
     */
    public int guessNumber(int n) {
        int left=1,right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            if(guess(mid)==0) return mid;
            if(guess(mid)==-1) right=mid-1;
            else left=mid+1;
        }
        return left;
    }

    private int guess(int n) {
        return 0;
    }
}
