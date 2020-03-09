package ru.job4j.employees;

import java.util.Objects;

public class Employee {
    private int id;
    private int photo;
    private String name;
    private String dateOfBirth;
    private String specialty;

    Employee(int photo, String name, String dateOfBirth, String specialty) {
        this.photo = photo;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.specialty = specialty;
    }

    Employee(int id, int photo, String name, String dateOfBirth, String specialty) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
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
        return id == employee.id
                && photo == employee.photo
                && Objects.equals(name, employee.name)
                && Objects.equals(dateOfBirth, employee.dateOfBirth)
                && Objects.equals(specialty, employee.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, photo, name, dateOfBirth, specialty);
    }
}
