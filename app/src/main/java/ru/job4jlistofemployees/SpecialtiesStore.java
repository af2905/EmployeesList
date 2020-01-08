package ru.job4jlistofemployees;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

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
                new Specialty(00001, "Java programmer"),
                new Specialty(00002, "C+ programmer"),
                new Specialty(00003, "Python programmer"),
                new Specialty(00004, "Android developer"));
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

}
