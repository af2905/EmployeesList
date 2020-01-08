package ru.job4jlistofemployees;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WorkersFragment extends Fragment {
    private RecyclerView workersRecyclerView;
    private WorkerAdapter adapter;
    List<Worker> workersSelectiveList = new ArrayList<>();

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.workers_fragment, container, false);
        workersRecyclerView = view.findViewById(R.id.workers);
        workersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    public class WorkerHolder extends RecyclerView.ViewHolder {
        private View view;

        public WorkerHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public class WorkerAdapter extends RecyclerView.Adapter<WorkerHolder> {
        private final List<Worker> workers;

        public WorkerAdapter(List<Worker> workers) {
            this.workers = workers;
        }

        @NonNull
        @Override
        public WorkersFragment.WorkerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.info_worker, parent, false);
            return new WorkerHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull WorkerHolder holder, int position) {
            final Worker worker = this.workers.get(position);
            TextView name = holder.view.findViewById(R.id.worker_name);
            name.setText(worker.getName());

            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Нажато: " + v.getId(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return this.workers.size();
        }
    }

    private void updateUI() {
        WorkersStore store = WorkersStore.get(getActivity());
        List<Worker> workers = store.getWorkers();
        int specialtyId = getActivity().getIntent().getIntExtra("specialtyId", 0);
        for (Worker worker : workers) {
            if (worker.getSpecialtyId() == specialtyId) {
                workersSelectiveList.add(worker);
            }
        }
        adapter = new WorkerAdapter(workersSelectiveList);
        workersRecyclerView.setAdapter(adapter);
    }
}
