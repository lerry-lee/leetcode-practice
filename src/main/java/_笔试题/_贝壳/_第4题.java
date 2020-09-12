package _笔试题._贝壳;

import java.util.Scanner;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/07 15:43
 * @description TODO
 */
public class _第4题 {
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
        dfs(array,0,0,0);
        System.out.println(min);
    }

    public static void dfs(int[][] array,int i,int j,int count){
        if(i<0||j<0||i>=array.length||j>=array[i].length){
            min=Math.min(min,count);
            return;
        }
        if(array[i][j]==0){
            dfs(array,i+1,j,count+1);
            for(int k=0;k<array[i].length;k++){
                if(array[i][k]==1){
                    dfs(array,i+1,k,count+1);
                }
            }
        }
        else{
            dfs(array,i+1,j,count);
            for(int k=0;k<array[i].length;k++){
                if(array[i][k]==1){
                    dfs(array,i+1,k,count);
                }
            }
        }
    }
}
