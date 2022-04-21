package _其他._笔试题._外企;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/21
 */
public class _189_轮转数组 {
    /**
     * 解法1：借助额外数组 时间O(N) 空间O(N)
     * 解法2：数组翻转3次 时间O(N) 空间O(1)
     */
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length==0) return;
        int len=nums.length;
        k%=len;
        if(k==0) return;
        //翻转全部元素 (1,2,3,4,5,6,7) -> (7,6,5,4,3,2,1)
        reverse(nums,0,len-1);
        //翻转[0,k-1] ('7,6,5',4,3,2,1) -> ('5,6,7',4,3,2,1)
        reverse(nums,0,k-1);
        //翻转[k,len-1] (5,6,7,'4,3,2,1') -> (5,6,7,'1,2,3,4')
        reverse(nums,k,len-1);
    }
    public void reverse(int[] nums,int l,int r){
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}
