package ru.job4j.employees.store;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.job4j.employees.R;
import ru.job4j.employees.model.Employee;
import ru.job4j.employees.model.Specialty;

public class InitSql {
    private static InitSql initSql;
    private Context context;
    private SQLiteDatabase db;
    private EmployeeBaseHelper dbHelper;
    private Cursor cursor;
    private int photo = R.drawable.ic_action_name;

    private InitSql(Context context) {
        this.context = context.getApplicationContext();
        this.dbHelper = new EmployeeBaseHelper(this.context);
    }

    public static InitSql getInstance(Context context) {
        if (initSql == null) {
            initSql = new InitSql(context);
        }
        return initSql;
    }

    private final List<Specialty> specialties = new ArrayList<>(Arrays.asList(
            new Specialty("Java programmer"),
            new Specialty("Python programmer"),
            new Specialty("C+ programmer"),
            new Specialty("Android developer")
    ));

    private final List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("John Black", "10.11.1980", new Specialty(), photo),
            new Employee("Li Chang", "26.12.1979", new Specialty(), photo),
            new Employee("Rick White", "11.04.1977", new Specialty(), photo),
            new Employee("Leo Woodland", "03.01.1991", new Specialty(), photo),
            new Employee("Tom Rock", "01.07.1996", new Specialty(), photo),
            new Employee("Lori Dior", "18.05.1982", new Specialty(), photo),
            new Employee("Tim Lion", "02.04.1979", new Specialty(), photo),
            new Employee("Mio Storm", "13.09.1973", new Specialty(), photo),
            new Employee("Steve Brown", "21.12.1993", new Specialty(), photo)
    ));

    public void init() {
        db = dbHelper.getWritableDatabase();
        cursor = db.query(
                DbSchema.SpecialtyTable.NAME,
                null, null, null,
                null, null, null
        );
        if (!cursor.moveToFirst()) {
            for (Specialty specialty : specialties) {
                ContentValues specialtyValues = new ContentValues();
                specialtyValues.put(DbSchema.SpecialtyTable.Cols.TITLE, specialty.getTitle());
                long specialtyId = db.insert(
                        DbSchema.SpecialtyTable.NAME, null, specialtyValues);
                specialty.setId((int) specialtyId);
            }
        }
        cursor = db.query(
                DbSchema.EmployeeTable.NAME,
                null, null, null,
                null, null, null
        );
        if (!cursor.moveToFirst()) {
            for (Employee employee : employees) {
                int randomSpecialtyId = (int) (Math.random() * specialties.size() + 1);
                ContentValues employeeValues = new ContentValues();
                employeeValues.put(DbSchema.EmployeeTable.Cols.NAME, employee.getName());
                employeeValues.put(DbSchema.EmployeeTable.Cols.BIRTH, employee.getBirth());
                employeeValues.put(DbSchema.EmployeeTable.Cols.SPECIALTY_ID, randomSpecialtyId);
                employeeValues.put(DbSchema.EmployeeTable.Cols.PHOTO, employee.getPhoto());
                long employeeId = db.insert(
                        DbSchema.EmployeeTable.NAME, null, employeeValues);
                employee.setId((int) employeeId);
            }
            db.close();
        }
    }
}
