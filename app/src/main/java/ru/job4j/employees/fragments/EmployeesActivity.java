package ru.job4j.employees.fragments;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import ru.job4j.employees.R;

public class EmployeesActivity extends BaseActivity implements EmployeesFragment.EmployeeSelect {

    @Override
    public Fragment loadFrg() {
        return EmployeesFragment
                .of(getIntent()
                        .getIntExtra(SpecialtiesFragment.SPECIALTY_ID, -1));
    }

    @Override
    public void selected(int index, int id, String specialty) {
        if (findViewById(R.id.detail) == null) {
            Intent intent = new Intent(this, EmployeeActivity.class);
            intent.putExtra("index", index);
            intent.putExtra("id", id);
            intent.putExtra("specialty", specialty);
                    startActivity(intent);
        } else {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.detail, EmployeeFragment.of(index, id, specialty))
                    .commit();
        }
    }
}
