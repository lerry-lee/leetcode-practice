package _每日一题._2022年._befor5月;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/25
 * @Description
 */
public class _398_随机数索引 {
    /**
     * 解法1：哈希表+随机数
     */
    class Solution {
        Map<Integer, HashSet<Integer>> hashMap;
        public Solution(int[] nums) {
            hashMap=new HashMap();
            for(int i=0;i<nums.length;i++){
                HashSet<Integer> hashSet=hashMap.getOrDefault(nums[i],new HashSet());
                hashSet.add(i);
                hashMap.put(nums[i],hashSet);
            }
        }

        public int pick(int target) {
            HashSet<Integer> hashSet=hashMap.get(target);
            int size=hashSet.size();
            int[] numsI=new int[size];
            int i=0;
            for(int key:hashSet){
                numsI[i++]=key;
            }
            if(size==0) return numsI[0];
            int idx=new Random().nextInt(size);
            return numsI[idx];
        }
    }
    /**
     * 解法2：蓄水池抽样
     * 该方法可保证抽到每个数的概率都是相等的，可参考题解https://leetcode-cn.com/problems/random-pick-index/solution/sui-ji-shu-suo-yin-by-leetcode-solution-ofsq/
     */
    class Solution2 {
        int[] nums;
        Random random;

        public Solution2(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int pick(int target) {
            int ans = 0;
            for (int i = 0, cnt = 0; i < nums.length; ++i) {
                if (nums[i] == target) {
                    ++cnt; // 第 cnt 次遇到 target
                    if (random.nextInt(cnt) == 0) {
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }
}
