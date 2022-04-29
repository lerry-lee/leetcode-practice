package _每日一题._2022年;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/29
 * @Description
 */
public class _93_复原IP地址 {

    public static void main(String[] args) {
        _93_复原IP地址 instance=new _93_复原IP地址();
        instance.new Solution().restoreIpAddresses("25525511135");
    }

    /**
     * 解法1：回溯+剪枝
     */
    class Solution {
        List<String> res;
        public List<String> restoreIpAddresses(String s) {
            res=new ArrayList();
            if(s==null||s.length()==0) return res;
            dfs(s,0,new ArrayList());
            return res;
        }
        public void dfs(String s,int t,List<String> addr){
            if(addr.size()==4){
                if(t==s.length()){
                    res.add(String.join(".",addr));
                    // System.out.println(res);
                }
                return;
            }
            if(t==s.length()){
                return;
            }
            int remain=s.length()-t;
            int parts=4-addr.size();
            if(remain<parts||remain>parts*3) return;

            for(int i=t;i<t+3&&i<s.length();i++){
                int num=Integer.parseInt(s.substring(t,i+1));
                if(num>255) break;
                if(String.valueOf(num).length()!=i-t+1) break;
                addr.add(num+"");
                dfs(s,i+1,addr);
                addr.remove(addr.size()-1);
            }

        }
    }
}
