package com.boatrain.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return doGetImportance(map.get(id));
    }

    private int doGetImportance(Employee employee) {
        int ans = employee.importance;
        if (employee.subordinates.size() == 0) {
            return ans;
        }

        for (int subId : employee.subordinates) {
            ans += doGetImportance(map.get(subId));
        }
        return ans;
    }

    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}