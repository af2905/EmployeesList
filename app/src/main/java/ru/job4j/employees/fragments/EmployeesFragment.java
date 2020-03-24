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

import java.util.List;

import ru.job4j.employees.R;
import ru.job4j.employees.model.Employee;
import ru.job4j.employees.store.SqlStore;

public class EmployeesFragment extends Fragment {
    private RecyclerView recycler;
    private EmployeeSelect select;
    private SqlStore sqlStore = SqlStore.getInstance(getContext());
    private static int specialtyId;

    public interface EmployeeSelect {
        void selected(int index, int id, String specialty);
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
        updateUI();
        return view;
    }

    private void updateUI() {
        List<Employee> employees = sqlStore.getSelectedEmployees(specialtyId);
        RecyclerView.Adapter adapter = new EmployeeAdapter(employees, select);
        recycler.setAdapter(adapter);
    }

    static EmployeesFragment of(int id) {
        EmployeesFragment fragment = new EmployeesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SpecialtiesFragment.SPECIALTY_ID, id);
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
