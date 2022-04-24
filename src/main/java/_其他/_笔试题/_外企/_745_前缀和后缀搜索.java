package _其他._笔试题._外企;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/24
 */
public class _745_前缀和后缀搜索 {

    public static void main(String[] args) {
        _745_前缀和后缀搜索 instance=new _745_前缀和后缀搜索();
        WordFilter wordFilter=instance.new WordFilter(new String[]{"apple"});
        wordFilter.f("a","e");
    }

    /**
     * 解法1：双哈希表，索引所有前缀和后缀，超时
     */
    class WordFilter {
        Map<String,HashSet<Integer>> preMap,sufMap;

        public WordFilter(String[] words) {
            preMap=new HashMap();
            sufMap=new HashMap();
            for(int i=0;i<words.length;i++){
                for(int j=0;j<words[i].length();j++){
                    String prefix=words[i].substring(0,j+1);
                    HashSet<Integer> set=preMap.getOrDefault(prefix,new HashSet());
                    set.add(i);
                    preMap.put(prefix,set);
                }
                for(int j=words[i].length()-1;j>=0;j--){
                    String suffix=words[i].substring(j,words[i].length());
                    HashSet<Integer> set=sufMap.getOrDefault(suffix,new HashSet());
                    set.add(i);
                    sufMap.put(suffix,set);
                }
            }
        }

        public int f(String prefix, String suffix) {
            HashSet<Integer> preSet=preMap.getOrDefault(prefix,new HashSet());
            HashSet<Integer> sufSet=sufMap.getOrDefault(suffix,new HashSet());
            int res=-1;
            for(int i:preSet){
                if(sufSet.contains(i)){
                    res=Math.max(res,i);
                }
            }
            return res;
        }
    }
}
