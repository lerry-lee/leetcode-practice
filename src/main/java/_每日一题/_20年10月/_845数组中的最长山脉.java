package _每日一题._20年10月;

/**
 * Created by lerry_li on 2020/10/25
 */
public class _845数组中的最长山脉 {
    /**
     * 解法1：中心拓展
     */
    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) return 0;
        int res = 0;
        for (int i = 1; i < A.length - 1; i++) {
            int l = i - 1, r = i + 1;
            int temp=1;
            if (l >= 0 && r < A.length) {
                while(l >= 0&&A[l] < A[l + 1]) {
                    temp++;
                    l--;
                }
                while(r < A.length&&A[r] < A[r - 1]) {
                    temp++;
                    r++;
                }
                if(l!=i-1&&r!=i+1){
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }
    /**
     * 解法2：枚举山顶
     */
    public int longestMountain2(int[] A) {
        if (A == null || A.length < 3) return 0;
        int[] left=new int[A.length];
        int[] right=new int[A.length];
        left[0]=0;
        right[A.length-1]=0;
        for (int i = 1; i < A.length; i++) {
            if(A[i]>A[i-1]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=0;
            }
        }
        for (int i = A.length-2; i >=0 ; i--) {
            if(A[i]>A[i+1]){
                right[i]=right[i+1]+1;
            }else{
                right[i]=0;
            }
        }
        int res=0;
        for (int i = 1; i < A.length-1; i++) {
            if(A[i]>A[i-1]&&A[i]>A[i+1]){
                res=Math.max(res,left[i-1]+right[i+1]+1);
            }
        }
        return res;
    }
}
