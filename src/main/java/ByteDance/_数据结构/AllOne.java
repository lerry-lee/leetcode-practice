package ByteDance._数据结构;

import java.util.*;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/06/25 15:59
 * @description 全 O(1) 的数据结构
 * 请你实现一个数据结构支持以下操作：
 *
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 *
 *
 * 挑战：
 *
 * 你能够以 O(1) 的时间复杂度实现所有操作吗？
 */
public class AllOne {
    /** Initialize your data structure here. */

    Map<String,Integer> hashMap;
    List<String> list;



    public AllOne() {
        hashMap=new HashMap<>();
        list=new ArrayList<>();

    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(hashMap.containsKey(key)){
            hashMap.replace(key,hashMap.get(key)+1);
        }
        else{
            hashMap.put(key,1);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(hashMap.containsKey(key)){
            int value=hashMap.get(key);
            if(value>1) hashMap.replace(key,value-1);
            else hashMap.remove(key);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(!list.isEmpty()) {
            return list.get(list.size()-1);
        }
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(!list.isEmpty()) {
            return list.get(0);
        }
        return "";
    }

}
