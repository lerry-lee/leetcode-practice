package _字节跳动推荐._数组与排序;

import java.util.ArrayList;
import java.util.List;

/**
 * 第K个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class _第K个排列 {
    int count;
    StringBuilder res;
    List<Integer> pai;
    int[] factorial;

    public String getPermutation(int n, int k) {
        count=0;
        pai=new ArrayList<>(n);
        int[] nums = new int[n];
        boolean[] bool=new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            bool[i] = false;
        }
        res = new StringBuilder();
//        backTrack(nums, 0, n-1, k);
        backTrack_bool(nums,0,n-1,k,bool);
        return res.toString();
    }


    public String getPermutation_(int n,int k){
        factorial=new int[n+1];
        factorial[0]=1;
        for(int i=1;i<=n;i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        res = new StringBuilder();
        int[] nums = new int[n];
        boolean[] bool=new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            bool[i] = false;
        }
        for(int f:factorial) System.out.print(f+" ");
        System.out.println();
        pai=new ArrayList<>(n);
        search_pruning(nums,bool,0,n,k);
        return res.toString();
    }

    //剪枝：时间复杂度在O(n^2)
    public void search_pruning(int[] nums,boolean[] bool,int t,int n,int k){
        if(t>=n) {
            for (int num:pai) {
                res.append(num);
            }
            return;
        }
        int x=factorial[n-1-t];
//        System.out.println(x);
        for(int i=0;i<n;i++){
//            System.out.println("t:"+t+" x:"+x+" k:"+k);
            if(bool[i]) continue;
            if(x<k) {
                k-=x;
//                System.out.println("k:"+k);
                continue;
            }
            if(!bool[i]){
                System.out.println("x:"+x+" k:"+k+" 数字："+nums[i]);
                bool[i]=true;
                pai.add(nums[i]);
                search_pruning(nums,bool,t+1,n,k);
//                pai.remove(pai.size()-1);
//                bool[i]=false;
            }
        }
    }

    //交换法：得到的顺序不是严格递增的
    public void backTrack(int[] nums, int t, int n, int k) {
        if (t > n) {
            count++;
            System.out.print("第"+count+"次排列：");
            for (int num : nums) {
                System.out.print(num+" ");
            }
            System.out.println();

            if(count==k){
                for (int num : nums) {
                    res.append(num + "");
                }
            }
            return;
        }
        for (int i = t; i <= n /*&& count < k*/; i++) {
            swap(nums, i, t);
            backTrack(nums, t+1, n, k);
            swap(nums, i, t);
        }
    }
    //bool判断法，时间复杂度比交换法高一些，但得到的序列是严格递增的
    public void backTrack_bool(int[] nums,int t,int n,int k,boolean[] bool){
        if (t > n) {
            count++;
//            System.out.println(pai);
            if(count==k){
                for (int num : pai) {
                    res.append(num + "");
                }
            }
            return;
        }
        for (int i = 0; i <= n && count < k; i++) {
            if(!bool[i]) {
                bool[i]=true;
                pai.add(nums[i]);
                backTrack_bool(nums, t + 1, n, k,bool);
                bool[i]=false;
                pai.remove(pai.size()-1);
            }
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
