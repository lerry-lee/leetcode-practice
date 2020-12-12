package _每日一题._20年11月;



/**
 * @ClassName: _493翻转对
 * @Author: lerry_li
 * @CreateTime: 2020/11/28
 */
public class _493翻转对 {
    /**
     * 解法1：归并排序
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        res = 0;
        mergeSort(nums, 0, nums.length - 1);

        return res;
    }

    int res;

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int J = r;
        for (int i = mid; i >= l; i--) {
            int j = J;
            for (; j > mid; j--) {
                if ((long) nums[i] > 2 * (long) nums[j]) {
                    res += j - mid;
                    J = j;
                    break;
                }
            }
            if (J != j) {
                break;
            }
        }

        //合并两个有序数组
        int[] helper=new int[r-l+1];
        int hi=0;
        int i=l,j=mid+1;
        while(i<=mid&&j<=r){
            if(nums[i]<=nums[j]){
                helper[hi]=nums[i++];
            }else{
                helper[hi]=nums[j++];
            }
            hi++;
        }
        while(i<=mid){
            helper[hi++]=nums[i++];
        }
        while(j<=r){
            helper[hi++]=nums[j++];
        }
        if (helper.length >= 0) System.arraycopy(helper, 0, nums, l, helper.length);
    }

    public static void main(String[] args) {
        _493翻转对 instance = new _493翻转对();
        int[] nums = {233, 2000000001, 234, 2000000006, 235, 2000000003, 236, 2000000007, 237, 2000000002, 2000000005, 233, 233, 233, 233, 233, 2000000004};
        int[] nums1={5,4,3,2,1};
        System.out.println(instance.reversePairs(nums1));
    }
}
