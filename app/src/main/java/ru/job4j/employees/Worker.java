package ru.job4j.employees;

import java.util.Objects;

public class Worker {
    private int photo;
    private String name;
    private String dateOfBirth;
    private int specialtyId;

    public Worker(int photo, String name, String dateOfBirth, int specialtyId) {
        this.photo = photo;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.specialtyId = specialtyId;
    }

    public int getPhoto() {
        return photo;
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

    public int getSpecialtyId() {
        return specialtyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return photo == worker.photo &&
                specialtyId == worker.specialtyId &&
                Objects.equals(name, worker.name) &&
                Objects.equals(dateOfBirth, worker.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photo, name, dateOfBirth, specialtyId);
    }
}
