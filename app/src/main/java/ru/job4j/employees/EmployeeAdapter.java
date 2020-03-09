package ru.job4j.employees;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {
    private final EmployeesStore store = EmployeesStore.getInstance();
    private final EmployeesFragment.EmployeeSelect select;

    public EmployeeAdapter(EmployeesFragment.EmployeeSelect select) {
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
        holder.bind(store.get(position), position);
    }

    @Override
    public int getItemCount() {
        return store.size();
    }

    public static class EmployeeHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final EmployeesFragment.EmployeeSelect select;

        public EmployeeHolder(@NonNull View itemView, EmployeesFragment.EmployeeSelect select) {
            super(itemView);
            this.select = select;
            name = itemView.findViewById(R.id.name);
        }

        public void bind(Employee employee, int index) {
            name.setText(employee.getName());
            name.setOnClickListener(event -> select.selected(index));
        }
    }
}
