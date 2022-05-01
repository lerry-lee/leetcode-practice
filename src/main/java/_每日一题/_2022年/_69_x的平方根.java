package _每日一题._2022年;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _69_x的平方根 {
    /**
     * 解法1：逐个尝试，时间O(N) 空间O(1)
     * 解法2：二分，时间O(logN) 空间O(1)
     */
    class Solution {
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
}
