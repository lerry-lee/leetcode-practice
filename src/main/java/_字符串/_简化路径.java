package _字符串;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * 一个方法是直接循环判断
 * 比较清洗的思路是用栈的数据结构
 */
public class _简化路径 {
    public static void main(String[] args) {
        String path = "/../a///b/./c/../";
        String path1 = "/../";
        System.out.println(useStack(path));

    }

    public static String commonMethod(String path) {
        String[] arr = path.split("/+");
        String[] res = new String[arr.length];
//        res[0]="/";
        int i = 0;
        for (String a : arr) {
            if (a.equals(".") || a.equals("")) continue;
            if (a.equals("..")) {
                if (i > 0) i--;
            } else {
                res[i] = a;
                i++;
            }

//            System.out.println(a);
        }
        StringBuilder path_res = new StringBuilder("/");

        for (int j = 0; j < i; j++) {
            path_res.append(res[j]).append("/");
        }
        if (path_res.length() > 1) path_res.setLength(path_res.length() - 1);
        return (path_res.toString());
    }

    public static String useStack(String path) {
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/+");

        for (String a : arr) {
            if (a.equals("") || a.equals(".")) continue;
            if (a.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else {
                stack.push(a);
            }
        }
        StringBuilder res = new StringBuilder();
        if (stack.isEmpty()) return "/";
        while (!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }

        return res.toString();
    }
}
