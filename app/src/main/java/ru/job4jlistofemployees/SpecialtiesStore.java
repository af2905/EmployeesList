package ru.job4jlistofemployees;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SpecialtiesStore {
    private static SpecialtiesStore instance;
    private List<Specialty> specialties;

       public static SpecialtiesStore get (Context context) {
        if (instance == null) {
            instance = new SpecialtiesStore(context);
        }
        return instance;
    }

    private SpecialtiesStore(Context context) {
        specialties = Arrays.asList(
                new Specialty(specialtyId(), "Java programmer"),
                new Specialty(specialtyId(), "C+ programmer"),
                new Specialty(specialtyId(), "Python programmer"),
                new Specialty(specialtyId(), "Android developer"));
        }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    UUID specialtyId() {
        return UUID.randomUUID();
    }
}
