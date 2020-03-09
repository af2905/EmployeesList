package ru.job4j.employees;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class EmployeesActivity extends BaseActivity implements EmployeesFragment.EmployeeSelect {
    @Override
    public Fragment loadFrg() {
        return new EmployeesFragment();
    }

    @Override
    public void selected(int index) {
        if (findViewById(R.id.detail) == null) {
            Intent intent = new Intent(this, EmployeeActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        } else {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.detail, EmployeeFragment.of(index))
                    .commit();
        }
    }
}
