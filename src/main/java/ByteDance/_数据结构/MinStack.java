package ByteDance._数据结构;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lerry_lee
 * @version 1.0
 * @create 2020/06/24 09:35
 * @description 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
public class MinStack {
    private List<Integer> stack;
    private int top = 0;
    //    private int min;
    private List<Integer> min;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.stack.add(null);
        this.min = new ArrayList<>();
        this.min.add(Integer.MAX_VALUE);
//        min=Integer.MAX_VALUE;
    }

    public void push(int x) {
        this.stack.add(x);
        this.min.add(Math.min(this.min.get(this.top), x));
        this.top++;
    }

    public void pop() {
        this.stack.remove(this.top);
        this.min.remove(this.top);
        this.top--;

//        this.min=Integer.MAX_VALUE;
//        for (int i = 0; i <= top; i++) {
//            this.min = Math.min(min, stack.get(i));
//        }
    }

    public int top() {
        return this.stack.get(this.top);
    }

    public int getMin() {
        return this.min.get(this.top);
    }
}
