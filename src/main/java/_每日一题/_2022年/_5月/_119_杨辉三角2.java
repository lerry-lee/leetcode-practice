package _每日一题._2022年._5月;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/10
 */
public class _119_杨辉三角2 {
    /**
     * 解法1：直接做
     */
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> res=new ArrayList<>();
            //特判
            if(rowIndex<0) return res;
            res.add(1);
            if(rowIndex==0){
                return res;
            }
            res.add(1);
            if(rowIndex==1){
                return res;
            }

            for (int i = 2; i <= rowIndex; i++) {
                int prev=res.get(0);
                for (int j = 1; j < i; j++) {
                    int temp=res.get(j);
                    res.set(j,res.get(j)+prev);
                    prev=temp;
                }
                res.add(1);
            }
            return res;
        }
    }
}
