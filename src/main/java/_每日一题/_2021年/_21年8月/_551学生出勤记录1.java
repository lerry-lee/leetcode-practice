package _每日一题._2021年._21年8月;

/**
 * @ClassName: _551学生出勤记录1
 * @Author: lerry_li
 * @CreateDate: 2021/08/17
 * @Description
 */
public class _551学生出勤记录1 {
    /**
     * 解法1：模拟 时间O(N) 空间O(1)
     */
    public boolean checkRecord(String s) {
        if(s==null||s.length()<2) return true;
        int absent=0,late=0;
        char prev='P';
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='A') absent++;
            else if(c=='L') {
                if(prev=='L') late++;
                else late=1;
            }
            prev=c;
            if(absent>=2) return false;
            if(late>=3) return false;
        }
        return true;
    }
}
