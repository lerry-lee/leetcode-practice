package _其他._笔试题._京东;


/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/21
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //哈希表存直线的偏移量b（直线斜率可能为1或-1，所以y=x+b或y=-x+b）所表示的直线上的点的个数
        //所以b=y-x或b=y+x
        Map<Integer, Integer> hashMap_b = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int b1 = y - x;//过该点的斜率为1的直线的偏移量b
            int b2 = y + x;//过该点的斜率为-1的直线的偏移量b
            //往直线上放点
            hashMap_b.put(b1, hashMap_b.getOrDefault(b1, 0) + 1);
            hashMap_b.put(b2, hashMap_b.getOrDefault(b2, 0) + 1);
        }
        int res = 0;//互为邻居的个数
        //遍历所有的直线
        for (int b : hashMap_b.keySet()) {
            int nums = hashMap_b.get(b);//直线上的所有点，两两之间都互为邻居
            if (nums == 1) continue;//直线上只有1个点，跳过
            res += (nums * (nums - 1)) / 2;//直线上有超过2个点，计算互为邻居的个数
        }
        System.out.println(res);
    }
}

/**
 * 5
 * 3 4
 * 4 5
 * 5 6
 * 4 7
 * 3 8
 */
