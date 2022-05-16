package _每日一题._2022年._5月;

import java.util.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/16
 * @Description
 */
public class _1233_删除子文件夹 {
    /**
     * 解法1：排序+哈希表 时间O(OlogNk) 空间O(NK)
     */
    class Solution {
        public List<String> removeSubfolders(String[] folder) {
            List<String> res = new ArrayList<>();
            if (folder == null || folder.length == 0) return res;
            Set<String> hashSet = new HashSet<>();
            Arrays.sort(folder);
            for (String file : folder) {
                boolean flag = false;
                for (int i = 0; i < file.length(); i++) {
                    if (file.charAt(i) == '/' && hashSet.contains(file.substring(0, i))) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    hashSet.add(file);
                    res.add(file);
                }
            }
            return res;
        }
    }
}
