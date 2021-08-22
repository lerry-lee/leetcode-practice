package _每日一题._2021年._21年8月;


/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/22
 */
public class _789逃脱阻碍者 {

    public static void main(String[] args) {
        _789逃脱阻碍者 instance = new _789逃脱阻碍者();
        int[][] ghosts = new int[][]{{1, 0}, {0, 3}};
        int[] target = new int[]{0, 1};
        System.out.println(instance.escapeGhosts(ghosts, target));//true
        ghosts = new int[][]{{5, 0}, {-10, -2}, {0, -5}, {-2, -2}, {-7, 1}};
        target = new int[]{7, 7};
        System.out.println(instance.escapeGhosts(ghosts, target));//false
        ghosts = new int[][]{{1, 0}};
        target = new int[]{2, 0};
        System.out.println(instance.escapeGhosts(ghosts, target));//false
        ghosts = new int[][]{{2, 0}};
        target = new int[]{1, 0};
        System.out.println(instance.escapeGhosts(ghosts, target));//false
    }

    /**
     * 解法1：曼哈顿距离 时间O(N) 空间O(1)
     *
     * @param ghosts 障碍物坐标
     * @param target 目标点
     * @return true/false
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        //特判
        if (ghosts == null || ghosts.length == 0 || (target[0] == 0 && target[1] == 0)) return true;
        //计算从原点(0,0)到target(x,y)的最短路径
        int shortestPath = manhattanDistance(new int[]{0, 0}, target);
        //遍历所有障碍点，计算它们到target的最短路径
        for (int[] ghost : ghosts) {
            //若有一个障碍点的最短路径比原点的更小，则返回false
            if (manhattanDistance(ghost, target) <= shortestPath) return false;
        }
        return true;
    }

    /**
     * 计算给出的两个点的曼哈顿距离
     * @return |x1-x2| + |y1-y2|
     */
    private int manhattanDistance(int[] start, int[] target) {
        return Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1]);
    }
}
