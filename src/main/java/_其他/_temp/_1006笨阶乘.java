package _其他._temp;

import java.util.Stack;

/**
 * @ClassName: _1006笨阶乘
 * @Author: lerry_li
 * @CreateTime: 2021/04/01
 * @Description
 */
public class _1006笨阶乘 {
    /**
     * 解法1：数据栈 时间O(N) 空间O(N)
     */
    public int clumsy(int N) {
        Stack<Integer> stack=new Stack<>();
        // int sign=1;
        int ops=0;
        while(N>0){
            int cur=N;
            if(ops==1){
                cur=(stack.pop()*cur);
            }else if(ops==2){
                cur=(stack.pop()/cur);
            }else if(ops==4){
                cur=-N;
            }
            stack.push(cur);
            ops++;
            if(ops==5){
                ops=1;
            }
            N--;
        }
        int res=0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        _1006笨阶乘 instance=new _1006笨阶乘();
        System.out.println(instance.clumsy(4));//7
        System.out.println(instance.clumsy(10));//12
    }
}
