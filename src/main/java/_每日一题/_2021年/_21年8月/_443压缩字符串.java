package _每日一题._2021年._21年8月;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/21
 */
public class _443压缩字符串 {

    public static void main(String[] args) {
        _443压缩字符串 instance=new _443压缩字符串();
        System.out.println(instance.compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(instance.compress(new char[]{'a'}));
        System.out.println(instance.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

    /**
     * 解法1：双指针(一个是有效指针，一个是遍历指针) 时间O(N) 空间O(1)
     */
    public int compress(char[] chars) {
        //特判
        if(chars==null||chars.length==0) return 0;
        //处理好的指针
        int end=0;
        //遍历指针，一个记录这组字符的首位字符，一个用来遍历
        int prev=0,cur=0;
        //遍历数组
        while(cur<chars.length){
            //prev指针记录这组字符是啥，cur指针记录这组字符有多少个
            while(cur<chars.length&&chars[cur]==chars[prev]){
                cur++;
            }
            //填充这一组相同字符'?'
            chars[end]=chars[prev];
            //计算该字符出现的次数，并按位填充（个十百千万）
            int newEnd=end;
            int cnt=cur-prev;
            //出现次数超过1才按位拆分
            if(cnt>1){
                while(cnt>0){
                    chars[++newEnd]= (char) (cnt%10+48);
                    cnt/=10;
                }
            }
            //翻转这部分，因为是从低位到高位取出来的
            int l=end+1;
            int r=newEnd;
            while(l<r){
                swap(chars,l,r);
                l++;
                r--;
            }
            //更新有效指针
            end=newEnd+1;
            prev=cur;
        }
        return end;
    }

    private void swap(char[] chars, int l, int r) {
        char temp=chars[l];
        chars[l]=chars[r];
        chars[r]=temp;
    }
}
