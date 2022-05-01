package _每日一题._2022年._befor5月;

import _数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _1305_两棵二叉搜索树中的所有元素 {

    /**
     * 解法1：中序遍历+合并2个有序数组
     */
    class Solution {
        List<Integer> arr1,arr2;
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            arr1=new ArrayList();
            arr2=new ArrayList();
            dfs(root1,arr1);
            dfs(root2,arr2);
            return mergeSort(arr1,arr2);
        }
        public List<Integer> mergeSort(List<Integer> arr1, List<Integer> arr2){
            List<Integer> res=new ArrayList();
            int i=0,j=0;
            while(i<arr1.size()&&j<arr2.size()){
                if(arr1.get(i)<arr2.get(j)){
                    res.add(arr1.get(i));
                    i++;
                }else{
                    res.add(arr2.get(j));
                    j++;
                }
            }
            while(i<arr1.size()){
                res.add(arr1.get(i));
                i++;
            }
            while(j<arr2.size()){
                res.add(arr2.get(j));
                j++;
            }
            return res;
        }
        public void dfs(TreeNode root,List<Integer> arr){
            if(root==null) return;
            dfs(root.left,arr);
            arr.add(root.val);
            dfs(root.right,arr);
        }
    }
}
