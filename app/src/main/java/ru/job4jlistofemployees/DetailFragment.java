package ru.job4jlistofemployees;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class DetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_info_fragment, container, false);
        ImageView personPhoto = view.findViewById(R.id.person_photo);
        TextView personDetailInfo = view.findViewById(R.id.person_detail_info);

        int photo = getArguments().getInt(WorkersFragment.PERSON_PHOTO);

        personPhoto.setImageResource(photo);

        String name = getArguments().getString(WorkersFragment.PERSON_NAME);
        String dateOfBirth = getArguments().getString(WorkersFragment.PERSON_BIRTH);

        int id = getArguments().getInt(WorkersFragment.PERSON_SPECIALTY_ID);

        SpecialtiesStore store = SpecialtiesStore.get(getActivity());
        List<Specialty> specialties = store.getSpecialties();

        String title = "";
        for (Specialty specialty : specialties) {
            if (id == specialty.getId()) {
                title = specialty.getTitle();
            }
        }
        personDetailInfo.setText(name + "\n" + dateOfBirth + "\n" + title);
        return view;
    }

    public static DetailFragment of(int photo, String name, String birth, int id) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(WorkersFragment.PERSON_PHOTO, photo);
        bundle.putString(WorkersFragment.PERSON_NAME, name);
        bundle.putString(WorkersFragment.PERSON_BIRTH, birth);
        bundle.putInt(WorkersFragment.PERSON_SPECIALTY_ID, id);
        detailFragment.setArguments(bundle);
        return detailFragment;

    }
}
