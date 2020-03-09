package ru.job4j.employees;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EmployeeFragment extends Fragment {
    private final EmployeesStore store = EmployeesStore.getInstance();

    public static EmployeeFragment of(int index) {
        EmployeeFragment fragment = new EmployeeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employee, container, false);
        Employee employee = store.get(getArguments().getInt("index", 0));
        TextView name = view.findViewById(R.id.name);
        name.setText(employee.getName());
        TextView dateOfBirth = view.findViewById(R.id.date_of_birth);
        dateOfBirth.setText(employee.getDateOfBirth());
        TextView specialty = view.findViewById(R.id.specialty);
        specialty.setText(employee.getSpecialty());
        ImageView photo = view.findViewById(R.id.photo);
        photo.setImageResource(employee.getPhoto());
        return view;
    }
}