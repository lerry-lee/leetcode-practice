package _其他._笔试题._外企;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/22
 */
public class _1615_最大网络秩 {
    /**
     * 解法1：记录所有节点的度，如果两两节点相连，标记一下，然后遍历任意2点，计算他们的度之和，如果他们相连，则-1，最后找到最大的值
     */
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree=new int[n];
        boolean[][] connected=new boolean[n][n];
        for(int[] road:roads){
            degree[road[0]]++;
            degree[road[1]]++;
            connected[road[0]][road[1]]=connected[road[1]][road[0]]=true;
        }
        int res=0;
        int temp=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                temp=degree[i]+degree[j];
                if(connected[i][j]) temp--;
                res=Math.max(res,temp);
            }
        }
        return res;
    }
}
