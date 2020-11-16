package DailyExercises._20年11月;

import DataStructure.CommonMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: _406根据身高重建队列
 * @Signature: Created by lerry_li on 2020/11/16
 * @Description:
 */
public class _406根据身高重建队列 {
    /**
     * 解法1：排序
     * 1.先按身高h从高到低排序，若身高相同则按k从小到大排序
     * 2.遍历排序后的数组：
     *      1）前面的高个子已经站好位了，当前h肯定比已经站好位的h要低；
     *      2）根据k插入对应的位置即可
     *      例如：
     *      排序后：[7,0] [7,1] [6,1] [5,1] [5,2] [4,4]
     *      遍历：
     *          ①[7,0]；h=7的第一个人直接站第0个位置
     *          ②[7,0] [7,1]；h=7的第二个人站第1个位置
     *          ③[7,0] [6,1] [7,1]；h=76第三个人站第1个位置
     *          ④[7,0] [5,1] [6,1] [7,1]；h=5的第四个人站第1个位置
     *          ⑤[7,0] [5,1] [5,2] [6,1] [7,1]；h=5的第五个人站第2个位置
     *          ⑥[7,0] [5,1] [5,2] [6,1] [4,4] [7,1]；h=4的第六个人站第4个位置
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
//        System.out.println("sort:");
//        CommonMethod.display(people);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            if (i == 0) {
                list.add(people[i]);
            } else {
                list.add(people[i][1], people[i]);
            }
        }
        return list.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        _406根据身高重建队列 instance = new _406根据身高重建队列();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {6, 2}};
        CommonMethod.display(instance.reconstructQueue(people));
    }
}
