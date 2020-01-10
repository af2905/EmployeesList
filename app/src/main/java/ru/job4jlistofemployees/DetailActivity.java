package ru.job4jlistofemployees;

import androidx.fragment.app.Fragment;

public class DetailActivity extends BaseActivity {
    @Override
    public Fragment loadFrg() {
        return DetailFragment.of(
                getIntent().getExtras().getInt(WorkersFragment.PERSON_PHOTO, 0),
                getIntent().getExtras().getString(WorkersFragment.PERSON_NAME, ""),
                getIntent().getExtras().getString(WorkersFragment.PERSON_BIRTH, ""),
                getIntent().getExtras().getInt(WorkersFragment.PERSON_SPECIALTY_ID));
    }
}
