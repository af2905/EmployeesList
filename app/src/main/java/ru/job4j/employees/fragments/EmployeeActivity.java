package ru.job4j.employees.fragments;

import androidx.fragment.app.Fragment;

public class EmployeeActivity extends BaseActivity {
    @Override
    public Fragment loadFrg() {
        return EmployeeFragment.of(getIntent()
                .getIntExtra("index", -1),
                getIntent().getIntExtra("id", -1),
                getIntent().getStringExtra("specialty"));
    }
}
