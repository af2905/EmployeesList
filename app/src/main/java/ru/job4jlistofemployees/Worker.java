package ru.job4jlistofemployees;

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

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }
}
