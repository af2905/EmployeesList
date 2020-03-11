package ru.job4j.employees.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.job4j.employees.R;
import ru.job4j.employees.model.Employee;
import ru.job4j.employees.store.EmployeesStore;
import ru.job4j.employees.store.SpecialtiesStore;

public class EmployeeFragment extends Fragment {
    private final EmployeesStore employeesStore = EmployeesStore.getInstance();
    private static final String TAG = "log";

    static EmployeeFragment of(int index) {
        EmployeeFragment fragment = new EmployeeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employee, container, false);
        Employee employee = employeesStore.get(getArguments().getInt("index", 0));
        TextView name = view.findViewById(R.id.name);
        name.setText(employee.getName());
        TextView birth = view.findViewById(R.id.date_of_birth);
        birth.setText(employee.getDateOfBirth());
        TextView specialty = view.findViewById(R.id.specialty);
        Log.d(TAG, "employee.getSpecialtyId(): " + employee.getSpecialtyId()
                + " EmployeesFragment.specialtyId: " + EmployeesFragment.specialtyId);
        specialty.setText(String.valueOf(
                SpecialtiesStore.getInstance()
                        .get(EmployeesFragment.specialtyPosition).getTitle()));
        ImageView photo = view.findViewById(R.id.photo);
        photo.setImageResource(employee.getPhoto());
        return view;
    }
}