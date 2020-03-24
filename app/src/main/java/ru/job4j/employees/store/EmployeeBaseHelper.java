package ru.job4j.employees.store;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class EmployeeBaseHelper extends SQLiteOpenHelper {
    private static final String DB = "employee_list.db";
    private static final int VERSION = 1;

    EmployeeBaseHelper(@Nullable Context context) {
        super(context, DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + DbSchema.SpecialtyTable.NAME + " ("
                + DbSchema.SpecialtyTable.Cols.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DbSchema.SpecialtyTable.Cols.TITLE + " TEXT"
                + ")");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + DbSchema.EmployeeTable.NAME + " ("
                + DbSchema.EmployeeTable.Cols.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DbSchema.EmployeeTable.Cols.NAME + " TEXT, "
                + DbSchema.EmployeeTable.Cols.BIRTH + " TEXT, "
                + DbSchema.EmployeeTable.Cols.SPECIALTY_ID + " INTEGER, "
                + DbSchema.EmployeeTable.Cols.PHOTO + " INTEGER"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
