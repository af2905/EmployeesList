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
                1, R.drawable.ic_action_name));
        list.add(new Employee("Antony Lancer", "14.03.1988",
                1, R.drawable.ic_action_name));
        list.add(new Employee("Li Chang", "26.12.1979",
                1, R.drawable.ic_action_name));
        list.add(new Employee("Rick White", "11.04.1977",
                2, R.drawable.ic_action_name));
        list.add(new Employee("Leo Woodland", "03.01.1991",
                2, R.drawable.ic_action_name));
        list.add(new Employee("Tom Rock", "01.07.1996",
                3, R.drawable.ic_action_name));
        list.add(new Employee("Lori Dior", "18.05.1982",
                3, R.drawable.ic_action_name));
        list.add(new Employee("Tim Lion", "02.04.1979",
                4, R.drawable.ic_action_name));
        list.add(new Employee("Mio Storm", "13.09.1973",
                4, R.drawable.ic_action_name));
    }

    public List<Employee> getEmployees() {
        return list;
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
