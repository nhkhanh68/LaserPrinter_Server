package laserprint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Patient")
public class Patient {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String patientCode;
    private String name;
    private String address;
    private String dateOfBirth;

    public Patient(){}

    public Patient(String patientCode, String name, String address, String dateOfBirth){
        this.patientCode = patientCode;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<HealthRecords> healthRecords;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public List<HealthRecords> getHealthRecords() {
        return healthRecords;
    }

    public void setHealthRecords(List<HealthRecords> healthRecords) {
        this.healthRecords = healthRecords;
    }
}
