package ru.job4j.employees.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.job4j.employees.R;
import ru.job4j.employees.model.Specialty;
import ru.job4j.employees.store.SpecialtiesStore;

public class SpecialtiesFragment extends Fragment {
    private RecyclerView recyclerView;
    private SpecialtyAdapter adapter;
    private final SpecialtiesStore specialtiesStore = SpecialtiesStore.getInstance();
    final static String SPECIALTY_ID = "id";
    final static String SPECIALTY_POSITION = "position";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.specialties, container, false);
        recyclerView = view.findViewById(R.id.specialties);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new SpecialtyAdapter(specialtiesStore.getSpecialties());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public class SpecialtyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final List<Specialty> specialties;

        SpecialtyAdapter(List<Specialty> specialties) {
            this.specialties = specialties;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.specialty, parent, false)) {
            };
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            final Specialty specialty = specialties.get(position);
            TextView title = holder.itemView.findViewById(R.id.specialty);
            title.setText(String.format("%ss", specialty.getTitle()));
            title.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), EmployeesActivity.class);
                intent.putExtra(SPECIALTY_ID, specialty.getId());
                intent.putExtra(SPECIALTY_POSITION, position);
                startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return this.specialties.size();
        }
    }
}
