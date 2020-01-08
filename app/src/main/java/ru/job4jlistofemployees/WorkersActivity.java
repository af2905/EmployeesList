package ru.job4jlistofemployees;

import androidx.fragment.app.Fragment;

public class WorkersActivity extends BaseActivity {

    @Override
    public Fragment loadFrg() {
        return new WorkersFragment();
    }
}
