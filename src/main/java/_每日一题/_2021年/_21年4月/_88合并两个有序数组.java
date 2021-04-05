package _每日一题._2021年._21年4月;

/**
 * @ClassName: _88合并两个有序数组
 * @Author: lerry_li
 * @CreateDate: 2021/04/05
 * @Description
 */
public class _88合并两个有序数组 {
    /**
     * 解法1：双指针+从后向前遍历 时间O(M+N) 空间O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int cnt = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[cnt] = nums1[i];
                i--;
            } else {
                nums1[cnt] = nums2[j];
                j--;
            }
            cnt--;
        }
        while(j>=0){
            nums1[cnt--]=nums2[j--];
        }
    }

    public static void main(String[] args) {
        _88合并两个有序数组 instance=new _88合并两个有序数组();
        instance.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
        instance.merge(new int[]{0},0,new int[]{1},1);
    }
}
