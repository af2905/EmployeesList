package ru.job4j.employees.model;

import java.util.Objects;


public class Specialty {
    private int id;
    private String title;

    public Specialty(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Specialty(String title) {
        this.title = title;
    }

    public Specialty() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Specialty specialty = (Specialty) o;
        return id == specialty.id
                && Objects.equals(title, specialty.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
