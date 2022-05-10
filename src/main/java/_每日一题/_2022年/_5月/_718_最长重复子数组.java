package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/10
 */
public class _718_最长重复子数组 {
    /**
     * 解法1：滑动窗口 时间O((N+M)×min(N,M)) 空间O(1)
     */
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int len1 = nums1.length, len2 = nums2.length;
            int i = len2 - 1;
            int res = 0;
            while (i >= 0) {
                int p1=i,p2=0;
                int temp=0;
                for(;p1<len2&&p2<len1;p1++,p2++){
                    if(nums2[p1]==nums1[p2]){
                        temp++;
                    }else{
                        temp=0;
                    }
                    res=Math.max(res,temp);
                }
                i--;
            }
            int j=0;
            while(j<len1){
                int p1=j,p2=0;
                int temp=0;
                for(;p1<len1&&p2<len2;p1++,p2++){
                    if(nums2[p2]==nums1[p1]){
                        temp++;
                    }else{
                        temp=0;
                    }
                    res=Math.max(res,temp);
                }
                j++;
            }
            return res;
        }
    }
}
