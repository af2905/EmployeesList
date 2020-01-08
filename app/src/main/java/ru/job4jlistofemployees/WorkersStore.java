package ru.job4jlistofemployees;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

public class WorkersStore {
    private static WorkersStore instance;
    private List<Worker> workers;

    public static WorkersStore get(Context context) {
        if (instance == null) {
            instance = new WorkersStore(context);
        }
        return instance;
    }

    private WorkersStore(Context context) {
        workers = Arrays.asList(
                new Worker(R.drawable.ic_person_black_24dp,
                        "John Black", "10.11.1980", 00001),
                new Worker(R.drawable.ic_person_black_24dp,
                        "Antony Lancer", "14.03.1988", 00001),
                new Worker(R.drawable.ic_person_black_24dp,
                        "Li Chang", "26.12.1979", 00001),
                new Worker(R.drawable.ic_person_black_24dp,
                        "Rick White", "11.04.1977", 00002),
                new Worker(R.drawable.ic_person_black_24dp,
                        "Leo Woodland", "03.01.1991", 00002),
                new Worker(R.drawable.ic_person_black_24dp,
                        "Tom Rock", "01.07.1996", 00003),
                new Worker(R.drawable.ic_person_black_24dp,
                        "Lori Dior", "18.05.1982", 00003),
                new Worker(R.drawable.ic_person_black_24dp,
                        "Tim Lion", "02.04.1979", 00004),
                new Worker(R.drawable.ic_person_black_24dp,
                        "Mio Storm", "13.09.1973", 00004)

        );
    }

    public List<Worker> getWorkers() {
        return workers;
    }
}
