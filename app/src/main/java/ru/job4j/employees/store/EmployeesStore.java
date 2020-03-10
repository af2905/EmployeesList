package ru.job4j.employees.store;

import java.util.ArrayList;
import java.util.List;

import ru.job4j.employees.R;
import ru.job4j.employees.model.Employee;

public class EmployeesStore {
    private static final EmployeesStore INST = new EmployeesStore();
    private final List<Employee> list = new ArrayList<>();

    public static EmployeesStore getInstance() {
        return INST;
    }

    private EmployeesStore() {
        list.add(new Employee("John Black", "10.11.1980",
                "Java programmer", R.drawable.ic_action_name));
        list.add(new Employee("Antony Lancer", "14.03.1988",
                "Java programmer", R.drawable.ic_action_name));
        list.add(new Employee("Li Chang", "26.12.1979",
                "Java programmer", R.drawable.ic_action_name));
        list.add(new Employee("Rick White", "11.04.1977",
                "C+ programmer", R.drawable.ic_action_name));
        list.add(new Employee("Leo Woodland", "03.01.1991",
                "C+ programmer", R.drawable.ic_action_name));
        list.add(new Employee("Tom Rock", "01.07.1996",
                "Python programmer", R.drawable.ic_action_name));
        list.add(new Employee("Lori Dior", "18.05.1982",
                "Python programmer", R.drawable.ic_action_name));
        list.add(new Employee("Tim Lion", "02.04.1979",
                "Android developer", R.drawable.ic_action_name));
        list.add(new Employee("Mio Storm", "13.09.1973",
                "Android developer", R.drawable.ic_action_name));
    }

    public Employee get(int index) {
        return list.get(index);
    }

    public void add(Employee employee) {
        list.add(employee);
    }

    public int size() {
        return list.size();
    }
}
