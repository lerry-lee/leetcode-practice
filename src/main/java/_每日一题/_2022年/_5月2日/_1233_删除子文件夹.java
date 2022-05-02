package _每日一题._2022年._5月2日;

import java.util.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _1233_删除子文件夹 {
    /**
     * 解法1：排序+哈希 时间O(NlogNS) 空间O(N)
     */
    class Solution {
        public List<String> removeSubfolders(String[] folder) {
            List<String> res = new ArrayList<>();
            //特判
            if (folder == null || folder.length == 0) return res;
            //sort
            Arrays.sort(folder);
            Set<String> visited = new HashSet<>();
            //遍历
            for (String file : folder) {
                //如果当前file的前缀已经有了，那么当前file是子文件夹，需要删除（即不添加到res中）
                for (int i = 1; i < file.length(); i++) {
                    if (file.charAt(i) == '/') {
                        String prefix = file.substring(0, i);
                        if (visited.contains(prefix)) {
                            break;
                        }
                    }
                    if (i == file.length() - 1) {
                        res.add(file);
                        visited.add(file);
                    }
                }
            }
            return res;
        }
    }
}
