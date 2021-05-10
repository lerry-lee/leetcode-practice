package _每日一题._2021年._21年5月;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: _554砖墙
 * @Author: lerry_li
 * @CreateDate: 2021/05/10
 * @Description 解法1：暴力
 */
public class _554砖墙 {

    /**
     * 解法1：暴力 时间O(N^2*M^2) 空间O(1)
     */
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) return 0;
        int minRes = wall.size();
        int tempRes = 0;
        for (int i = 0; i < wall.size(); i++) {
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                tempRes = check(wall, i, j, minRes);
                minRes = tempRes;
            }
        }
        return minRes;
    }

    private int check(List<List<Integer>> wall, int i, int j, int minRes) {
        int width = 0;
        List<Integer> temp = wall.get(i);
        for (int k = 0; k <= j; k++) {
            width += temp.get(k);
        }
        int tempRes = 0;
        for (int k = 0; k < wall.size(); k++) {
            if (k == i) continue;
            int tempWidth = 0;
            for (int l = 0; l < wall.get(k).size(); l++) {
                tempWidth += wall.get(k).get(l);
                if (tempWidth == width) {
                    break;
                } else if (tempWidth > width) {
                    tempRes += 1;
                    break;
                }
            }
            if (tempRes > minRes) {
                return minRes;
            }
        }
        return tempRes;
    }

    /**
     * 解法2：哈希表 时间O(NM) 空间O(NM)
     */
    public int leastBricks2(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) return 0;
        int size = wall.size();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (List<Integer> cur : wall) {
            int temp = 0;
            for (int i = 0; i < cur.size() - 1; i++) {
                temp += cur.get(i);
                hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
            }
        }
        int counts = 0;
        for (int key : hashMap.keySet()) {
            counts = Math.max(counts, hashMap.get(key));
        }
        return size - counts;
    }
}
