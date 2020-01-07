package ru.job4jlistofemployees;

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

public class SpecialtiesFragment extends Fragment {
    private RecyclerView specialtiesRecyclerView;
    private SpecialtyAdapter adapter;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.specialties_fragment, container, false);
        specialtiesRecyclerView = view.findViewById(R.id.specialties);
        specialtiesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    public class SpecialtyHolder extends RecyclerView.ViewHolder {
        private View view;

        public SpecialtyHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public class SpecialtyAdapter extends RecyclerView.Adapter<SpecialtyHolder> {
        private final List<Specialty> specialties;

        public SpecialtyAdapter(List<Specialty> specialties) {
            this.specialties = specialties;
        }

        @NonNull
        @Override
        public SpecialtyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.info_specialty, parent, false);
            return new SpecialtyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SpecialtyHolder holder, int position) {
            final Specialty specialty = this.specialties.get(position);
            TextView id = holder.view.findViewById(R.id.specialty_id);
            id.setText(String.valueOf(position+1));
            TextView title = holder.view.findViewById(R.id.specialty_title);
            title.setText(specialty.getTitle());
        }

        @Override
        public int getItemCount() {
            return this.specialties.size();
        }
    }

    private void updateUI() {
        SpecialtiesStore store = SpecialtiesStore.get(getActivity());
        List<Specialty> specialties = store.getSpecialties();
        adapter = new SpecialtyAdapter(specialties);
        specialtiesRecyclerView.setAdapter(adapter);
    }
}
