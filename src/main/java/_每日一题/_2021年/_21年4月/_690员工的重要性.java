package _每日一题._2021年._21年4月;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: _690员工的重要性
 * @Author: lerry_li
 * @CreateDate: 2021/05/01
 * @Description
 * 解法1：递归
 */
public class _690员工的重要性 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    /**
     * 解法1：递归
     */
    public int getImportance(List<Employee> employees, int id) {
        hashMap = new HashMap<>();
        for (Employee employee : employees) {
            hashMap.put(employee.id, employee);
        }
        Employee employee = hashMap.get(id);
        return dfs(employee);
    }

    HashMap<Integer, Employee> hashMap;

    private int dfs(Employee employee) {
        int res = employee.importance;
        for (int id : employee.subordinates) {
            res += dfs(hashMap.get(id));
        }
        return res;
    }
}
