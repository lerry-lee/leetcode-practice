package _力扣每日一题;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/13 09:11
 * @description TODO
 */
public class _350两个数组的交集2 {
    /**
     * 思路1：排序+双指针遍历，时间复杂度O(mlogm+nlogn) 空间复杂度O(min(m,n))
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0) return new int[0];
        int len1=nums1.length,len2=nums2.length;
        int n = Math.min(len1, len2);
        int[] intersection=new int[n];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,end=0;
        while(i<len1&&j<len2){
            if(nums1[i]==nums2[j]) {
                intersection[end]=nums1[i];
                i++;
                j++;
                end++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else j++;
        }
        return Arrays.copyOfRange(intersection,0,end);
    }
    /**
     * 思路2：哈希表 时间复杂度O(m+n) 空间复杂度O(min(m,n))
     * （1）建立短数组的哈希表，key为元素，value为出现次数
     * （2）遍历长数组，如果元素在哈希表中value>0，则加入交集，否则不加入
     */
    public int[] intersect_hash(int[] nums1,int[] nums2){
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
