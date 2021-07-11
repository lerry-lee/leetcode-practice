package _每日一题._2021年._21年7月;

import java.util.*;

/**
 * @ClassName: _726原子的数量
 * @Author: lerry_li
 * @CreateTime: 2021/07/11
 * @Description
 * 解法1：栈+treemap
 */
public class _726原子的数量 {


    public static void main(String[] args) {
        _726原子的数量 instance = new _726原子的数量();
        System.out.println(instance.countOfAtoms("h2o"));
        System.out.println(instance.countOfAtoms("Mg(OH)2"));
        System.out.println(instance.countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println(instance.countOfAtoms("Be32"));
        System.out.println(instance.countOfAtoms("(H)"));
    }


    /**
     * 解法1：栈+treemap
     * tips：同样的原子可能在多处出现，可以加个后缀区分，后面在合并
     */
    public String countOfAtoms(String formula) {
        //特判
        if (formula == null || formula.length() == 0) return "";
        Stack<String> atomStack = new Stack<>();
        Map<String, Integer> atomFreqMap = new HashMap<>();
        int k = 100;
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            //若当前字符为数字
            if (Character.isDigit(c)) {
                //取连续的数字
                int j = i + 1;
                for (; j < formula.length(); j++) {
                    if (!Character.isDigit(formula.charAt(j))) break;
                }
                int num = Integer.parseInt(formula.substring(i, j));
                i = j - 1;
                String last = atomStack.peek();
                //若栈顶元素为')'
                if (last.equals(")")) {
                    //弹出')'
                    atomStack.pop();
                    Stack<String> tempStack = new Stack<>();
                    while (!atomStack.peek().equals("(")) {
                        String atom = atomStack.pop();
                        atomFreqMap.put(atom, atomFreqMap.getOrDefault(atom, 1) * num);
                        tempStack.push(atom);
                    }
                    //弹出'('
                    atomStack.pop();
                    while (!tempStack.isEmpty()) {
                        atomStack.push(tempStack.pop());
                    }
                }
                //否则，栈顶元素为字母，表示原子
                else {
                    String atom = atomStack.peek();
                    //乘上对应的数量
                    atomFreqMap.put(atom, atomFreqMap.getOrDefault(atom, 1) * num);
                }
            }
            //否则当前数字为字母，或括号
            else {
                //若为字母，取后面连续的小写字母
                if (Character.isLetter(c)) {
                    int j = i + 1;
                    for (; j < formula.length(); j++) {
                        if (!Character.isLowerCase(formula.charAt(j))) break;
                    }
                    String atom = formula.substring(i, j) + "_" + k;
                    k++;
                    i = j - 1;
                    atomStack.push(atom);
                }
                //否则，为括号
                else {
                    atomStack.push(String.valueOf(c));
                }
            }
        }
        //遍历栈
        PriorityQueue<String> minHeap = new PriorityQueue<>();
        //合并同样的原子
        Map<String, Integer> treeMap = new TreeMap<>();
        for (String atom : atomStack) {
            if(atom.equals("(")||atom.equals(")")) continue;
            String key = atom.substring(0, atom.length() - 4);
            treeMap.put(key, treeMap.getOrDefault(key, 0) + atomFreqMap.getOrDefault(atom,1));
        }
        StringBuilder sb = new StringBuilder();
        for (String atom : treeMap.keySet()) {
            sb.append(atom);
            int freq = treeMap.get(atom);
            if (freq > 1) sb.append(freq);
        }
        return sb.toString();
    }
}
