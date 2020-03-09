package ru.job4j.employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeesStore {
    private static final EmployeesStore INST = new EmployeesStore();
    private final List<Employee> list = new ArrayList<>();

    static EmployeesStore getInstance() {
        return INST;
    }

    private EmployeesStore() {
        list.add(new Employee(R.drawable.ic_action_name,
                "John Black", "10.11.1980", "Java programmer"));
        list.add(new Employee(R.drawable.ic_action_name,
                "Antony Lancer", "14.03.1988", "Java programmer"));
        list.add(new Employee(R.drawable.ic_action_name,
                "Li Chang", "26.12.1979", "Java programmer"));
        list.add(new Employee(R.drawable.ic_action_name,
                "Rick White", "11.04.1977", "C+ programmer"));
        list.add(new Employee(R.drawable.ic_action_name,
                "Leo Woodland", "03.01.1991", "C+ programmer"));
        list.add(new Employee(R.drawable.ic_action_name,
                "Tom Rock", "01.07.1996", "Python programmer"));
        list.add(new Employee(R.drawable.ic_action_name,
                "Lori Dior", "18.05.1982", "Python programmer"));
        list.add(new Employee(R.drawable.ic_action_name,
                "Tim Lion", "02.04.1979", "Android developer"));
        list.add(new Employee(R.drawable.ic_action_name,
                "Mio Storm", "13.09.1973", "Android developer"));
    }

    Employee get(int index) {
        return list.get(index);
    }

    public void add(Employee employee) {
        list.add(employee);
    }

    int size() {
        return list.size();
    }
}
