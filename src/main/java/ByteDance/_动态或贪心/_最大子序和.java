package ByteDance._动态或贪心;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/20 09:27
 * @description 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class _最大子序和 {
    //O(n)解法
    public int maxSubArray(int[] nums) {
        int max_sum=Integer.MIN_VALUE,temp=0;
        for (int num : nums) {
            temp += num;
            max_sum = Math.max(max_sum, temp);
            if (temp < 0) temp = 0;
        }
        return max_sum;
    }
//    分治法
    public int maxSubArray_divide(int[] nums){
        return divide(nums,0,nums.length-1);
    }
    public int divide(int[] nums,int l,int r){
        if(l==r) return nums[l];
        int mid=(l+r)/2;
        int sum_l=divide(nums,l,mid);
        int sum_r=divide(nums,mid+1,r);
        int max_l=getMaxL(nums,l,mid);
        int max_r=getMaxR(nums,mid+1,r);
        return getMaxSum(sum_l,sum_r,max_l+max_r);
    }

    public int getMaxSum(int a,int b,int c){
        if(a>b) return Math.max(a,c);
        return Math.max(b,c);
    }

    public int getMaxL(int[] nums,int l,int mid){
        int sum=nums[mid],temp=0;
        for (int i = mid; i >=l ; i--) {
            temp+=nums[i];
            sum=Math.max(sum,temp);
        }
        return sum;
    }
    public int getMaxR(int[] nums,int mid,int r){
        int sum=nums[mid],temp=0;
        for (int i = mid; i <=r ; i++) {
            temp+=nums[i];
            sum=Math.max(sum,temp);
        }
        return sum;
    }

    static class Test{
        public int maxSubArray(int[] nums) {
            if(nums==null||nums.length==0) return 0;
            return divide(nums,0,nums.length-1);
        }
        public int divide(int[] nums,int l,int r){
            if(l==r) return nums[l];
            int mid=(l+r)/2;
            int max_l=divide(nums,l,mid);
            int max_r=divide(nums,mid+1,r);
            int max_sub_l=getMaxSubL(nums,l,mid);
            int max_sub_r=getMaxSubR(nums,mid+1,r);
            System.out.format("l:%d\tr:%d\tmax_l:%d\tmax_r:%d\tmax_sub_l:%d\tmax_sub_r:%d\n",l,r,max_l,max_r,max_sub_l,max_sub_r);
            return max(max_l,max_r,max_sub_l+max_sub_r);
        }
        public int getMaxSubL(int[] nums,int l,int mid){
            int sum=nums[mid],temp_sum=0;
            for(int i=mid;i>=l;i--){
                temp_sum+=nums[i];
                sum=Math.max(sum,temp_sum);
            }
            return sum;
        }
        public int getMaxSubR(int[] nums,int mid,int r){
            int sum=nums[mid],temp_sum=0;
            for(int i=mid;i<=r;i++){
                temp_sum+=nums[i];
                sum=Math.max(sum,temp_sum);
            }
            return sum;
        }
        public int max(int a,int b,int c){
            if(a>b) return Math.max(a,c);
            return Math.max(b,c);
        }
    }

}
