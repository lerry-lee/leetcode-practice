package _每日一题._2021年._21年6月;

/**
 * @ClassName: _852山脉数组的峰顶索引
 * @Author: lerry_li
 * @CreateDate: 2021/06/15
 * @Description
 * 解法1：二分
 */
public class _852山脉数组的峰顶索引 {
    /**
     * 解法1：二分 时间O(logN) 空间O(1)
     */
    public int peakIndexInMountainArray(int[] arr) {
        int l=0,r= arr.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1]) return mid;
            if(arr[mid]<arr[mid-1]) r=mid;
            else l=mid;
        }
        return l;
    }
}
