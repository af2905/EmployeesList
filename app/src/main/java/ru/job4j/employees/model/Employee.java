package ru.job4j.employees.model;

import java.util.Objects;

public class Employee {
    private String name;
    private String dateOfBirth;
    private int specialtyId;
    private int photo;

    public Employee(String name, String dateOfBirth, int specialtyId, int photo) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.specialtyId = specialtyId;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return photo == employee.photo
                && Objects.equals(name, employee.name)
                && Objects.equals(dateOfBirth, employee.dateOfBirth)
                && Objects.equals(specialtyId, employee.specialtyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, specialtyId, photo);
    }
}
