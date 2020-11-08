package SwordFingerOffer;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: _13机器人的运动范围
 * @Signature: Created by lerry_li on 2020/11/08
 * @Description: 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class _13机器人的运动范围 {
    /**
     * 解法1：巧算数位和+深度优先遍历 时间O(MN) 空间O(MN)
     * 巧算数位和：设数字i的数位和为iSum，数字i的前一个数字i-1的数位和为pre_iSum
     *      1）若i为0：iSum=0
     *      2）若i%10=0，即i为10的倍数：iSum=pre_iSum-8
     *              例如：10的数位和iSum=1+0=1；9的数位和pre_iSum=9，1=9-8;
     *                   20的数位和iSum=2+0=2；19的数位和pre_iSum=1+9=10，2=10-8;
     *                   320的数位和iSum=3+2+0=5；319的数位和pre_iSum=3+1+9=13，5=3-8;
     *      3）若i%10!=0：iSum=pre_iSum+1
     *              例如：2的数位和=1的数位和+1；
     *                   18的数位和=17的数位和+1；
     * 深度优先遍历：
     *      1）边界条件
     *      2）使用visited数组
     */
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }
        res = 0;
        int iSum = 0, jSum = 0;
        boolean[][] grid=new boolean[m][n];
        boolean[][] visited=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            iSum = cal(i, iSum);
            for (int j = 0; j < n; j++) {
                jSum = cal(j, jSum);
                if ((iSum + jSum) <= k) {
                    grid[i][j]=true;
                }
            }
        }
        dfs(grid,visited,0,0);
        return res;
    }
    int res;
    public void dfs(boolean[][] grid,boolean[][] visited,int row,int column){
        if(row<0||row>grid.length-1||column<0||column>grid[row].length-1||visited[row][column]){
            return;
        }
        if(grid[row][column]){
            res++;
            visited[row][column]=true;
            dfs(grid,visited,row+1,column);
            dfs(grid,visited,row-1,column);
            dfs(grid,visited,row,column+1);
            dfs(grid,visited,row,column-1);
        }
    }

    public int cal(int i, int iSum) {
        if (i == 0) {
            return 0;
        }
        if (i % 10 == 0) {
            return iSum - 8;
        } else {
            return iSum + 1;
        }
    }

    /**
     * 解法2：广度优先遍历
     * 数据结构：双端队列deque
     * 初始化：将单元格(0,0)加入队尾deque
     * 迭代终止条件：deque为空
     * 迭代工作：
     *      1.单元格出队：将队首单元格(row,column)弹出
     *      2.判断当前单元格可达的单元格是否可以加入队列：
     *      【判断当前单元格的右方、下方单元格是否可以加入队列】
     *              ①下标未越界；
     *              ②当前位置元素未被访问过，即visited[row][column]=false；
     *              ③当前单元格满足数位和条件，即grid[row][column]=true；
     *      3.处理：
     *              ①计数器+1；
     *              ②标记当前单元格，即visited[row][column]=true；
     *              ③当前单元格入队：将当前单元格(row,column)加入队尾
     */
    public int movingCount2(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }
        int iSum = 0, jSum = 0;
        boolean[][] grid=new boolean[m][n];
        boolean[][] visited=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            iSum = cal(i, iSum);
            for (int j = 0; j < n; j++) {
                jSum = cal(j, jSum);
                if ((iSum + jSum) <= k) {
                    grid[i][j]=true;
                }
            }
        }
        Deque<int[]> deque=new LinkedList<>();
        deque.offerLast(new int[]{0,0});
        int res=1;
        while(!deque.isEmpty()){
            int size=deque.size();
            for (int i = 0; i < size; i++) {
                int[] idx=deque.pollFirst();
                int row=idx[0];
                int column=idx[1];
                if(row+1>=0&&row+1<m&&!visited[row+1][column]&&grid[row+1][column]){
                    res++;
                    visited[row+1][column]=true;
                    deque.offerLast(new int[]{row+1,column});
                }
                if(column+1>=0&&column+1<n&&!visited[row][column+1]&&grid[row][column+1]){
                    res++;
                    visited[row][column+1]=true;
                    deque.offerLast(new int[]{row,column+1});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _13机器人的运动范围 instance = new _13机器人的运动范围();
        System.out.println(instance.movingCount2(16, 8, 4));
        System.out.println(instance.movingCount2(1, 2, 1));
    }
}
