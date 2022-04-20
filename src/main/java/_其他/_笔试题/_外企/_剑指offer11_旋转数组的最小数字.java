package _其他._笔试题._外企;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/20
 */
public class _剑指offer11_旋转数组的最小数字 {
    /**
     * 解法1：二分
     */
    public int minArray(int[] numbers) {
        int l=0,r=numbers.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            //当右半数组无序时，最小值一定出现在右半数组里
            if(numbers[mid]>numbers[r]) l=mid+1;
            //否则，右半数组有序时，最小值在左半数组里，包括mid值
            else if(numbers[mid]<numbers[r]) r=mid;
            //否则，mid值和r值相等，减少r的范围继续判断
            else r--;
        }
        return numbers[l];
    }
}
