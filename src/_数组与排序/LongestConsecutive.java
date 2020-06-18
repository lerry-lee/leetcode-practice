package _数组与排序;

import java.util.*;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 思路：从时间复杂度O(n)来看，肯定要求只遍历一遍就出结果
 * 解法1：建立hashset，因为查询复杂度为O(1)，所以每次查完就删除该元素
 * 解法2：并查集
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet=new HashSet<>();
        for(int num:nums) hashSet.add(num);
        int max=0;

        for(Integer num:hashSet){
            if(hashSet.contains(num-1)) continue;
            int temp=1;
            while(hashSet.contains(num+1)) {
                num++;
                temp++;
            }
            max=Math.max(max,temp);
        }
        return max;

//        for(int num:nums){
//            int temp=1;
//            int num_up=num+1;
//            while(hashSet.contains(num_up)){
//                temp++;
//                hashSet.remove(num_up);
//                num_up++;
//            }
//            int num_down=num-1;
//            while(hashSet.contains(num_down)){
//                temp++;
//                hashSet.remove(num_down);
//                num_down--;
//            }
//            max=Math.max(max,temp);
//        }
//        return max;

    }

//    /**
//     * 并查集
//     * @param nums
//     * @return
//     */
//    class UF{
//        Map<Integer,Integer> category;
//        Map<Integer,Integer> size;
//        Set<Integer> set;
//        Map<Integer,List<Integer>> type;
//        int max;
//        int k;
//        public UF(int[] nums){
//            category=new HashMap<>();
//            size=new HashMap<>();
//            set=new HashSet<>();
//            type=new HashMap<>();
//            int i=1;
//            for(Integer num:nums) {
////                System.out.println(num);
//                category.put(num, i++);
//                size.put(num,1);
//                set.add(num);
//            }
//            max=0;
//            k=0;
//        }
//
//        public int run_uf(){
////            Set<Integer> keys=category.keySet();
////
////            for(Integer num:keys){
////                if(keys.contains(num+1)) union(num,num+1);
////                if(keys.contains(num-1)) union(num,num-1);
////            }
//            for(Integer n:set){
//                if(set.contains(n+1)) union(n,n+1);
//            }
//            display();
//            return getMax();
//        }
//
//        public void union(int n1,int n2){
//            if(category.get(n1)==category.get(n2)) return;
//            System.out.println("联通"+n1+"和"+n2);
//            category.replace(n2,category.get(n1));
//
//            List<Integer> l=type.get(k);
////            size.replace(n1,size.get(n1)+1);
////            size.replace(n2,size.get(n2)+1);
//            max=Math.max(max,size.get(n1));
//        }
//        public int getMax(){
//            return max;
//        }
//        public void display(){
//            System.out.println(category);
//            System.out.println(size);
//        }
//
//    }
//    public int longestConsecutive_uf(int[] nums) {
//        UF df=new UF(nums);
//        return df.run_uf();
//    }
}
