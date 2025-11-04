package org.example.spring.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birth;
    private String drivingLicense;

    public Client() {}
    public Client(int id, String first_name, String last_name, LocalDate birth, String driving_license) {
        this.id = id;
        this.firstName = first_name;
        this.lastName = last_name;
        this.birth = birth;
        this.drivingLicense = driving_license;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth=" + birth +
                ", drivingLicense='" + drivingLicense + '\'' +
                '}';
    }

}
