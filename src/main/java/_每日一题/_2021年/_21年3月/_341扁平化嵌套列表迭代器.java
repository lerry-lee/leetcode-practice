package _每日一题._2021年._21年3月;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _341扁平化嵌套列表迭代器
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 多叉树的DFS
 */
public class _341扁平化嵌套列表迭代器 {

    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private Stack<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                if (stack.peek().isInteger()) {
                    return true;
                }
                List<NestedInteger> nestedList = stack.pop().getList();
                for (int i = nestedList.size() - 1; i >= 0; i--) {
                    stack.push(nestedList.get(i));
                }
            }
            return false;
        }

    }
}
