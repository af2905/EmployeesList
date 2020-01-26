package ru.job4j.employees;

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
                new Worker(R.drawable.developer,
                        "John Black", "10.11.1980", 00001),
                new Worker(R.drawable.developer,
                        "Antony Lancer", "14.03.1988", 00001),
                new Worker(R.drawable.developer,
                        "Li Chang", "26.12.1979", 00001),
                new Worker(R.drawable.developer,
                        "Rick White", "11.04.1977", 00002),
                new Worker(R.drawable.developer,
                        "Leo Woodland", "03.01.1991", 00002),
                new Worker(R.drawable.developer,
                        "Tom Rock", "01.07.1996", 00003),
                new Worker(R.drawable.developer,
                        "Lori Dior", "18.05.1982", 00003),
                new Worker(R.drawable.developer,
                        "Tim Lion", "02.04.1979", 00004),
                new Worker(R.drawable.developer,
                        "Mio Storm", "13.09.1973", 00004)

        );
    }

    public List<Worker> getWorkers() {
        return workers;
    }
}
