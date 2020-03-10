package ru.job4j.employees.store;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

import ru.job4j.employees.model.Specialty;

public class SpecialtiesStore {
    private static SpecialtiesStore instance;
    private List<Specialty> specialties;

    public static SpecialtiesStore get(Context context) {
        if (instance == null) {
            instance = new SpecialtiesStore(context);
        }
        return instance;
    }

    private SpecialtiesStore(Context context) {
        specialties = Arrays.asList(
                new Specialty(1, "Java programmer"),
                new Specialty(2, "C+ programmer"),
                new Specialty(3, "Python programmer"),
                new Specialty(4, "Android developer"));
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

}
