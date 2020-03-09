package ru.job4j.employees;

import androidx.fragment.app.Fragment;

public class EmployeeActivity extends BaseActivity {
    @Override
    public Fragment loadFrg() {
        return EmployeeFragment.of(
                getIntent().getIntExtra("index", 0));
    }
}
