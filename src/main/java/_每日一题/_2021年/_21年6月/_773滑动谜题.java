package _每日一题._2021年._21年6月;

import java.util.*;

/**
 * @ClassName: _773滑动谜题
 * @Author: lerry_li
 * @CreateDate: 2021/06/26
 * @Description
 * 解法1：BFS
 */
public class _773滑动谜题 {


    /**
     * 解法1：BFS
     * 思路：
     *      用字符串表示2x3矩阵的状态，每次枚举可以交换的状态
     */

    //记录2x3矩阵中每个元素相邻元素在字符串中的下标，看作一个字符串先第一行再第二行
    //012345表示状态节点的字符串的下标，对应2x3矩阵中的(0,0),(0,1),(0,2),(1,0),(1,1),(1,2)
    //例如字符串下标为0的元素对应2x3矩阵中坐标为(0,0)的元素，因为(0,0)的邻居是(0,1)和(1,0)
    //对应字符串的下标是1和3，因此neighbors[0]=[1, 3]，用这总方式记录字符串每个下标的邻居的位置，这样可以枚举交换的状态
    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        //保存状态
        StringBuffer sb = new StringBuffer();
        //填充初始状态
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();
        if ("123450".equals(initial)) {
            return 0;
        }
        //统计步数
        int step = 0;
        //初始化队列
        Queue<String> queue = new LinkedList<String>();
        //将初始节点加入队列
        queue.offer(initial);
        //初始化集合，用来避免重复操作
        Set<String> seen = new HashSet<String>();
        //将初始节点加入集合
        seen.add(initial);
        //广度优先搜索
        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String status = queue.poll();
                //枚举可以到达的节点
                for (String nextStatus : get(status)) {
                    //之前没有操作过的，则可以进行操作
                    if (!seen.contains(nextStatus)) {
                        //若到达终点，则返回
                        if ("123450".equals(nextStatus)) {
                            return step;
                        }
                        //否则，将该节点加入队列、集合
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        //BFS后若无法到达终点，则返回-1
        return -1;
    }

    // 枚举 status 通过一次交换操作得到的状态
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        //只能是0和附近的元素交换
        int x = status.indexOf('0');
        for (int y : neighbors[x]) {
            swap(array, x, y);
            ret.add(new String(array));
            swap(array, x, y);
        }
        return ret;
    }

    public void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
