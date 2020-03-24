package ru.job4j.employees.store;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ru.job4j.employees.model.Employee;
import ru.job4j.employees.model.Specialty;


public class SqlStore {
    private static SqlStore sqlStore;
    private EmployeeBaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;
    private Cursor cursor;


    private SqlStore(Context context) {
        this.context = context.getApplicationContext();
        dbHelper = new EmployeeBaseHelper(this.context);
    }

    public static SqlStore getInstance(Context context) {
        if (sqlStore == null) {
            sqlStore = new SqlStore(context);
        }
        return sqlStore;
    }

    public List<Specialty> getSpecialties() {
        db = dbHelper.getReadableDatabase();
        List<Specialty> specialties = new ArrayList<>();
        cursor = db.query(DbSchema.SpecialtyTable.NAME,
                null, null, null, null,
                null, null, null);
        if (cursor.moveToFirst()) {
            try {
                do {
                    Specialty specialty = new Specialty(cursor.getInt(
                            cursor.getColumnIndex(DbSchema.SpecialtyTable.Cols.ID)),
                            cursor.getString(
                                    cursor.getColumnIndex(DbSchema.SpecialtyTable.Cols.TITLE)));
                    specialties.add(specialty);
                } while (cursor.moveToNext());
            } finally {
                cursor.close();
            }
        }
        return specialties;
    }

    public List<Employee> getSelectedEmployees(int id) {
        db = dbHelper.getReadableDatabase();
        List<Employee> selectedEmployees = new ArrayList<>();
        List<Specialty> specialties = getSpecialties();
        cursor = db.query(DbSchema.EmployeeTable.NAME,
                new String[]{DbSchema.EmployeeTable.Cols.ID,
                        DbSchema.EmployeeTable.Cols.NAME,
                        DbSchema.EmployeeTable.Cols.BIRTH,
                        DbSchema.EmployeeTable.Cols.SPECIALTY_ID,
                        DbSchema.EmployeeTable.Cols.PHOTO},
                DbSchema.EmployeeTable.Cols.SPECIALTY_ID + " = ?",
                new String[]{String.valueOf(id)},
                null, null, null, null);
        Specialty specialty = null;
        for (Specialty s : specialties) {
            if (s.getId() == id) {
                specialty = s;
                break;
            }
        }
        if (cursor.moveToFirst()) {
            try {
                do {
                    Employee employee = new Employee(cursor.getInt(
                            cursor.getColumnIndex(DbSchema.EmployeeTable.Cols.ID)),
                            cursor.getString(
                                    cursor.getColumnIndex(DbSchema.EmployeeTable.Cols.NAME)),
                            cursor.getString(
                                    cursor.getColumnIndex(DbSchema.EmployeeTable.Cols.BIRTH)),
                            specialty,
                            cursor.getInt(
                                    cursor.getColumnIndex(DbSchema.EmployeeTable.Cols.PHOTO))
                    );
                    selectedEmployees.add(employee);
                } while (cursor.moveToNext());
            } finally {
                cursor.close();
            }
        }
        return selectedEmployees;
    }

    public Employee getEmployee(int employeeId) {
        db = dbHelper.getReadableDatabase();
        cursor = db.query(DbSchema.EmployeeTable.NAME,
                new String[]{DbSchema.EmployeeTable.Cols.ID,
                        DbSchema.EmployeeTable.Cols.NAME,
                        DbSchema.EmployeeTable.Cols.BIRTH,
                        DbSchema.EmployeeTable.Cols.SPECIALTY_ID,
                        DbSchema.EmployeeTable.Cols.PHOTO},
                DbSchema.EmployeeTable.Cols.ID + " = ?",
                new String[]{String.valueOf(employeeId)},
                null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return new Employee(cursor.getInt(
                cursor.getColumnIndex(DbSchema.EmployeeTable.Cols.ID)),
                cursor.getString(
                        cursor.getColumnIndex(DbSchema.EmployeeTable.Cols.NAME)),
                cursor.getString(
                        cursor.getColumnIndex(DbSchema.EmployeeTable.Cols.BIRTH)),
                new Specialty(),
                cursor.getInt(
                        cursor.getColumnIndex(DbSchema.EmployeeTable.Cols.PHOTO))
        );
    }
}
