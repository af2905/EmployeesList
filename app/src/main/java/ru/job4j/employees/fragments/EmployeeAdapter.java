package ru.job4j.employees.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.job4j.employees.R;
import ru.job4j.employees.model.Employee;
import ru.job4j.employees.store.EmployeesStore;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {

    private final EmployeesStore employeesStore = EmployeesStore.getInstance();

    private final EmployeesFragment.EmployeeSelect select;

    EmployeeAdapter(EmployeesFragment.EmployeeSelect select) {
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
        holder.bind(employeesStore.get(position), position);
    }

    @Override
    public int getItemCount() {
        return employeesStore.size();
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
            name.setOnClickListener(event -> select.selected(index));
        }
    }
}
