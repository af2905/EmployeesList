package ru.job4j.employees.store;

import java.util.ArrayList;
import java.util.List;

import ru.job4j.employees.model.Specialty;

public class SpecialtiesStore {
    private static final SpecialtiesStore INST = new SpecialtiesStore();
    private final List<Specialty> list = new ArrayList<>();

    public static SpecialtiesStore getInstance() {
        return INST;
    }

    private SpecialtiesStore() {
        list.add(new Specialty(1, "Java programmer"));
        list.add(new Specialty(2, "C+ programmer"));
        list.add(new Specialty(3, "Python programmer"));
        list.add(new Specialty(4, "Android developer"));
    }

    public List<Specialty> getSpecialties() {
        return list;
    }

    public Specialty get(int index) {
        return list.get(index);
    }

    public void add(Specialty specialty) {
        list.add(specialty);
    }

    public int size() {
        return list.size();
    }
}

