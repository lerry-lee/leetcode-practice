package _每日一题._2020年._20年12月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: _49字母异位词分组
 * @Author: lerry_li
 * @CreateDate: 2020/12/14
 * @Description
 */
public class _49字母异位词分组 {
    /**
     * 解法1：排序+哈希
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        if(strs==null||strs.length==0){
            return res;
        }
        HashMap<String,Integer> hashMap=new HashMap<>();
        for(String str:strs){
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String sortStr=String.valueOf(arr);
            if(!hashMap.containsKey(sortStr)){
                res.add(new ArrayList<>());
                res.get(res.size()-1).add(str);
                hashMap.put(sortStr,res.size()-1);
            }else{
                res.get(hashMap.get(sortStr)).add(str);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _49字母异位词分组 instance=new _49字母异位词分组();
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(instance.groupAnagrams(strs));
    }
}
