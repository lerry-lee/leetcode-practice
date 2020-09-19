package _腾讯推荐._数组与字符串;

/**
 * @ClassName : _删除排序数组中的重复项
 * @CreateTime : 2020/09/19 10
 * @Author : lerry_li
 * @Descrpition : 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 
 *
 * 示例1:
 *
 * 给定数组 nums = [1,1,2], 
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class _删除排序数组中的重复项 {
    /**
     * 解法1：双指针法 时间O(N) 空间O(1)
     * 定义：left指针指向不重复的第一个元素，right指针右移，找到第一个比left指针指向的元素大的
     *      1）交换[left+1]和[right]
     *      2）left=left+1
     */
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int l=0,r=1;
        while(r<nums.length){
            if(nums[l]>=nums[r]) r++;
            else{
                swap(nums,l+1,r);
                l+=1;
            }
        }
        return l+1;
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
