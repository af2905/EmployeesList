package ru.job4j.employees.fragments;

import androidx.fragment.app.Fragment;

public class SpecialtiesActivity extends BaseActivity {
    @Override
    public Fragment loadFrg() {
        return new SpecialtiesFragment();
    }
}
