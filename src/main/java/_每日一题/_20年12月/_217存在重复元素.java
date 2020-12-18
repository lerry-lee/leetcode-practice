package _每日一题._20年12月;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _217存在重复元素
 * @Author: lerry_li
 * @CreateDate: 2020/12/18
 * @Description
 */
public class _217存在重复元素 {
    /**
     * 解法1：排序 时间O(NlogN) 空间O(1)
     * 解法2：哈希表 时间O(N) 空间O(N)
     */
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length<2){
            return false;
        }
        Set<Integer> hashSet=new HashSet<>();
        for(int num:nums){
            if(hashSet.contains(num)){
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }
}
