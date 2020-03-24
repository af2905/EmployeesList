package ru.job4j.employees.fragments;

import android.os.Bundle;
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
import ru.job4j.employees.store.SqlStore;

public class EmployeeFragment extends Fragment {
    private final SqlStore sqlStore = SqlStore.getInstance(getContext());
    private static final String TAG = "log";

    static EmployeeFragment of(int index, int id, String specialty) {
        EmployeeFragment fragment = new EmployeeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        bundle.putInt("id", id);
        bundle.putString("specialty", specialty);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employee, container, false);
        int id = getArguments().getInt("id");
        String specialtyTitle = getArguments().getString("specialty");
        Employee employee = sqlStore.getEmployee(id);
        TextView name = view.findViewById(R.id.name);
        name.setText(employee.getName());
        TextView birth = view.findViewById(R.id.date_of_birth);
        birth.setText(employee.getBirth());
        TextView specialty = view.findViewById(R.id.specialty);
        specialty.setText(specialtyTitle);
        ImageView photo = view.findViewById(R.id.photo);
        photo.setImageResource(employee.getPhoto());
        return view;
    }
}