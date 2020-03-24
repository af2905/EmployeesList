package ru.job4j.employees.store;

import android.provider.BaseColumns;

class DbSchema implements BaseColumns {

    static final class SpecialtyTable {
        static final String NAME = "specialty";

        static final class Cols {
            static final String ID = BaseColumns._ID;
            static final String TITLE = "title";
        }
    }

    static final class EmployeeTable {
        static final String NAME = "employee";

        static final class Cols {
            static final String ID = BaseColumns._ID;
            static final String NAME = "name";
            static final String BIRTH = "birth";
            static final String SPECIALTY_ID = "specialty_id";
            static final String PHOTO = "photo";
        }
    }
}