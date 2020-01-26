package ru.job4j.employees;

import androidx.fragment.app.Fragment;

public class WorkersActivity extends BaseActivity {

    @Override
    public Fragment loadFrg() {
        return WorkersFragment.of(getIntent()
                .getIntExtra(SpecialtiesFragment.SPECIALTY_ID, 0));
    }
}
