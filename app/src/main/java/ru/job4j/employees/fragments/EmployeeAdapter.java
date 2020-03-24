package ru.job4j.employees.fragments;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.job4j.employees.R;
import ru.job4j.employees.model.Employee;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {
    private static final String TAG = "log";
    private final List<Employee> employees;
    private final EmployeesFragment.EmployeeSelect select;

    EmployeeAdapter(List<Employee> employees, EmployeesFragment.EmployeeSelect select) {
        this.employees = employees;
        this.select = select;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmployeeHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row, parent, false), select
        );
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        Log.d(TAG, "position: " + position);
        holder.bind(employees.get(position), position);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    static class EmployeeHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final EmployeesFragment.EmployeeSelect select;

        EmployeeHolder(@NonNull View itemView, EmployeesFragment.EmployeeSelect select) {
            super(itemView);
            this.select = select;
            name = itemView.findViewById(R.id.name);
        }

        void bind(Employee employee, int index) {
            name.setText(employee.getName());
            name.setOnClickListener(event -> select.selected(
                    index, employee.getId(), employee.getSpecialty().getTitle()));
        }
    }
}
