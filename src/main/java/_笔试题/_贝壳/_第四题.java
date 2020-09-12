package _笔试题._贝壳;

import java.util.Scanner;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/07 15:43
 * @description TODO
 */
public class _第四题 {
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] array=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                array[i][j]=sc.nextInt();
            }
        }
//        boolean[][] visited=new boolean[n][m];
//        ,visited
        dfs(array,0,0,0);
        System.out.println(min);
    }
//    ,boolean[][] visited
    public static void dfs(int[][] array,int i,int j,int count){
        if(i<0||j<0||i>=array.length||j>=array[i].length){
            min=Math.min(min,count);
            return;
        }
//        if(visited[i][j]) return;
        if(array[i][j]==0){
//            visited[i][j]=true;
            dfs(array,i+1,j,count+1);
//            dfs(array,i-1,j,visited,count+1);
//            visited[i][j]=false;
            for(int k=0;k<array[i].length;k++){
                if(array[i][k]==1){
//                    visited[i][k]=true;
                    dfs(array,i+1,k,count+1);
//                    dfs(array,i-1,k,visited,count+1);
//                    visited[i][k]=false;
                }
            }
        }
        else{
//            visited[i][j]=true;
            dfs(array,i+1,j,count);
//            dfs(array,i-1,j,visited,count);
//            visited[i][j]=false;
            for(int k=0;k<array[i].length;k++){
                if(array[i][k]==1){
//                    visited[i][k]=true;
                    dfs(array,i+1,k,count);
//                    dfs(array,i-1,k,visited,count);
//                    visited[i][k]=false;
                }
            }
        }
    }
}
