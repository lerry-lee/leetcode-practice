package ByteDance._动态或贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lerry_lee
 * @version 1.0
 * @create 2020/06/23 09:44
 * @description 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class _俄罗斯套娃信封问题 {
    /**
     * 先对信封的长进行排序，然后对宽"求最长上升子序列"
     */
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0) return 0;
        int[] dp=new int[envelopes.length];
        return 0;
    }
    public int maxEnvelopes_求宽的最长上升子序列(int[][] envelopes){
        if(envelopes==null||envelopes.length==0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o2[1]-o1[1];
                else return o1[0]-o2[0];
            }
        });

        int[] dp=new int[envelopes.length];
        dp[0]=envelopes[0][1];
//        dp[0]=1;
        int end=1;
        for (int i = 1; i < envelopes.length; i++) {
//            dp[i]=searchMax(envelopes,dp,i,envelopes[i][1]);
            if(envelopes[i][1]>dp[end-1]) dp[end++]=envelopes[i][1];
            else bSearchMax(dp,0,end-1,envelopes[i][1]);
        }
        display(envelopes);
        display(dp);
//        int res=1;
//        for(int dpi:dp) res=Math.max(res,dpi);
//        return res;
        return end;
    }
    //二分查找：提高更新dp值效率
    public void bSearchMax(int[] dp,int l,int r,int tar){
        if(l==r) {
            dp[l] = tar;
            return;
        }
        int mid=(l+r)/2;
        if(dp[mid]<tar) bSearchMax(dp,mid+1,r,tar);
        else bSearchMax(dp,l,mid,tar);
    }

    //全部遍历之前的dp值，找到满足条件的最大的dp值，在此基础上加1，为新的位置上的dp值
    public int searchMax(int[][] envelopes,int[] dp,int end,int tar){
        int res=1;
        for (int i = 0; i < end; i++) {
            if(envelopes[i][1]<tar) res=Math.max(res,dp[i]+1);
        }
        return res;
    }

    public void display(int[][] envelopes){
        for(int[] en:envelopes){
            System.out.print("[ "+en[0]+","+en[1]+" ] ");
        }
        System.out.println();
    }
    public void display(int[] dp){
        for(int dpi:dp) System.out.print(dpi+" ");
        System.out.println();
    }
}
