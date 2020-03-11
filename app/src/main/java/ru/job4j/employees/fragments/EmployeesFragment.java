package ru.job4j.employees.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.job4j.employees.R;
import ru.job4j.employees.model.Employee;
import ru.job4j.employees.store.EmployeesStore;

public class EmployeesFragment extends Fragment {
    private RecyclerView recycler;
    private EmployeeSelect select;
    static int specialtyId;
    static int specialtyPosition;

    public interface EmployeeSelect {
        void selected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employees, container, false);
        recycler = view.findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        specialtyId = getArguments().getInt(SpecialtiesFragment.SPECIALTY_ID);
        specialtyPosition = getArguments().getInt(SpecialtiesFragment.SPECIALTY_POSITION);
        updateUI();
        return view;
    }

    private void updateUI() {
        List<Employee> employees = EmployeesStore.getInstance().getEmployees();
        List<Employee> selective = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSpecialtyId() == specialtyId) {
                selective.add(employee);
            }
        }
        RecyclerView.Adapter adapter = new EmployeeAdapter(selective, select);
        recycler.setAdapter(adapter);
    }

    static EmployeesFragment of(int id, int position) {
        EmployeesFragment fragment = new EmployeesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SpecialtiesFragment.SPECIALTY_ID, id);
        bundle.putInt(SpecialtiesFragment.SPECIALTY_POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.select = (EmployeeSelect) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.select = null;
    }
}
