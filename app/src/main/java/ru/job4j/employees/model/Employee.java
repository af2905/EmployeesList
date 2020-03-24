package ru.job4j.employees.model;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String birth;
    private Specialty specialty;
    private int photo;

    public Employee(int id, String name, String birth, Specialty specialty, int photo) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.specialty = specialty;
        this.photo = photo;
    }

    public Employee(String name, String birth, Specialty specialty, int photo) {
        this.name = name;
        this.birth = birth;
        this.specialty = specialty;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
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
        return id == employee.id
                && specialty == employee.specialty
                && photo == employee.photo
                && Objects.equals(name, employee.name)
                && Objects.equals(birth, employee.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birth, specialty, photo);
    }
}
